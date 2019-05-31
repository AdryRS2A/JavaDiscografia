package eu.NegozioDiscografico.Model;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="canzone")
@EntityListeners(AuditingEntityListener.class) 
@JsonIdentityInfo(generator =ObjectIdGenerators.PropertyGenerator.class, property = "id")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Album {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idAlbum;
	
	@NotBlank
	private String nomeAlbum;
	
	
	@NotBlank
	@ManyToOne(fetch=FetchType.LAZY)
	private Autore autoreAlbum;
	
	
	@NotBlank
	private String genereAlbum;
	
	
	@NotBlank
	private Date dataPubblicazione;
	
	
	@NotBlank
	private double prezzoAlbum;
	
	
	@NotBlank
	private int nCd;
	
	
	@NotBlank
	private double durataAlbum;
	
	
	@NotBlank
	@ManyToOne(fetch=FetchType.LAZY)
	private Etichetta etichettaAlbum;

	
	@NotBlank
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JsonIgnore
	private List<Canzone> canzoniContenute;


	public Long getIdAlbum() {
		return idAlbum;
	}


	public void setIdAlbum(Long idAlbum) {
		this.idAlbum = idAlbum;
	}


	public String getNomeAlbum() {
		return nomeAlbum;
	}


	public void setNomeAlbum(String nomeAlbum) {
		this.nomeAlbum = nomeAlbum;
	}


	public Autore getAutoreAlbum() {
		return autoreAlbum;
	}


	public void setAutoreAlbum(Autore autoreAlbum) {
		this.autoreAlbum = autoreAlbum;
	}


	public String getGenereAlbum() {
		return genereAlbum;
	}


	public void setGenereAlbum(String genereAlbum) {
		this.genereAlbum = genereAlbum;
	}


	public Date getDataPubblicazione() {
		return dataPubblicazione;
	}


	public void setDataPubblicazione(Date dataPubblicazione) {
		this.dataPubblicazione = dataPubblicazione;
	}


	public double getPrezzoAlbum() {
		return prezzoAlbum;
	}


	public void setPrezzoAlbum(double prezzoAlbum) {
		this.prezzoAlbum = prezzoAlbum;
	}


	public int getnCd() {
		return nCd;
	}


	public void setnCd(int nCd) {
		this.nCd = nCd;
	}


	public double getDurataAlbum() {
		return durataAlbum;
	}


	public void setDurataAlbum(double durataAlbum) {
		this.durataAlbum=durataAlbum;
	}


	public Etichetta getEtichettaAlbum() {
		return etichettaAlbum;
	}


	public void setEtichettaAlbum(Etichetta etichettaAlbum) {
		this.etichettaAlbum = etichettaAlbum;
	}
	
	
	
	
}
