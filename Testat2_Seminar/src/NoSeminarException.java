public class NoSeminarException extends Exception {
    public NoSeminarException() {
        this("No Semniar");
    }
    public NoSeminarException(String message) {
        super(message);
    }
}