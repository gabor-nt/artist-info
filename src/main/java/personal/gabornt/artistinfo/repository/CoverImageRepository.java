package personal.gabornt.artistinfo.repository;

import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class CoverImageRepository {
    public String createImageUrl(UUID id) {
        return "http://coverartarchive.org/release/a146429a-cedc-3ab0-9e41-1aaf5f6cdc2d/3012495605.jpg";
    }
}
