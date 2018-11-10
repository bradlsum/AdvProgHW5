// Sumner Bradley
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

    public void addDepartment(Department newDepartment){
        for (Department department : this.departments){
            if (department.getName() == newDepartment.getName()){
                System.out.println("Department is already in the store...\n");
                return;
            }
        }
        this.departments.add(newDepartment);
    }
    
    public void printDepartments(){
        for (Department department: this.getDepartments()) {
            System.out.println(department);
        }
    }

    public void printCustomers(){
        System.out.println("Name");
        for (Customer customer:
                this.getCustomers().values()) {
            System.out.println(customer);
        }
    }
}
