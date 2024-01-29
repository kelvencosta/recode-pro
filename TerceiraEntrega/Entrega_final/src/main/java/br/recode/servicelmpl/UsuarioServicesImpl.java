package br.recode.servicelmpl;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.recode.models.Usuario;
import br.recode.models.Role;
import br.recode.repositories.UsuarioRepository;
import br.recode.repositories.RoleRepository;
import br.recode.services.UsuarioService;
import jakarta.transaction.Transactional;

@Service
public class UsuarioServicesImpl implements UsuarioService, UserDetailsService {
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired 
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public List<Usuario> getAllAlunos() {
		return usuarioRepository.findAll();
		}
	
	@Override
	@Transactional
	public Usuario getAlunoById(Long id) {
		return usuarioRepository.findById(id).orElse(null);
	}
	
	@Override
	@Transactional
	public Usuario findByNomeUsuario(String nomeUsuario) {
		return usuarioRepository.findByNomeUsuario(nomeUsuario);
	}

	@Override
	@Transactional
	public Usuario saveAluno(Usuario usuario) {

		usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
		
		Role role = roleRepository.findByAuthority("ROLE_COMUM");
		
		if (role == null) { 
			throw new IllegalStateException("'ROLE_COMUM' não encontrada.");
		}
		
		usuario.setRoles((List<Role>) Arrays.asList(role));
		
		return usuarioRepository.save(usuario);
	}

	@Override
	public Usuario updateAluno(Long id, Usuario alunoAtualizado) {
		Usuario alunoExistente = usuarioRepository.findById(id).orElse(null);
		if (alunoExistente != null) { 
			alunoExistente.setNome(alunoAtualizado.getNome());
			alunoExistente.setSobrenome(alunoAtualizado.getSobrenome());
			alunoExistente.setEmail(alunoAtualizado.getEmail());
			alunoExistente.setNomeUsuario(alunoAtualizado.getNomeUsuario());
			alunoExistente.setTelefone(alunoAtualizado.getTelefone());
			alunoExistente.setSenha(alunoExistente.getSenha());

			return usuarioRepository.save(alunoExistente);
		} else { 
			throw new RuntimeException("Aluno(a) com o ID" + id + "não encontrado(a).");
		}
	}

	@Override
	public void deleteAluno(Long id) {
		Usuario usuario = usuarioRepository.findById(id).orElse(null);

	    if (usuario != null) {
	        usuario.getRoles().clear();

	        usuarioRepository.deleteById(id);
	    }
	}

	@Override
	public UserDetails loadUserByUsername(String nomeUsuario) throws UsernameNotFoundException {
		Usuario user = usuarioRepository.findByNomeUsuario(nomeUsuario);
		
		if (user != null) { 
			return new org.springframework.security.core.userdetails.User(user.getNomeUsuario(), user.getSenha(),
					mapRolesToAuthorities(user.getRoles()));
		} else { 
			throw new UsernameNotFoundException("Username ou senha inválidos.");
		}
	}
	
	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
		Collection<? extends GrantedAuthority> mapRoles = roles.stream()
				.map(role -> new SimpleGrantedAuthority(role.getAuthority())).collect(Collectors.toList());
		return mapRoles;
	}
}
