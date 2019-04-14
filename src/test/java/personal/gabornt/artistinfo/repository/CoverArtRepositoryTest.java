package personal.gabornt.artistinfo.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import personal.gabornt.artistinfo.model.dto.coverartarchive.Image;
import personal.gabornt.artistinfo.service.CoverArtArchiveWebService;

import java.util.UUID;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CoverArtRepositoryTest {
    private final Image imageFrontA = new Image("imageA", singletonList("Front"));
    private final Image imageFrontB = new Image("imageB", singletonList("Front"));
    private final Image imageBack = new Image("image", singletonList("Back"));

    @Mock
    private CoverArtArchiveWebService service;

    @InjectMocks
    private CoverArtRepository repository;

    @Test
    public void getCoverImageUrl_ShouldReturnFirst() {
        when(service.getCoversForRelease(any())).thenReturn(asList(imageFrontA, imageFrontB));
        String coverImageUrl = repository.getCoverImageUrl(UUID.randomUUID());
        assertThat(coverImageUrl, equalTo("imageA"));
    }

    @Test
    public void getCoverImageUrl_ShouldReturnNotFound_WhenThereIsNoFrontCover() {
        when(service.getCoversForRelease(any())).thenReturn(asList(imageBack, imageBack));
        String coverImageUrl = repository.getCoverImageUrl(UUID.randomUUID());
        assertThat(coverImageUrl, equalTo("Cover not found"));
    }
}
