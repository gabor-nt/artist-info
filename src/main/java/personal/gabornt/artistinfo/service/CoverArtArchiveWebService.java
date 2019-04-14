package personal.gabornt.artistinfo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import personal.gabornt.artistinfo.model.dto.coverartarchive.Image;
import personal.gabornt.artistinfo.model.dto.coverartarchive.Response;

import java.util.List;
import java.util.UUID;

import static java.util.Collections.emptyList;

@Service
public class CoverArtArchiveWebService {
    private static final String URL_TEMPLATE = "http://coverartarchive.org/release-group/%s";
    private final RestTemplate restTemplate;

    @Autowired
    public CoverArtArchiveWebService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Image> getCoversForRelease(UUID id) {
        try {
            final String url = String.format(URL_TEMPLATE, id.toString());
            final Response response = this.restTemplate.getForObject(url, Response.class);
            if (response != null) {
                return response.getImages();
            } else {
                return emptyList();
            }
        } catch (HttpClientErrorException.NotFound e) {
            return emptyList();
        }
    }
}
