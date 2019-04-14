package personal.gabornt.artistinfo.model.dto.discogs;

public class Artist {
    private final String profile;

    public Artist() {
        profile = null;
    }

    public Artist(String profile) {
        this.profile = profile;
    }

    public String getProfile() {
        return profile;
    }
}
