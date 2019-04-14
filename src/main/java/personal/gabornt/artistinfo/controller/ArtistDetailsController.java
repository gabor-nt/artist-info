package personal.gabornt.artistinfo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import personal.gabornt.artistinfo.model.dto.ArtistDetails;
import personal.gabornt.artistinfo.model.dto.ErrorMessage;
import personal.gabornt.artistinfo.repository.ArtistDetailsRepository;
import personal.gabornt.artistinfo.service.ArtistNotFound;
import personal.gabornt.artistinfo.service.ServiceUnavailable;

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

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ArtistNotFound.class)
    @ResponseBody
    public ErrorMessage notFound() {
        return new ErrorMessage("Artist not found");
    }

    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
    @ExceptionHandler(ServiceUnavailable.class)
    @ResponseBody
    public ErrorMessage unavailable() {
        return new ErrorMessage("Server capacity exceded, please try again later");
    }
}
