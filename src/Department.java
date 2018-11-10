// Sumner Bradley
import java.io.Serializable;
import java.util.ArrayList;

public abstract class Department implements Serializable {
    static int id = 0;
    private String name;
    private int departmentId;
    private Item items[] = new Item[100];
    private ArrayList<Customer> customers = new ArrayList<Customer>();
    private ArrayList<Customer> observers = new ArrayList<Customer>();

    Department(){

    }

    Department(String name){
        this.name = name;
        this.departmentId = id;
        this.id = this.id + 1;
    }

    public void enter(Customer customer){
        if (this.customers.contains(customer)) System.out.println("Customer was already in the department...");
        else this.customers.add(customer);
    }

    public void exit(Customer customer){
        if (!this.customers.contains(customer)) System.out.println("Customer was not in the department...");
        else this.customers.remove(customer);
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public Item[] getItems() {
        return items;
    }

    public void addObserver(Customer customer){
        if (this.observers.contains(customer)) System.out.println("Customer was already in the list...");
        else this.observers.add(customer);
    }

    public void removeObserver(Customer customer){
        for (int i = 0; i < this.observers.size(); ++i) {
            if (this.observers.get(i) == customer){
                this.observers.remove(i);
            }
        }
        System.out.println("Customer was not in the list...");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public ArrayList<Customer> getObservers() {
        return observers;
    }

    public void changePrice(String item, double price){
        for (int i = 0; i < this.items.length; ++i){
            if (this.items[i].getName() == item){
                this.items[i].setPrice(price);
                System.out.println("Price change on '" + item + "', notify:");
                notifyWatchers();
                return;
            }
        }
        System.out.println("No item by that name...");
    }

    public void notifyWatchers(){
        for (int i = 0; i < this.observers.size(); ++i) {
            System.out.print(this.observers.get(i).getName() + ", ");
        }
        System.out.println('\n');
    }

    public void addItem(String name, double price){
        for (int i = 0; i < this.items.length; ++i){
            if (this.items[i] == null){
                this.items[i] = new Item();
                this.items[i].setPrice(price);
                this.items[i].setName(name);
                this.items[i].setItemId(id);
                id = id++;
                this.items[i].setDepartmentId(this.departmentId);
                return;
            }
            else if (this.items[i].getName() == name) {
                System.out.println("Item is already in the list...");
                return;
            }
        }
    }

    public void printItems(){
        System.out.println("Dept.ID\t\tID\t\tName\t\tPrice");
        for (int i = 0; i <this.items.length; ++i){
            if (!(this.items[i] == null))System.out.println(this.items[i]);
        }
    }

    public void removeItem(int itemIndex) {
        for (int i = 0; i < this.items.length; ++i) {
            if (this.items[i + 1] == null) {
                this.items[itemIndex] = this.items[i];
                this.items[i] = null;
                return;
            }
        }
        System.out.println("No item at that index...");
    }

    @Override
    public String toString() {
        return this.departmentId + "\t" + this.name;
    }
}
