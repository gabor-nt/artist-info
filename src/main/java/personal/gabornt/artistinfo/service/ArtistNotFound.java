package personal.gabornt.artistinfo.service;

public class ArtistNotFound extends RuntimeException {
    public ArtistNotFound(Throwable e) {
        super(e);
    }
}
