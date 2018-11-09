import java.io.*;
import java.util.*;

public class Store implements Serializable {
    static int id = 0;
    private String name;
    private ArrayList<Department> departments = new ArrayList<Department>();
    private Map<String, Customer> customers = new HashMap<String, Customer>();

    Store(){
        this.name = "";
    }

    Store(String name){
        this.name = "";
    }

    public void enter(Customer customer){
        customer.setShoppingCart(this.getShoppingCart());
        if (this.customers.containsKey(customer.getName())) System.out.println("Customer was already in the store...");
        else this.customers.put(customer.getName(), customer);
    }

    public void exit(String customer){
        if (!this.customers.containsKey(customer)) System.out.println("Customer was not in the store...");
        else this.customers.remove(customer);
    }

    public ShoppingCart getShoppingCart(){
        return new ShoppingCart();
    }

    public WishList getWishList(){
        return new WishList();
    }

    public Map<String, Customer> getCustomers() {
        return customers;
    }

    public ArrayList<Department> getDepartments() {
        return departments;
    }

    public void addDepartment(Department department){
        if (this.departments.contains(department)) System.out.println("Customer was already in the store...");
        else{
            department.setDepartmentId(id);
            id = id++;
            this.departments.add(department);
        }
    }
}
