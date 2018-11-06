package com.arenaherois.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Heroi_copy {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long chave;
	
	private long id;
	
	private String alterego;
	private String nome;
	private String cores;
	private String criador;
	private String universo;
	private Date datacriacao;
	private String poder;
	private String sinopse;
	private String nemesis;
	private String caminhofigura;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getAlterego() {
		return alterego;
	}
	public void setAlterego(String alterego) {
		this.alterego = alterego;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCores() {
		return cores;
	}
	public void setCores(String cores) {
		this.cores = cores;
	}
	public String getCriador() {
		return criador;
	}
	public void setCriador(String criador) {
		this.criador = criador;
	}
	public String getUniverso() {
		return universo;
	}
	public void setUniverso(String universo) {
		this.universo = universo;
	}
	public Date getDatacriacao() {
		return datacriacao;
	}
	public void setDatacriacao(Date datacriacao) {
		this.datacriacao = datacriacao;
	}
	public String getPoder() {
		return poder;
	}
	public void setPoder(String poder) {
		this.poder = poder;
	}
	public String getSinopse() {
		return sinopse;
	}
	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}
	public String getNemesis() {
		return nemesis;
	}
	public void setNemesis(String nemesis) {
		this.nemesis = nemesis;
	}
	public String getCaminhofigura() {
		return caminhofigura;
	}
	public void setCaminhofigura(String caminhofigura) {
		this.caminhofigura = caminhofigura;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (chave ^ (chave >>> 32));
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
		Heroi_copy other = (Heroi_copy) obj;
		if (chave != other.chave)
			return false;
		return true;
	}
	

}