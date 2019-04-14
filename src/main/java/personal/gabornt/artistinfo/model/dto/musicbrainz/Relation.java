package personal.gabornt.artistinfo.model.dto.musicbrainz;

import com.fasterxml.jackson.annotation.JsonCreator;

public class Relation {
    private final Type type;
    private final Url url;

    public Relation() {
        type = null;
        url = null;
    }

    public Relation(Type type, Url url) {
        this.type = type;
        this.url = url;
    }

    public Type getType() {
        return type;
    }

    public Url getUrl() {
        return url;
    }

    public enum Type {
        discogs,
        other;

        @JsonCreator
        public static Type forValue(String v) {
            return "discogs" .equals(v) ? Type.discogs : Type.other;
        }
    }
}
