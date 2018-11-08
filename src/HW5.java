import java.util.Scanner;

public class HW5 {
    public static void main(String[] args){
        BookDepartment bookDepartment = new BookDepartment("Book Department", 1);
        MusicDepartment musicDepartment = new MusicDepartment("Music Department", 2);
        SoftwareDepartment softwareDepartment = new SoftwareDepartment("Software Department", 3);
        VideoDepartment videoDepartment = new VideoDepartment("Video Department", 4);

        Store store = new Store();

        store.addDepartment(bookDepartment);

        store.getDepartments().get(0).addItem("Peter Pan", 19.99, 0);

        System.out.println("Add two observers to the department.");
        store.getDepartments().get(0).addObserver(new Customer("Jeff"));
        store.getDepartments().get(0).addObserver(new Customer("Bill"));
        System.out.println(store.getDepartments().get(0).getObservers().toArray());

        System.out.println();
        System.out.println("Price change with two observers.");
        store.getDepartments().get(0).changePrice("Peter Pan", 9.99);
        System.out.println();

        System.out.println();
        System.out.println("Price change with one observer.");
        store.getDepartments().get(0).removeObserver("Bill");
        store.getDepartments().get(0).changePrice("Peter Pan", 19.99);

        System.out.println();
        store.enter(new Customer("Jill"));
        store.getCustomers().get(0).getShoppingCart().addItem(new Item("Barbie", 2, 0, 9.98));
        store.getCustomers().get(0).getShoppingCart().addItem(new Item("Beer", 3, 0, 19.98));
        System.out.println(store.getCustomers().get(0).getShoppingCart().toString());
    }

//    String selection = "";
//        Scanner sc = new Scanner(System.in);
//
//        while (selection.toLowerCase() != "e"){
//            System.out.print("Welcome to the store, please select an option:\n" +
//                    "\t 1. Edit departments\n" +
//                    "\t 2. Edit users\n" +
//                    "\t 3. Add customer\n" +
//                    "\t 4. Remove customer\n" +
//                    "\t 5. Print customers\n" +
//                    "\t 6. Save store\n" +
//                    "\t 7. Load store\n" +
//                    "\t e. Exit\n" +
//                    "Input: ");
//            selection = sc.nextLine();
//            System.out.println();
//
//            switch (selection.toLowerCase().charAt(0)){
//                case '1':
//                    editDepartments();
//                    break;
//                case '2':
//                    editUsers();
//                    break;
//                case '3':
//                    String name = "";
//                    System.out.print("Enter customer's name: ");
//                    name = sc.nextLine();
//                    for (int i = 0; i < store.getCustomers().size(); ++i){
//                        if (store.getCustomers().toArray()[i].getName() == name) store.enter(new Customer(name));
//                    }
//                    System.out.println();
//                    break;
//                case '4':
//                    System.out.print("Enter customer's name: ");
//                    break;
//                case '5':
//                    System.out.println(store.getCustomers());
//                    break;
//                case '6':
//                    store.save();
//                    break;
//                case '7':
//                    store.load();
//                    break;
//                case 'e':
//                    store.save();
//                    return;
//                default:
//                    System.out.println("Invalid input, please try again...");
//            }
//        }

//    public static void editDepartments() {
//        String selection = "";
//        Scanner sc = new Scanner(System.in);
//        while (selection.toLowerCase().toLowerCase() != "e") {
//            System.out.print("Select an option:\n" +
//                    "\t 1. Add Item\n" +
//                    "\t 2. Enter Customer\n" +
//                    "\t 3. Exit Customer\n" +
//                    "\t 4. Add Observer\n" +
//                    "\t 5. Remove Observer\n" +
//                    "\t e. Return\n" +
//                    "Input: ");
//            selection = sc.nextLine();
//            System.out.println();
//
//            switch (selection.charAt(0)) {
//                case '1':
//
//                    break;
//                case 'e':
//                    return;
//                default:
//                    System.out.println("Invalid input, please try again...");
//            }
//        }
//    }

//    public static void editUsers(){
//        String selection = "";
//        Scanner sc = new Scanner(System.in);
//        while (selection.toLowerCase().toLowerCase() != "e") {
//            System.out.print("Select an option:\n" +
//                    "\t 1. option\n" +
//                    "\t e. Return\n" +
//                    "Input: ");
//            selection = sc.nextLine();
//            System.out.println();
//
//            switch (selection.charAt(0)) {
//                case '1':
//                    editDepartments();
//                    break;
//                case 'e':
//                    return;
//                default:
//                    System.out.println("Invalid input, please try again...");
//            }
//        }
//    }
}
