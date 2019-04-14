package personal.gabornt.artistinfo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import personal.gabornt.artistinfo.model.dto.musicbrainz.Artist;

import java.util.UUID;

@Service
public class MusicBrainzWebService {
    private static final String URL_TEMPLATE = "http://musicbrainz.org/ws/2/artist/%s?&fmt=json&inc=url-rels+release-groups";
    private final RestTemplate restTemplate;

    @Autowired
    public MusicBrainzWebService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Artist getArtistById(UUID id) {
        try {
            return this.restTemplate.getForObject(String.format(URL_TEMPLATE, id.toString()), Artist.class);
        } catch (HttpClientErrorException e) {
            throw new ArtistNotFound(e);
        } catch (HttpServerErrorException.ServiceUnavailable e) {
            throw new ServiceUnavailable(e);
        }
    }
}
