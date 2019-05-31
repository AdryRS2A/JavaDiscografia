package eu.NegozioDiscografico.Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@Table(name="autore")
@EntityListeners(AuditingEntityListener.class) 
@JsonIdentityInfo(generator =ObjectIdGenerators.PropertyGenerator.class, property = "id")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Autore {

	@Id    
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAutore;
	
	
	@NotBlank
	private String nome;
	
	@NotBlank
	private String lingua;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JsonIgnore
	private List<Album> albumIncisi;

	public Long getIdAutore() {
		return idAutore;
	}

	public void setIdAutore(Long idAutore) {
		this.idAutore = idAutore;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLingua() {
		return lingua;
	}

	public void setLingua(String lingua) {
		this.lingua = lingua;
	}

	public List<Album> getAlbumIncisi() {
		return albumIncisi;
	}

	public void setAlbumIncisi(List<Album> albumIncisi) {
		this.albumIncisi = albumIncisi;
	}
	
	
	
	
}
