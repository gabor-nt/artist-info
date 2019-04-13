package personal.gabornt.artistinfo.model.dto.musicbrainz;

import java.util.UUID;

public class Release {
    private final UUID id;
    private final String title;

    public Release() {
        id = null;
        title = null;
    }

    public Release(UUID id, String title) {
        this.id = id;
        this.title = title;
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}
