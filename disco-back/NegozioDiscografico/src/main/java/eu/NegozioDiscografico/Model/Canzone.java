package eu.NegozioDiscografico.Model;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="canzone")
@EntityListeners(AuditingEntityListener.class) 
@JsonIdentityInfo(generator =ObjectIdGenerators.PropertyGenerator.class, property = "id")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Canzone {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idCanzone;
	
	@NotBlank
	private String title;
	
	@NotBlank
	private String genere;
	
	@NotBlank
	private double durata;
	
	@NotBlank
	private String feat;

	@NotBlank
	@ManyToOne(fetch =FetchType.LAZY)
	private Album albumContenitore;
	
	@NotBlank
	private String mP3;

	public Long getIdCanzone() {
		return idCanzone;
	}


	public void setIdCanzone(Long idCanzone) {
		this.idCanzone = idCanzone;
	}


	public String getGenere() {
		return genere;
	}


	public void setGenere(String genere) {
		this.genere = genere;
	}


	public double getDurata() {
		return durata;
	}


	public void setDurata(double durata) {
		this.durata = durata;
	}


	public String getFeat() {
		return feat;
	}


	public void setFeat(String feat) {
		this.feat = feat;
	}


	public Album getAlbumContenitore() {
		return albumContenitore;
	}


	public void setAlbumContenitore(Album albumContenitore) {
		this.albumContenitore = albumContenitore;
	}


	public String getmP3() {
		return mP3;
	}


	public void setmP3(String mP3) {
		this.mP3 = mP3;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	
}
