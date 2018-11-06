package com.arenaherois.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Oponentes {
  
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long chaves;
	private long id1;
	private String oponente1;
	private int  pontuacao1;
	private String caminhofigura1;
	private int pontuacaoposcombate1;
	private long id2;
	private String oponente2;
	private int pontuacao2;
	private String caminhofigura2;
	private int pontuacaoposcombate2;
	
	public long getId1() {
		return id1;
	}
	public void setId1(long id1) {
		this.id1 = id1;
	}
	public String getOponente1() {
		return oponente1;
	}
	public void setOponente1(String oponente1) {
		this.oponente1 = oponente1;
	}
	public int getPontuacao1() {
		return pontuacao1;
	}
	public void setPontuacao1(int pontuacao1) {
		this.pontuacao1 = pontuacao1;
	}
	public long getId2() {
		return id2;
	}
	public void setId2(long id2) {
		this.id2 = id2;
	}
	public String getOponente2() {
		return oponente2;
	}
	public void setOponente2(String oponente2) {
		this.oponente2 = oponente2;
	}
	public int getPontuacao2() {
		return pontuacao2;
	}
	public void setPontuacao2(int pontuacao2) {
		this.pontuacao2 = pontuacao2;
	}
	public String getCaminhofigura1() {
		return caminhofigura1;
	}
	public void setCaminhofigura1(String caminhofigura1) {
		this.caminhofigura1 = caminhofigura1;
	}
	public String getCaminhofigura2() {
		return caminhofigura2;
	}
	public void setCaminhofigura2(String caminhofigura2) {
		this.caminhofigura2 = caminhofigura2;
	}
	public int getPontuacaoposcombate1() {
		return pontuacaoposcombate1;
	}
	public void setPontuacaoposcombate1(int pontuacaoposcombate1) {
		this.pontuacaoposcombate1 = pontuacaoposcombate1;
	}
	public int getPontuacaoposcombate2() {
		return pontuacaoposcombate2;
	}
	public void setPontuacaoposcombate2(int pontuacaoposcombate2) {
		this.pontuacaoposcombate2 = pontuacaoposcombate2;
	}
	public long getChaves() {
		return chaves;
	}
	public void setChaves(long chaves) {
		this.chaves = chaves;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (chaves ^ (chaves >>> 32));
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
		Oponentes other = (Oponentes) obj;
		if (chaves != other.chaves)
			return false;
		return true;
	}
}
