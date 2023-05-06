public class ItemNotFoundException extends Exception {
    private static final long serialVersionUID = 1l;

    public ItemNotFoundException() {
        super();
    }

    public ItemNotFoundException(String msg) {
        super(msg);
    }
}
