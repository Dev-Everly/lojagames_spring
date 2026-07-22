package com.generation.lojagames.model;

import java.math.BigDecimal;

import org.hibernate.validator.constraints.URL;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_produtos")
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Size(max = 255, message = "O atributo nome não pode ser vazio !")
	@Column(length = 255)
	private String nome;
	
	@NotNull(message = "O preço é obrigatório")
	@PositiveOrZero(message = "O preço não pode ser negativo")
	@Column(name = "preco", nullable = false, precision = 10, scale = 2)
	private BigDecimal preco;

	@URL(message = "A foto deve ser uma URL válida") //Garante que o texto comece com Http://
	@Pattern(
	    regexp = ".*\\.(jpg|jpeg|png|gif|webp)(\\?.*)?$", 
	    flags = Pattern.Flag.CASE_INSENSITIVE, 
	    message = "A URL deve apontar para uma imagem válida (jpg, png, webp, etc.)" // Regex garante que termine com extensão de imagem conhecida
	)
	@Column(length = 500)
	private String foto;

	
	@ManyToOne
	@JsonIgnoreProperties("produto")
	private Categoria categoria;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public Produto getCategoria() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void setCategoria(Categoria categoria) {
	    this.categoria = categoria;
	}
	
	
	
}
