import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Store {
    private String name;
    private ArrayList<Department> departments = new ArrayList<Department>();
    private ArrayList<Customer> customers = new ArrayList<Customer>();

    Store(){
        this.name = "";
    }

    Store(String name){
        this.name = "";
    }

    public void enter(Customer customer){
        customer.setShoppingCart(this.getShoppingCart());
        if (this.customers.contains(customer)) System.out.println("Customer was already in the store...");
        else this.customers.add(customer);
    }

    public void exit(Customer customer){
        if (!this.customers.contains(customer)) System.out.println("Customer was not in the store...");
        else this.customers.remove(customer);
    }

    public ShoppingCart getShoppingCart(){
        return new ShoppingCart();
    }

    public WishList getWishList(){
        return new WishList();
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public ArrayList<Department> getDepartments() {
        return departments;
    }

    public void addDepartment(Department department){
        if (this.departments.contains(department)) System.out.println("Customer was already in the store...");
        else this.departments.add(department);
    }

    public void save(){

    }

    public void load(){

    }
}
