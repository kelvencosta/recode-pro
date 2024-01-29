package br.recode.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "cursos")
public class Curso {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	private String imgUrl;
	
	@Column(columnDefinition = "TEXT")
	private String descricao;
	private String duracao;
	
	@OneToMany(mappedBy = "curso")
	private List<Matricula> matricula;
	
	public Curso() {
	}

	public Curso(Long id, String titulo, String imgUrl, String descricao, String duracao) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.imgUrl = imgUrl;
		this.descricao = descricao;
		this.duracao = duracao;
	}

	public long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getDuracao() {
		return duracao;
	}

	public void setDuracao(String duracao) {
		this.duracao = duracao;
	}

	public List<Matricula> getMatricula() {
		return matricula;
	}

	public void setMatricula(List<Matricula> matricula) {
		this.matricula = matricula;
	}
}
