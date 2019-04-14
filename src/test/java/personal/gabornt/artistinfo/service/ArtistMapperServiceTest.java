package personal.gabornt.artistinfo.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import personal.gabornt.artistinfo.model.dto.Album;
import personal.gabornt.artistinfo.model.dto.ArtistDetails;
import personal.gabornt.artistinfo.model.dto.musicbrainz.Artist;
import personal.gabornt.artistinfo.model.dto.musicbrainz.Relation;
import personal.gabornt.artistinfo.model.dto.musicbrainz.Release;
import personal.gabornt.artistinfo.model.dto.musicbrainz.Url;
import personal.gabornt.artistinfo.repository.CoverArtRepository;
import personal.gabornt.artistinfo.repository.DescriptionRepository;

import java.util.UUID;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ArtistMapperServiceTest {
    private final UUID testArtistId = UUID.randomUUID();
    private final UUID testAlbumId = UUID.randomUUID();
    private final String testAlbumTitle = "testAlbumTitle";
    private final String dummyDescription = "dummyDescription";
    private final String dummyImageUrl = "dummyImageUrl";

    private final Release testRelease = new Release(testAlbumId, testAlbumTitle);
    private final Relation testRelation = new Relation(Relation.Type.discogs, new Url("discogs"));
    private final Artist testArtist = new Artist(
            testArtistId,
            asList(testRelease, testRelease, testRelease),
            asList(testRelation, testRelation)
    );

    @Mock
    private DescriptionRepository descriptionRepository;

    @Mock
    private CoverArtRepository coverArtRepository;

    @InjectMocks
    private ArtistMapperService service;

    @Before
    public void setup() {
        when(descriptionRepository.getDescription(any())).thenReturn(dummyDescription);
        when(coverArtRepository.getCoverImageUrl(testAlbumId)).thenReturn(dummyImageUrl);
    }

    @Test
    public void mapShouldBuildArtistDetailsFromAllSources() {
        ArtistDetails result = this.service.map(testArtist);
        assertThat(result.getMbid(), equalTo(testArtistId));
        assertThat(result.getDescription(), equalTo(dummyDescription));
        assertThat(result.getAlbums(), hasSize(3));

        Album album = result.getAlbums().get(0);
        assertThat(album.getId(), equalTo(testAlbumId));
        assertThat(album.getTitle(), equalTo(testAlbumTitle));
        assertThat(album.getImage(), equalTo(dummyImageUrl));
    }
}
