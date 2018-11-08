public class Item {
    private String name;
    private int itemId;
    private int departmentId;
    private double price;

    Item(){
        this.name = "";
        this.itemId = 0;
        this.departmentId = 0;
        this.price = 0;
    }

    Item(String name, int itemId, int departmentId, double price){
        this.name = name;
        this.itemId = itemId;
        this.departmentId = departmentId;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
