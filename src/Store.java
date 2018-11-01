import java.util.Set;

public class Store {
    private String name;
    private Set<Department> departments;
    private Set<Customer> customers;

    Store(){
        this.name = "";
    }

    Store(String name){
        this.name = "";
    }

    public void enter(Customer customer){
        this.customers.add(customer);
    }

    public void exit(Customer customer){
        this.customers.remove(customer);
    }

    public ShoppingCart getShoppingCart(){
        return new ShoppingCart();
    }

    public WishList getWishList(){
        return new WishList();
    }

    public Set<Customer> getCustomers() {
        return customers;
    }

    public Set<Department> getDepartments() {
        return departments;
    }

    public void addDepartment(Department department){
        this.departments.add(department);
    }

    public void save(String filename){

    }

    public void load(String filename){

    }
}
