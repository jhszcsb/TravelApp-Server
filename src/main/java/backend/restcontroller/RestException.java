package backend.restcontroller;

public class RestException extends Exception {

    private String message;

    public RestException(String msg) {
        this.message = msg;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
