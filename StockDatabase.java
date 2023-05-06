public class StockDatabase {

    private Item[] items;
    private int firstFreeSpace;

    public StockDatabase() {
        this.items = new Item[10];
        this.firstFreeSpace = 0;
    }

    public void addItem(final Item item) throws DuplicateItemIDException {
        if (this.containsItem(item.getId())) throw new DuplicateItemIDException("An item with ID " + item.getId() + " already exists.");

        if (this.full()) this.expand();
        this.items[this.firstFreeSpace++] = item;
    }

    public void removeItem(final String id) {
        if (this.containsItem(id)) {
            int pos = this.getItemPosition(id);
            for (int i = pos + 1; i < this.firstFreeSpace; i++) this.items[i - 1] = this.items[i];
            this.items[--this.firstFreeSpace] = null;
        }
        else{
            System.out.println("There is no item with that ID in the warehouse.");
        }
       
    }

    public void sell(final String id, final int quantity) throws InvalidQuantityException, ItemNotFoundException {
        if (!this.containsItem(id)) throw new ItemNotFoundException("No item with id " + id + " found in the database.");
        this.getItem(id).sell(quantity);
    }

    public void restock(final String id, final int quantity) throws InvalidQuantityException, ItemNotFoundException  {
        if (!this.containsItem(id)) throw new ItemNotFoundException("No item with id " + id + " found in the database.");
        this.getItem(id).restock(quantity);
        
       
    }

    @Override
    public String toString() {
        String result = "Stock Database:\n";
        for (int i = 0; i < this.firstFreeSpace; i++) {
            result += this.items[i] + "\n";
        }
        return result;
    }

    private boolean full() {
        return this.firstFreeSpace >= this.items.length;
    }

    private void expand() {
        Item[] expanded = new Item[this.items.length > 0 ? 2*this.items.length : 1];
        for (int i = 0; i < this.firstFreeSpace; i++) expanded[i] = items[i];
        if (this.full()) this.firstFreeSpace++;
        this.items = expanded;
    }

    private int getItemPosition(final String id) {
        for (int i = 0; i < this.firstFreeSpace; i++)
            if (this.items[i] != null && this.items[i].getId().equals(id)) return i;
        return -1;
    }

    private Item getItem(final String id) {
        int pos = this.getItemPosition(id);
        if (pos == -1) return null;
        else return this.items[pos];
    }

    private boolean containsItem(final String id) {
        return this.getItemPosition(id) != -1;
    }
}
