package eu.NegozioDiscografico.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import eu.NegozioDiscografico.Model.Etichetta;

public interface EtichettaRepository extends JpaRepository<Etichetta, String> {

}
