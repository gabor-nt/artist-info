package personal.gabornt.artistinfo.model.dto;

public class ErrorMessage {
    private final String message;

    public ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
