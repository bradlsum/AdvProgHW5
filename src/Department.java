import java.util.Set;

public abstract class Department {
    private String name;
    private int departmentId;
    private Item items[] = new Item[100];
    private Customer customers[] = new Customer[100];
    private Customer observers[] = new Customer[100];

    Department(){

    }

    Department(String name, int departmentId){
        this.name = name;
        this.departmentId = departmentId;
    }

    public void enter(Customer customer){
        for (int i = 0; i < this.customers.length; ++i){
            if (this.customers[i] == customer) return;
            else if (this.customers[i].getName() == "") this.customers[i] = customer;
        }
        System.out.println("Customer was already in the store...");
    }

    public void exit(Customer customer){
        int end = 0, empty = 0;

        for (int i = 0; i < this.customers.length; ++i){
            if (this.customers[i] == customer) {
                this.customers[i] = new Customer();
                empty = i;
            }
            else if (this.customers[i].getName() == ""){
                end = i -1;
            }
        }

        if (this.customers[empty] == this.customers[end]) {
            this.customers[empty] = this.customers[end];
            this.customers[end] = new Customer();
        }

        System.out.println("Customer was not in the store...");
    }

    public Customer[] getCustomers() {
        return customers;
    }

    public Item[] getItems() {
        return items;
    }

    public void addObserver(Customer customer){
        for (int i = 0; i < this.observers.length; ++i){
            if (this.observers[i] == customer) return;
            else if (this.observers[i].getName() == "") this.observers[i] = customer;
        }
        System.out.println("Observer was already in the list...");
    }

    public void removeObserver(Customer customer){
        int end = 0, empty = 0;

        for (int i = 0; i < this.observers.length; ++i){
            if (this.observers[i] == customer) {
                this.observers[i] = new Customer();
                empty = i;
            }
            else if (this.observers[i].getName() == ""){
                end = i -1;
            }
        }

        if (this.observers[empty] == this.observers[end]) {
            this.observers[empty] = this.observers[end];
            this.observers[end] = new Customer();
        }

        System.out.println("Observer was not in the list...");
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

    public Customer[] getObservers() {
        return observers;
    }

}
