public class Store {
    private String name;
    private Department departments[] = new Department[100];
    private Customer customers[] = new Customer[100];

    Store(){
        this.name = "";
    }

    Store(String name){
        this.name = "";
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

    public ShoppingCart getShoppingCart(){
        return new ShoppingCart();
    }

    public WishList getWishList(){
        return new WishList();
    }

    public Customer[] getCustomers() {
        return customers;
    }

    public Department[] getDepartments() {
        return departments;
    }

    public void addDepartment(Department department){
        for (int i = 0; i < this.departments.length; ++i){
            if (this.departments[i] == department) return;
            else if (this.departments[i].getName() == "") this.departments[i] = department;
        }
        System.out.println("Department was already in the store...");
    }

    public void save(String filename){

    }

    public void load(String filename){

    }
}
