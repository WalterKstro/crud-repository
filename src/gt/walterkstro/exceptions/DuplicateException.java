package gt.walterkstro.exceptions;

public class DuplicateException extends WriteException{
    public DuplicateException(String message) {
        super(message);
    }
}
