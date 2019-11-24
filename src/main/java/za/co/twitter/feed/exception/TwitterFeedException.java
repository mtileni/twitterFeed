package za.co.twitter.feed.exception;

public class TwitterFeedException extends Exception {

    public TwitterFeedException() {
        super();
    }

    public TwitterFeedException(String message) {
        super(message);
    }

    public TwitterFeedException(String message, Throwable cause) {
        super(message, cause);
    }

    public TwitterFeedException(Throwable cause) {
        super(cause);
    }

    protected TwitterFeedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
