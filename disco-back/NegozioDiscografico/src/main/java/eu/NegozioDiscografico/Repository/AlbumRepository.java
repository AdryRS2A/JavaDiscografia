package eu.NegozioDiscografico.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import eu.NegozioDiscografico.Model.Album;

public interface AlbumRepository extends JpaRepository<Album,Long> {

}
