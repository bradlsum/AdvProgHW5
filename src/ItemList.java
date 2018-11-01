import java.util.Set;

public abstract class ItemList {
    Set<Item> items;

    ItemList(){

    }

    ItemList(Item i){
        this.items.add(i);
    }

    public void addItem(Item i){
        if (!this.items.contains(i)) this.items.add(i);
        else System.out.println("Item is already in the list...");
    }

    public void removeItem(Item i){
        if (this.items.contains(i)) this.items.remove(i);
        else System.out.println("Item is not in the list...");
    }
}
