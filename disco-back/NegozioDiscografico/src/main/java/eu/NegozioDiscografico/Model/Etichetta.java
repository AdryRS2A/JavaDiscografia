package eu.NegozioDiscografico.Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
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
@Table(name="etichetta")
@EntityListeners(AuditingEntityListener.class) 
@JsonIdentityInfo(generator =ObjectIdGenerators.PropertyGenerator.class, property = "id")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Etichetta {

	@NotBlank
	private String ragioneSociale;
	
	@Id
	private String partitaIva;
	
	@OneToMany(cascade=CascadeType.ALL, fetch= FetchType.LAZY, mappedBy= "etichettaAlbum")
	@JsonIgnore
	private List<Album> albumProdotti;
	
	public void setRagioneSociale(String ragioneSociale) {
		
		this.ragioneSociale=ragioneSociale;
	}
	
	public String getRagioneSociale() {
		return this.ragioneSociale;
		
	}
	public String getPartitaIva() {
		
		return this.partitaIva;
	}
	public void setPartitaIva(String partitaIva) {
		
		this.partitaIva=partitaIva;
	}
}
