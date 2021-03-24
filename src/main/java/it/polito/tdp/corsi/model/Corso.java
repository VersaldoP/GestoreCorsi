package it.polito.tdp.corsi.model;

public class Corso {
	
	private String codins;
	private Integer crediti;
	private Integer pd;
	private String nome;
	
	
	
	
	
	public Corso(String codins, Integer crediti,String nome,Integer pd) {
		super();
		this.codins = codins;
		this.crediti = crediti;
		this.pd = pd;
		this.nome = nome;
	}
	public void setCodins(String codins) {
		this.codins = codins;
	}
	public void setCrediti(int crediti) {
		this.crediti = crediti;
	}
	public void setPd(int pd) {
		this.pd = pd;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCodins() {
		return codins;
	}
	public int getCrediti() {
		return crediti;
	}
	public int getPd() {
		return pd;
	}
	public String getNome() {
		return nome;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codins == null) ? 0 : codins.hashCode());
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
		Corso other = (Corso) obj;
		if (codins == null) {
			if (other.codins != null)
				return false;
		} else if (!codins.equals(other.codins))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Corso [codins=" + codins + ", crediti=" + crediti + ", pd=" + pd + ", nome=" + nome + "]";
	}
	
	

}
