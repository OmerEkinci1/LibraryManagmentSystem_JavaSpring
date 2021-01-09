package com.jrp.lmo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "publishers")
public class Yayınevi {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long yayineviId;
	
	@Column(length = 30)
	private String yayineviAdi;
	
	@Column(length = 100)
	private String aciklama;
	
	public Yayınevi() {
		
	}
	
	public Yayınevi(long yayineviId, String yayineviAdi, String aciklama) {
		super();
		this.yayineviId = yayineviId;
		this.yayineviAdi = yayineviAdi;
		this.aciklama = aciklama;
	}
	public long getYayineviId() {
		return yayineviId;
	}
	public void setYayineviId(long yayineviId) {
		this.yayineviId = yayineviId;
	}
	public String getYayineviAdi() {
		return yayineviAdi;
	}
	public void setYayineviAdi(String yayineviAdi) {
		this.yayineviAdi = yayineviAdi;
	}
	public String getAciklama() {
		return aciklama;
	}
	public void setAciklama(String aciklama) {
		this.aciklama = aciklama;
	}
	
	

}
