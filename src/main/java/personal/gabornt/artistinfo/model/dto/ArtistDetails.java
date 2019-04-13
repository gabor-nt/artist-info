package personal.gabornt.artistinfo.model.dto;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class ArtistDetails {
    private final UUID mbid;
    private List<Album> albums;

    public ArtistDetails(UUID id) {
        mbid = id;
        albums = new LinkedList<>();
    }

    public UUID getMbid() {
        return mbid;
    }

    public List<Album> getAlbums() {
        return albums;
    }

    public void addAlbum(Album album) {
        albums.add(album);
    }
}
