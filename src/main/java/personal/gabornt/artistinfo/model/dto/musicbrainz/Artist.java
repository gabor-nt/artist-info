package personal.gabornt.artistinfo.model.dto.musicbrainz;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.UUID;

public class Artist {
    private final UUID id;
    @JsonProperty("release-groups")
    private final List<Release> releaseGroups;
    private final List<Relation> relations;

    public Artist() {
        id = null;
        releaseGroups = null;
        relations = null;
    }

    public Artist(
            UUID id,
            List<Release> releaseGroups,
            List<Relation> relations
    ) {
        this.id = id;
        this.releaseGroups = releaseGroups;
        this.relations = relations;
    }

    public UUID getId() {
        return id;
    }

    public List<Release> getReleaseGroups() {
        return releaseGroups;
    }

    public List<Relation> getRelations() {
        return relations;
    }
}
