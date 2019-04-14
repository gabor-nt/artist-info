package personal.gabornt.artistinfo.model.dto.musicbrainz;

public class Url {
    private final String resource;

    public Url() {
        resource = null;
    }

    public Url(String resource) {
        this.resource = resource;
    }

    public String getResource() {
        return resource;
    }
}
