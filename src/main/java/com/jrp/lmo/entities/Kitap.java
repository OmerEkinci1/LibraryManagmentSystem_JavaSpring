package com.jrp.lmo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "books")
public class Kitap {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long kitapId;
	
	@Column(length = 30)
	private String kitapAdi;
	
	@Column(length = 30)
	private String kitapAltAdi;
	
	@Column(length = 50)
	private String kitapSeriAdi;
	
	@Column(length = 5)
	private long yazarId;
	
	@Column(length = 5)
	private long yayineviId;
	
	@Column(length = 20)
	private String isbnNo;
	
	@Column(length = 100)
	private String aciklama;
	
	public Kitap() {
		
	}
	
	public Kitap(long kitapId, String kitapAdi, String kitapAltAdi, String kitapSeriAdi, long yazarId, long yayineviId,
			String isbnNo, String aciklama) {
		super();
		this.kitapId = kitapId;
		this.kitapAdi = kitapAdi;
		this.kitapAltAdi = kitapAltAdi;
		this.kitapSeriAdi = kitapSeriAdi;
		this.yazarId = yazarId;
		this.yayineviId = yayineviId;
		this.isbnNo = isbnNo;
		this.aciklama = aciklama;
	}
	public long getKitapId() {
		return kitapId;
	}
	public void setKitapId(long kitapId) {
		this.kitapId = kitapId;
	}
	public String getKitapAdi() {
		return kitapAdi;
	}
	public void setKitapAdi(String kitapAdi) {
		this.kitapAdi = kitapAdi;
	}
	public String getKitapAltAdi() {
		return kitapAltAdi;
	}
	public void setKitapAltAdi(String kitapAltAdi) {
		this.kitapAltAdi = kitapAltAdi;
	}
	public String getKitapSeriAdi() {
		return kitapSeriAdi;
	}
	public void setKitapSeriAdi(String kitapSeriAdi) {
		this.kitapSeriAdi = kitapSeriAdi;
	}
	public long getYazarId() {
		return yazarId;
	}
	public void setYazarId(long yazarId) {
		this.yazarId = yazarId;
	}
	public long getYayineviId() {
		return yayineviId;
	}
	public void setYayineviId(long yayineviId) {
		this.yayineviId = yayineviId;
	}
	public String getIsbnNo() {
		return isbnNo;
	}
	public void setIsbnNo(String isbnNo) {
		this.isbnNo = isbnNo;
	}
	public String getAciklama() {
		return aciklama;
	}
	public void setAciklama(String aciklama) {
		this.aciklama = aciklama;
	}
	
}
