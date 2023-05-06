public class Item {

    private final String id;
    private final String name;
    private int quantity;

    public Item(final String id, final String name) {
        this(id, name, 0);
    }

    public Item(final String id, final String name, final int quantity) {
        this.id = id;
        this.name = name;
        this.quantity = quantity > 0 ? quantity : 0;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void restock(final int quantity) throws InvalidQuantityException {

        if (quantity < 0) {
            throw new InvalidQuantityException("Cannot restock a negative quantity.");
        }

        this.quantity += quantity;
    }

    public void sell(final int quantity) throws InvalidQuantityException {

        if (quantity < 0) {
            throw new InvalidQuantityException("Cannot sell a negative quanity.");
        }

        if (quantity > this.quantity) {
            throw new InvalidQuantityException("Insufficient stock of item " + this.toString() + " to sell " + quantity + ".");
        }

        this.quantity -= quantity;
    }

    @Override
    public String toString() {
        return name + " (ID: " + id + ", Stock: " + quantity + ")";
    }
}
