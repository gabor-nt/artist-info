package personal.gabornt.artistinfo.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import personal.gabornt.artistinfo.model.dto.coverartarchive.Image;
import personal.gabornt.artistinfo.model.dto.coverartarchive.Response;

import java.util.List;
import java.util.UUID;

import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CoverArtArchiveWebServiceTest {
    private final Image image = new Image("image", asList("b", "c"));
    private final Response response = new Response(asList(image, image));
    private final UUID id = UUID.randomUUID();

    @Mock
    RestTemplate restTemplate;

    @InjectMocks
    CoverArtArchiveWebService service;

    @Test
    public void getCoversForRelease_ShouldReturnEmptyList_WhenResponseIsNull() {
        List<Image> output = service.getCoversForRelease(UUID.randomUUID());

        assertThat(output, hasSize(0));
    }

    @Test
    public void getCoversForRelease_ShouldReturnEmptyList_WhenStatusCodeIsNotOk() {
        when(restTemplate.getForObject(
                "http://coverartarchive.org/release-group/" + id.toString(),
                Response.class
        )).thenThrow(HttpClientErrorException.create(HttpStatus.NOT_FOUND, "", HttpHeaders.EMPTY, null, null));

        List<Image> output = service.getCoversForRelease(id);

        assertThat(output, hasSize(0));
    }

    @Test
    public void getCoversForRelease_ShouldReturnList() {
        when(restTemplate.getForObject(
                "http://coverartarchive.org/release-group/" + id.toString(),
                Response.class
        )).thenReturn(response);

        List<Image> output = service.getCoversForRelease(id);

        assertThat(output, hasSize(2));
    }

}
