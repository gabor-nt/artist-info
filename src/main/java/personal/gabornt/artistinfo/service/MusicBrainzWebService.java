package personal.gabornt.artistinfo.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import personal.gabornt.artistinfo.model.dto.musicbrainz.Artist;

import java.util.UUID;

@Service
public class MusicBrainzWebService {
    private static final String URL_TEMPLATE = "http://musicbrainz.org/ws/2/artist/%s?&fmt=json&inc=url-rels+release-groups";
    private final RestTemplate restTemplate = new RestTemplate();

    public Artist getArtistById(UUID id) {
        return this.restTemplate.getForObject(String.format(URL_TEMPLATE, id.toString()), Artist.class);
    }
}
