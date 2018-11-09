import java.io.Serializable;
import java.util.Set;

public abstract class ItemList implements Serializable {
    Item items[] = new Item[100];

    ItemList(){

    }

    ItemList(Item i){
        this.items[0] = i;
    }

    public void addItem(Item item){
        for (int i = 0; i < this.items.length; ++i){
            if (this.items[i] == null){
                this.items[i] = item;
                return;
            }
            else if (this.items[i] == item) return;
        }
        System.out.println("Item is already in the list...");
    }

    public void removeItem(Item item){
        int end = 0, empty = 0;

        for (int i = 0; i < this.items.length; ++i){
            if (this.items[i] == item) {
                this.items[i] = new Item();
                empty = i;
            }
            else if (this.items[i].getName() == ""){
                end = i -1;
            }
        }

        if (this.items[empty] == this.items[end]) {
            this.items[empty] = this.items[end];
            this.items[end] = new Item();
        }

        System.out.println("Customer was not in the store...");
    }

    @Override
    public String toString() {
        String list = "";
        for (int i = 0; i < this.items.length; ++i){
            if (this.items[i] != null){
                list += this.items[i].getName() + ", ";
            }
        }
        return list;
    }
}
