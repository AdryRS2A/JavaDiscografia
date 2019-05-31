package eu.NegozioDiscografico.Service;

import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import eu.NegozioDiscografico.Exeption.NotFoundException;
import eu.NegozioDiscografico.Model.Canzone;
import eu.NegozioDiscografico.Repository.CanzoneRepository;

public class CanzoneService {

	
	@Autowired
	CanzoneRepository canzoneRep;
	
	@Transactional
	public List<Canzone> allCanzoni(){
		 List<Canzone> canzoni=canzoneRep.findAll();
		 
		 canzoni.stream().forEach(index ->Hibernate.initialize(index.getAlbumContenitore()));
		 return canzoni;
		
	}
	@Transactional
	public Canzone getOneCanzoneById(Long idCanzone) {
		
		Canzone canzone = canzoneRep.findById(idCanzone).orElseThrow(()->new NotFoundException("Canzone :", "codice ID non trovato controllare il seriale  ", idCanzone));
		
		Hibernate.initialize(canzone.getAlbumContenitore());
		
		return canzone;
	}
	@Transactional
	public Canzone CreateNewCanzone(Canzone canzoneNew) {
		
		Hibernate.initialize(canzoneNew.getAlbumContenitore());
		return canzoneRep.save(canzoneNew);
		
	}
	@Transactional
	public Canzone modifyCanzone(Long idCanzone,Canzone canzone) {
		
		Canzone findCanzone= canzoneRep.findById(idCanzone).orElseThrow(()->new NotFoundException("Canzone :", "codice ID non trovato controllare il seriale  ", idCanzone));
		findCanzone.setAlbumContenitore(canzone.getAlbumContenitore());
		findCanzone.setDurata(canzone.getDurata());
		findCanzone.setFeat(canzone.getFeat());
		findCanzone.setGenere(canzone.getGenere());
		Canzone canzoneNew=canzoneRep.save(findCanzone);
		
		Hibernate.initialize(canzoneNew.getAlbumContenitore());
		return canzoneNew;
	}
	@Transactional
	public void deleteCanzone(Long idCanzone) {
		
	Canzone findCanzone=canzoneRep.findById(idCanzone).orElseThrow(()->new NotFoundException("Canzone :", "codice ID non trovato controllare il seriale  ", idCanzone));
		
	canzoneRep.delete(findCanzone);
	}
	@Transactional
	public List<Canzone> findByTitle(String titoloRicerca){
		
		List<Canzone> canzoni=canzoneRep.findCanzoneByTitle(titoloRicerca);
		
		canzoni.stream().forEach(index->Hibernate.initialize(index.getAlbumContenitore()));
		
		return canzoni;
		
	}
}
