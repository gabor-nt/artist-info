package personal.gabornt.artistinfo.model.dto.coverartarchive;

import java.util.List;

public class Image {
    private final String image;
    private final List<String> types;

    public Image() {
        this.image = null;
        this.types = null;
    }

    public Image(String image, List<String> types) {
        this.image = image;
        this.types = types;
    }

    public String getImage() {
        return image;
    }

    public List<String> getTypes() {
        return types;
    }
}
