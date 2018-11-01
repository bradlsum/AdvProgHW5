import java.util.Set;

public abstract class Department {
    private String name;
    private int departmentId;
    private Set<Item> items;
    private Set<Customer> customers;
    private Set<Customer> observers;

    Department(){

    }

    Department(String name, int departmentId){
        this.name = name;
        this.departmentId = departmentId;
    }

    public void enter(Customer customer){
        customers.add(customer);
    }

    public void exit(Customer customer){
        customers.remove(customer);
    }

    public Set<Customer> getCustomers() {
        return customers;
    }

    public Set<Item> getItems() {
        return items;
    }

    public void addCustomer(Customer customer){
        this.customers.add(customer);
    }

    public void removeCustomer(Customer customer){
        this.customers.remove(customer);
    }

    public void addObserver(Customer customer){
        this.observers.add(customer);
    }

    public void removeObserver(Customer customer){
        this.observers.remove(customer);
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

    public Set<Customer> getObservers() {
        return observers;
    }

}
