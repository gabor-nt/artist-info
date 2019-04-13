package personal.gabornt.artistinfo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import personal.gabornt.artistinfo.model.dto.Album;
import personal.gabornt.artistinfo.model.dto.ArtistDetails;

import java.util.UUID;

@RestController
@RequestMapping("/artists")
public class ArtistsController {
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ArtistDetails getDetailsById(@PathVariable UUID id) {
        ArtistDetails artistDetails = new ArtistDetails(id);
        artistDetails.addAlbum(new Album(UUID.randomUUID(),"test","test"));
        return artistDetails;
    }
}
