package com.shiromabruno.modelconceitual.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Cidade implements Serializable{
	//Serializable = indica que os OBJs desta classe pode ser convertido em sequencia de Bytes
	//para que OBJs possam ser gravados em arquivos, trafegar em redes... etc
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	
	
	
	// esse comando eh pra fazer referencia ciclica somente aqui, e nao nos estados, senao cidade tem estado
	// e esses estado tem cidades, que por sua vez tem estado, que por sua vez tem cidade...
		// UPDATE ultima aula: JsonManagedReference e JsonBackReference estava dando problema na hora da requisicao
		// no envio de dados Json em requisicao.
		//Solucao: tirar JsonManagedReference. No JsonBackReference, tirar ele e colocar o JsonIgnore
//	@JsonManagedReference
	//associacao / coleções
	//a cidade possui (ou pertence) a 1 estado
	//Nome da chave estrangeira estado_id.
	// Nome da chave estrangeira da tabela cidade no banco de dados
	//JPA ORM
	@ManyToOne
	@JoinColumn(name="estado_id")
	private Estado estado;
	
	public Cidade () {
		
	}

	public Cidade(Integer id, String nome, Estado estado) {
		super();
		this.id = id;
		this.nome = nome;
		this.estado = estado;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cidade other = (Cidade) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
