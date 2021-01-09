package com.jrp.lmo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "authors")
public class Yazar {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long yazarId;
	
	@Column(length = 20)
	private String yazarAdi;
	
	@Column(length = 100)
	private String aciklama;
	
	public Yazar() {
		
	}
	
	public Yazar(long yazarId, String yazarAdi, String aciklama) {
		super();
		this.yazarId = yazarId;
		this.yazarAdi = yazarAdi;
		this.aciklama = aciklama;
	}
	public long getYazarId() {
		return yazarId;
	}
	public void setYazarId(long yazarId) {
		this.yazarId = yazarId;
	}
	public String getYazarAdi() {
		return yazarAdi;
	}
	public void setYazarAdi(String yazarAdi) {
		this.yazarAdi = yazarAdi;
	}
	public String getAciklama() {
		return aciklama;
	}
	public void setAciklama(String aciklama) {
		this.aciklama = aciklama;
	}
	
	

}
