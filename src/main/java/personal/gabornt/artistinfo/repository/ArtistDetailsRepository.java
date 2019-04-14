package personal.gabornt.artistinfo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import personal.gabornt.artistinfo.model.dto.musicbrainz.Artist;
import personal.gabornt.artistinfo.service.ArtistMapperService;
import personal.gabornt.artistinfo.service.MusicBrainzWebService;
import personal.gabornt.artistinfo.model.dto.ArtistDetails;

import java.util.UUID;

@Repository
public class ArtistDetailsRepository {
    private final MusicBrainzWebService musicBrainzWebService;
    private final ArtistMapperService artistMapperService;

    @Autowired
    public ArtistDetailsRepository(MusicBrainzWebService musicBrainzWebService, ArtistMapperService artistMapperService) {
        this.musicBrainzWebService = musicBrainzWebService;
        this.artistMapperService = artistMapperService;
    }

    @Cacheable("artists")
    public ArtistDetails getArtistDetailsById(UUID id) {
        Artist artist = musicBrainzWebService.getArtistById(id);
        return artistMapperService.map(artist);
    }
}
