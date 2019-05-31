package eu.NegozioDiscografico.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import eu.NegozioDiscografico.Model.Album;
import eu.NegozioDiscografico.Service.AlbumService;

@RestController
@RequestMapping("/api")
public class AlbumController {

	@Autowired
	AlbumService alServ;

	@GetMapping("/album")
	public List<Album> getAllAlbum() {

		return alServ.getAllAlbum();
	}

	@GetMapping("/album{id}")
	public Album findOnebyId(@PathVariable(value = "id") Long idAlbum) {

		return alServ.getAlbumFindId(idAlbum);

	}

	@PostMapping("/album")
	public Album newAlbum(@Valid @RequestBody Album album) {

		return alServ.createNewAlbum(album);

	}

	@PutMapping("/album{id}")
	public Album putAlbum(@PathVariable(value = "id") Long idAlbum, @Valid @RequestBody Album album) {

		return alServ.putAlbum(idAlbum, album);

	}

	@DeleteMapping("/album{id}")
	public void deleteAlbum(@PathVariable(value = "id") Long idAlbum) {

		alServ.deleteAlbum(idAlbum);
	}

}
