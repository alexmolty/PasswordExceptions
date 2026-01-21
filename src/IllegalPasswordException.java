public class IllegalPasswordException extends Exception {
    private final String[] messages;

    public IllegalPasswordException(String[] messages) {
        this.messages = messages;
    }

    public String[] getMessages() {
        return messages;
    }
}
