package personal.gabornt.artistinfo.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Album {
    private final UUID id;
    private final String title;
    @JsonProperty("Image")
    private final String image;

    public Album(UUID id, String title, String image) {
        this.id = id;
        this.title = title;
        this.image = image;
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }
}
