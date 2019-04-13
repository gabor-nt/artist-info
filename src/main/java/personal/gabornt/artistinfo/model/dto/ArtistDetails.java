package personal.gabornt.artistinfo.model.dto;

import java.util.UUID;

public class ArtistDetails {
    private final UUID mbid;

    public ArtistDetails(UUID id) {
        mbid = id;
    }

    public UUID getMbid() {
        return mbid;
    }
}
