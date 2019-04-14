package personal.gabornt.artistinfo.model.dto.coverartarchive;

import java.util.Collections;
import java.util.List;

public class Response {
    private final List<Image> images;

    public Response() {
        this.images = Collections.emptyList();
    }

    public Response(List<Image> images) {
        this.images = images;
    }

    public List<Image> getImages() {
        return images;
    }
}
