package personal.gabornt.artistinfo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import personal.gabornt.artistinfo.model.dto.coverartarchive.Image;
import personal.gabornt.artistinfo.service.CoverArtArchiveWebService;

import java.util.UUID;

@Repository
public class CoverArtRepository {

    private final CoverArtArchiveWebService webService;

    @Autowired
    public CoverArtRepository(CoverArtArchiveWebService webService) {
        this.webService = webService;
    }

    public String getCoverImageUrl(UUID id) {
        return webService.getCoversForRelease(id).stream()
                .filter(image -> image.getTypes().contains("Front"))
                .map(Image::getImage)
                .findFirst().orElse("Cover not found");
    }
}
