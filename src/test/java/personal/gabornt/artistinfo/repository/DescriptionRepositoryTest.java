package personal.gabornt.artistinfo.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import personal.gabornt.artistinfo.model.dto.discogs.Artist;
import personal.gabornt.artistinfo.service.DiscogsWebService;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DescriptionRepositoryTest {
    @Mock
    private DiscogsWebService service;

    @InjectMocks
    private DescriptionRepository repo;

    @Test
    public void getDescription_ShouldParseId() {
        String expectedDescription = "x";
        String testId = "125246";
        when(service.getArtist(testId)).thenReturn(new Artist(expectedDescription));

        String actualDescription = repo.getDescription("https://www.discogs.com/artist/" + testId);

        assertThat(actualDescription, equalTo(expectedDescription));
    }
}
