package personal.gabornt.artistinfo.service;

public class ServiceUnavailable extends RuntimeException {
    public ServiceUnavailable(Throwable e) {
        super(e);
    }
}
