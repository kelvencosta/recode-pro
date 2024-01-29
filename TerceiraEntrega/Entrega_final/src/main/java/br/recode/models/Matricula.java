package br.recode.models;

import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "matriculas")
public class Matricula {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "data_matricula")
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate data;

	@ManyToOne
	@JoinColumn(name = "usuario_id", nullable = false)
	private Usuario usuario;

	@ManyToOne
	@JoinColumn(name = "curso_id", nullable = false)
	private Curso curso;

	public Matricula(Long id, LocalDate data, Usuario usuario, Curso curso) {
		super();
		this.id = id;
		this.data = data;
		this.usuario = usuario;
		this.curso = curso;
	}

	public void setAlunoId(Long alunoId) {
		if (usuario == null) {
			usuario = new Usuario();
		}
		usuario.setId(alunoId);
	}

	public void setCursoId(Long cursoId) {
		if (curso == null) {
			curso = new Curso();
		}
		curso.setId(cursoId);
	}

	public Matricula() {
		this.data = LocalDate.now();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public Usuario getAluno() {
		return usuario;
	}

	public void setAluno(Usuario usuario) {
		this.usuario = usuario;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

}