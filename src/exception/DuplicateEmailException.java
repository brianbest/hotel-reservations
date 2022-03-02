package exception;

public class DuplicateEmailException extends Exception {

    @Override
    public String getLocalizedMessage() {
        return "Email already in use!";
    }
}
