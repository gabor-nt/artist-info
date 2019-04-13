package personal.gabornt.artistinfo.model.dto.musicbrainz;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.UUID;

public class Artist {
    private final UUID id;
    @JsonProperty("release-groups")
    private final List<Release> releaseGroups;

    public Artist() {
        id = null;
        releaseGroups = null;
    }

    public Artist(UUID id, List<Release> releaseGroups) {
        this.id = id;
        this.releaseGroups = releaseGroups;
    }

    public UUID getId() {
        return id;
    }

    public List<Release> getReleaseGroups() {
        return releaseGroups;
    }
}
