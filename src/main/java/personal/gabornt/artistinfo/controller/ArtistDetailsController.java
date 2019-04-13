package personal.gabornt.artistinfo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import personal.gabornt.artistinfo.model.dto.Album;
import personal.gabornt.artistinfo.model.dto.ArtistDetails;
import personal.gabornt.artistinfo.repository.ArtistDetailsRepository;

import java.util.UUID;

@RestController
@RequestMapping("/artists")
public class ArtistDetailsController {
    @Autowired
    private ArtistDetailsRepository repository;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ArtistDetails getArtistDetailsById(@PathVariable UUID id) {
        return repository.getArtistDetailsById(id);
    }
}
