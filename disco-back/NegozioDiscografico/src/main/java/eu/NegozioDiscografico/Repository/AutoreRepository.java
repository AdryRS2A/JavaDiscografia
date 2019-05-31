package eu.NegozioDiscografico.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import eu.NegozioDiscografico.Model.Autore;

public interface AutoreRepository extends JpaRepository<Autore, Long> {

}
