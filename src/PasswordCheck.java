import java.util.ArrayList;
import java.util.List;

public class PasswordCheck {
    public final static String WRONG_LENGTH_MESSAGE = "wrong length";
    public final static String NO_UPPER_CASE_MESSAGE = "no upper case letter";
    public final static String NO_LOWER_CASE_MESSAGE = "no lower case letter";
    public final static String NO_DIGIT_MESSAGE = "no digit";
    public final static String NO_SPEC_SYMBOL_MESSAGE = "no symbol";
    public final static String WRONG_SYMBOL_MESSAGE = "wrong symbol";
    public final static String NULL = "null";

    public static void check(String password) throws IllegalPasswordException {
        List<String> errors = new ArrayList<>();
        if(password == null) {
            throw new IllegalArgumentException(NULL);
        } else if (password.length() < 8) {
            errors.add(WRONG_LENGTH_MESSAGE);
        } else if (password.matches(".*\\s.*")) {
            errors.add(WRONG_SYMBOL_MESSAGE);
        } else {
            if (!password.matches(".*[A-Z].*")) {
                errors.add(NO_UPPER_CASE_MESSAGE);
            }
            if (!password.matches(".*[a-z].*")) {
                errors.add(NO_LOWER_CASE_MESSAGE);
            }
            if (!password.matches(".*\\d.*")) {
                errors.add(NO_DIGIT_MESSAGE);
            }
            if (!password.matches(".*[^\\s\\d\\p{L}].*")) {
                errors.add(NO_SPEC_SYMBOL_MESSAGE);
            }
        }
        if (!errors.isEmpty()) {
            throw new IllegalPasswordException(errors.toArray(new String[0]));
        }
    }
}
