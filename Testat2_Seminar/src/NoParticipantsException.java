public class NoParticipantsException extends Exception {
    public NoParticipantsException() {
        this("NoParticipants");
    }
    public NoParticipantsException(String message) {
        super(message);
    }
}