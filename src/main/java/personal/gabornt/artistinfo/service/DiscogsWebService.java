package personal.gabornt.artistinfo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import personal.gabornt.artistinfo.model.dto.discogs.Artist;

@Service
public class DiscogsWebService {
    private static final String URL_TEMPLATE = "https://api.discogs.com/artists/%s";
    private final RestTemplate restTemplate;

    @Autowired
    public DiscogsWebService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Artist getArtist(String id) {
        return this.restTemplate.getForObject(String.format(URL_TEMPLATE, id), Artist.class);
    }
}
