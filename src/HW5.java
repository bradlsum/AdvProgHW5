import java.io.*;
import java.util.Scanner;

public class HW5 {
    public static void main(String[] args){
        Store store = new Store();
        String selection = "";
        Scanner sc = new Scanner(System.in);

//        BookDepartment bookDepartment = new BookDepartment("Book Department", 1);
//        MusicDepartment musicDepartment = new MusicDepartment("Music Department", 2);
//        SoftwareDepartment softwareDepartment = new SoftwareDepartment("Software Department", 3);
//        VideoDepartment videoDepartment = new VideoDepartment("Video Department", 4);
//        store.addDepartment(bookDepartment);
//        store.addDepartment(musicDepartment);
//        store.addDepartment(softwareDepartment);
//        store.addDepartment(videoDepartment);

        try {
            FileInputStream fileIn = new FileInputStream("./src/store.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            store = (Store) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            c.printStackTrace();
            return;
        }

        while (selection.toLowerCase() != "e"){
            System.out.print("Welcome to the store, please select an option:\n" +
                    "\t 1. Edit departments\n" +
                    "\t 2. Edit users\n" +
                    "\t 3. Add customer\n" +
                    "\t 4. Remove customer\n" +
                    "\t 5. Print customers\n" +
                    "\t 6. Save store\n" +
                    "\t e. Exit\n" +
                    "Input: ");
            selection = sc.nextLine();
            System.out.println();

            switch (selection.toLowerCase().charAt(0)){
                case '1':
                    editDepartments();
                    break;
                case '2':
                    editUsers();
                    break;
                case '3':
                    System.out.print("Enter customer's name: ");
                    selection = sc.nextLine();
                    store.enter(new Customer(selection));
                    System.out.println();
                    break;
                case '4':
                    System.out.print("Enter customer's name: ");
                    selection = sc.nextLine();
                    store.exit(selection);
                case '5':
                    System.out.println(store.getCustomers().keySet());
                    break;
                case '6':
                    save(store);
                    break;
                case 'e':
                    save(store);
                    return;
                default:
                    System.out.println("Invalid input, please try again...");
            }
        }
    }

    public static void editDepartments() {
        String selection = "";
        Scanner sc = new Scanner(System.in);
        while (selection.toLowerCase().toLowerCase() != "e") {
            System.out.print("Select an option:\n" +
                    "\t 1. Add item\n" +
                    "\t 2. Edit item\n" +
                    "\t 3. Print items\n" +
                    "\t 4. Enter customer\n" +
                    "\t 5. Exit customer\n" +
                    "\t 6. Add observer\n" +
                    "\t 7. Remove observer\n" +
                    "\t e. Return\n" +
                    "Input: ");
            selection = sc.nextLine();
            System.out.println();

            switch (selection.charAt(0)) {
                case '1':

                    break;
                case 'e':
                    return;
                default:
                    System.out.println("Invalid input, please try again...");
            }
        }
    }

    public static void editUsers(){
        String selection = "";
        Scanner sc = new Scanner(System.in);
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
                    editDepartments();
                    break;
                case 'e':
                    return;
                default:
                    System.out.println("Invalid input, please try again...");
            }
        }
    }

    public static void editItems(){
        String selection = "";
        Scanner sc = new Scanner(System.in);
        while (selection.toLowerCase().toLowerCase() != "e") {
            System.out.print("Select an option:\n" +
                    "\t 1. option\n" +
                    "\t e. Return\n" +
                    "Input: ");
            selection = sc.nextLine();
            System.out.println();

            switch (selection.charAt(0)) {
                case '1':
                    editDepartments();
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
}