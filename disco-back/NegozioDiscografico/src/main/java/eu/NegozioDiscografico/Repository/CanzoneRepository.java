package eu.NegozioDiscografico.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import eu.NegozioDiscografico.Model.Canzone;

public interface CanzoneRepository extends JpaRepository<Canzone,Long> {

	public List<Canzone> findCanzoneByTitle(String titoloRicerca);
	
}
