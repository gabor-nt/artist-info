package personal.gabornt.artistinfo.model.dto;

import java.util.List;
import java.util.UUID;

public class ArtistDetails {
    private final UUID mbid;
    private final String description;
    private final List<Album> albums;

    public ArtistDetails(UUID id, String description, List<Album> albums) {
        this.mbid = id;
        this.description = description;
        this.albums = albums;
    }

    public UUID getMbid() {
        return mbid;
    }

    public String getDescription() {
        return description;
    }

    public List<Album> getAlbums() {
        return albums;
    }
}
