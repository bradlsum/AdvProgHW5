// Sumner Bradley
import java.io.*;
import java.util.Scanner;

public class HW5 {
    public static void main(String[] args){
        Store store = new Store();
        String selection = "";
        Scanner sc = new Scanner(System.in);

        // 1. Watchlist ----------------------------------------------------------------------------
        System.out.println("\n1. Watchlist");
        store.addDepartment(new MusicDepartment("Music Department"));
        store.enter(new Customer("Jack"));
        store.enter(new Customer("Jill"));

        store.getDepartments().get(0).addItem("Barbie", 19.99);
        store.getDepartments().get(0).addItem("Peter Pan", 9.99);
        store.getDepartments().get(0).addItem("Pizza", 1.99);

        store.getDepartments().get(0).getObservers().add(store.getCustomers().get("Jack"));
        store.getDepartments().get(0).getObservers().add(store.getCustomers().get("Jill"));

        store.getDepartments().get(0).changePrice("Peter Pan", 9.99);

        store.getDepartments().get(0).getObservers().remove(store.getCustomers().get("Jill"));
        store.getDepartments().get(0).changePrice("Peter Pan", 19.99);
        // 1. Watchlist ----------------------------------------------------------------------------

        // 2. Shopping cart ----------------------------------------------------------------------------
        System.out.println("2. Shopping cart");
        for (int i = 0; i < 3; ++i) store.getCustomers().get("Jill").getShoppingCart().addItem(store.getDepartments().get(0).getItems()[i]);
        store.getCustomers().get("Jill").getShoppingCart().printList();
        // 2. Shopping cart ----------------------------------------------------------------------------

        // 3. Department management ----------------------------------------------------------------------------
        System.out.println("\n3. Department management");
        store.addDepartment(new SoftwareDepartment("Software Department"));
        store.printDepartments();
        store.addDepartment(new SoftwareDepartment("Software Department"));
        store.printDepartments();
        // 3. Department management ----------------------------------------------------------------------------

//        try {
//            FileInputStream fileIn = new FileInputStream("./src/store.ser");
//            ObjectInputStream in = new ObjectInputStream(fileIn);
//            store = (Store) in.readObject();
//            in.close();
//            fileIn.close();
//        } catch (IOException i) {
//            i.printStackTrace();
//            return;
//        } catch (ClassNotFoundException c) {
//            c.printStackTrace();
//            return;
//        }
//        while (selection.toLowerCase() != "e"){
//            System.out.print("Welcome to the store, please select an option:\n" +
//                    "\t 1. Edit departments\n" +
//                    "\t 2. Edit users\n" +
//                    "\t 3. Add customer\n" +
//                    "\t 4. Remove customer\n" +
//                    "\t 5. Print customers\n" +
//                    "\t 6. Save store\n" +
//                    "\t 7. Add a department\n" +
//                    "\t 8. Print departments\n" +
//                    "\t e. Exit\n" +
//                    "Input: ");
//            selection = sc.nextLine();
//            System.out.println();
//
//            switch (selection.toLowerCase().charAt(0)){
//                case '1':
//                    editDepartments(store);
//                    break;
//                case '2':
//                    editUsers(store);
//                    break;
//                case '3':
//                    System.out.print("Enter customer's name: ");
//                    selection = sc.nextLine();
//                    store.enter(new Customer(selection));
//                    System.out.println();
//                    break;
//                case '4':
//                    System.out.print("Enter customer's name: ");
//                    selection = sc.nextLine();
//                    store.exit(selection);
//                    break;
//                case '5':
//                    System.out.println(store.getCustomers().keySet());
//                    break;
//                case '6':
//                    save(store);
//                    break;
//                case '7':
//                    addDepartment(store);
//                    break;
//                case '8':
//                    store.printDepartments();
//                    break;
//                case 'e':
//                    save(store);
//                    return;
//                default:
//                    System.out.println("Invalid input, please try again...");
//            }
//        }
//    }
//
//    public static void editDepartments(Store store) {
//        String selection = "";
//        Scanner sc = new Scanner(System.in);
//        int department = 0, item = 0;
//
//        System.out.println("Please select a department to edit:");
//        store.printDepartments();
//        department = sc.nextInt();
//        sc.nextLine();
//
//
//        while (selection.toLowerCase().toLowerCase() != "e") {
//            System.out.print("Select an option:\n" +
//                    "\t 1. Add item\n" +
//                    "\t 2. Edit item\n" +
//                    "\t 3. Remove item\n" +
//                    "\t 4. Print items\n" +
//                    "\t 5. Enter customer\n" +
//                    "\t 6. Exit customer\n" +
//                    "\t 7. Add observer\n" +
//                    "\t 8. Remove observer\n" +
//                    "\t e. Return\n" +
//                    "Input: ");
//            selection = sc.nextLine();
//            System.out.println();
//
//            switch (selection.charAt(0)) {
//                case '1':
//                    System.out.print("Enter item's name: ");
//                    String name = sc.nextLine();
//                    System.out.print("Enter item's price: ");
//                    double price = sc.nextDouble();
//                    sc.nextLine();
//                    store.getDepartments().get(department).addItem(name, price);
//                    break;
//                case '2':
//                    editItem(store, department);
//                    break;
//                case '3':
//                    System.out.println("Please select a item to remove:");
//                    store.getDepartments().get(department).printItems();
//                    item = sc.nextInt();
//                    sc.nextLine();
//
//                    store.getDepartments().get(department).removeItem(item);
//                    break;
//                case '4':
//                    store.getDepartments().get(department).printItems();
//                    break;
//                case '5':
//                    System.out.print("Enter customer's name: ");
//                    selection = sc.nextLine();
//                    store.getDepartments().get(department).enter(store.getCustomers().get(selection));
//                    break;
//                case '6':
//                    System.out.print("Enter customer's name: ");
//                    selection = sc.nextLine();
//                    store.getDepartments().get(department).exit(store.getCustomers().get(selection));
//                    break;
//                case '7':
//                    System.out.print("Enter customer's name: ");
//                    selection = sc.nextLine();
//                    store.getDepartments().get(department).addObserver(store.getCustomers().get(selection));
//                    break;
//                case '8':
//                    System.out.print("Enter customer's name: ");
//                    selection = sc.nextLine();
//                    store.getDepartments().get(department).removeObserver(store.getCustomers().get(selection));
//                    break;
//                case 'e':
//                    return;
//                default:
//                    System.out.println("Invalid input, please try again...");
//            }
//        }
    }

    public static void editUsers(Store store){
        String selection = "";
        Scanner sc = new Scanner(System.in);
        String customer = "";
        int item = 0, department = 0;

        System.out.println("Enter customer's name");
        store.printCustomers();
        customer = sc.nextLine();

        while (selection.toLowerCase().toLowerCase() != "e") {
            System.out.print("Select an option:\n" +
                    "\t 1. Change name\n" +
                    "\t 2. Add item to wishlist\n" +
                    "\t 3. Remove item form wishlist\n" +
                    "\t 4. Add item to cart\n" +
                    "\t 5. Remove item from cart\n" +
                    "\t e. Return\n" +
                    "Input: ");
            selection = sc.nextLine();
            System.out.println();

            switch (selection.charAt(0)) {
                case '1':
                    System.out.print("Enter a new name: ");
                    store.getCustomers().get(customer).setName(sc.nextLine());
                    break;
                case '2':
                    System.out.println("Select a department:");
                    store.printDepartments();
                    department = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Select an item to add to " + customer + "'s wishlist:");
                    store.getDepartments().get(department).printItems();
                    item = sc.nextInt();
                    sc.nextLine();

                    store.getCustomers().get(customer).getWishList().addItem(store.getDepartments().get(department).getItems()[item]);
                    break;
                case '3':
                    System.out.println("Select a department:");
                    store.printDepartments();
                    department = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Select an item to remove from " + customer + "'s wishlist:");
                    store.getCustomers().get(customer).getWishList().printList();
                    item = sc.nextInt();
                    sc.nextLine();

                    store.getCustomers().get(customer).getWishList().removeItem(store.getDepartments().get(department).getItems()[item]);
                    break;
                case '4':
                    System.out.println("Select a department:");
                    store.printDepartments();
                    department = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Select an item to add to " + customer + "'s cart:");
                    store.getDepartments().get(department).printItems();
                    item = sc.nextInt();
                    sc.nextLine();

                    store.getCustomers().get(customer).getShoppingCart().addItem(store.getDepartments().get(department).getItems()[item]);
                    break;
                case '5':
                    System.out.println("Select a department:");
                    store.printDepartments();
                    department = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Select an item to remove from " + customer + "'s wishlist:");
                    store.getCustomers().get(customer).getShoppingCart().printList();
                    item = sc.nextInt();
                    sc.nextLine();

                    store.getCustomers().get(customer).getShoppingCart().removeItem(store.getDepartments().get(department).getItems()[item]);
                    break;
                case 'e':
                    return;
                default:
                    System.out.println("Invalid input, please try again...");
            }
        }
    }

    public static void editItem(Store store, int department){
        String selection = "";
        int item = 0;
        Scanner sc = new Scanner(System.in);

        System.out.println("Please select a item to edit:");
        store.getDepartments().get(department).printItems();
        item = sc.nextInt() - 1;
        sc.nextLine();

        while (selection.toLowerCase().toLowerCase() != "e") {
            System.out.print("Select an option:\n" +
                    "\t 1. Change name\n" +
                    "\t 2. Change price\n" +
                    "\t e. Return\n" +
                    "Input: ");
            selection = sc.nextLine();
            System.out.println();

            switch (selection.charAt(0)) {
                case '1':
                    System.out.print("Enter a new item name: ");
                    store.getDepartments().get(department).getItems()[item].setName(sc.nextLine());
                    break;
                case '2':
                    System.out.print("Enter a new item price: ");
                    store.getDepartments().get(department).changePrice(store.getDepartments().get(department).getItems()[item].getName(), sc.nextDouble());
                    sc.nextLine();
                    break;
                case 'e':
                    return;
                default:
                    System.out.println("Invalid input, please try again...");
            }
        }
    }

    public static void save(Store store){
        try {
            FileOutputStream fileOut = new FileOutputStream("./src/store.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(store);
            out.close();
            fileOut.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public static void addDepartment(Store store){
        Scanner sc = new Scanner(System.in);
        String selection = "";

        System.out.print("Select which department to add:\n" +
                "\t 1. Book Department\n" +
                "\t 2. Music Department\n" +
                "\t 3. Video Department\n" +
                "\t 4. Software Department\n" +
                "\t e. Exit\n" +
                "Input: ");
        selection = sc.nextLine();

        switch (selection.toLowerCase().charAt(0)){
            case '1':
                store.addDepartment(new BookDepartment("Book Department"));
                break;
            case '2':
                store.addDepartment(new MusicDepartment("Music Department"));
                break;
            case '3':
                store.addDepartment(new VideoDepartment("Video Department"));
                break;
            case '4':
                store.addDepartment(new SoftwareDepartment("Software Department"));
                break;
            case 'e':
                return;
            default:
                System.out.println("Invalid input, please try again...");
        }
    }
}