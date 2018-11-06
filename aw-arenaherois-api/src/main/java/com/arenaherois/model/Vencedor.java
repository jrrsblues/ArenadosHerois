package com.arenaherois.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Entity;

@Entity
public class Vencedor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long chave;
	private int pontos;
	private String alterego;
	
	public long getChave() {
		return chave;
	}
	public void setChave(long chave) {
		this.chave = chave;
	}
	public String getAlterego() {
		return alterego;
	}
	public void setAlterego(String alterego) {
		this.alterego = alterego;
	}
	public int getPontos() {
		return pontos;
	}
	public void setPontos(int pontos) {
		this.pontos = pontos;
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
		Vencedor other = (Vencedor) obj;
		if (chave != other.chave)
			return false;
		return true;
	}
	

}
