import java.util.Scanner;

public class Menu {
    private Scanner scanner;
    private ContactBook contactBook;

    public Menu() {
        scanner = new Scanner(System.in);
        contactBook = new ContactBook();
    }

    public void showMenu() {
        while (true) {
            System.out.println("\n--- Contact Book Menu ---");
            System.out.println("1. Add Contact");
            System.out.println("2. Update Contact");
            System.out.println("3. Search Contact");
            System.out.println("4. Display All Contacts");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // clear buffer

            switch (choice) {
                case 1 -> addContact();
                case 2 -> updateContact();
                case 3 -> searchContact();
                case 4 -> contactBook.displayAllContacts();
                case 5 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private void addContact() {
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Phone: ");
        String phone = scanner.nextLine();
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();

        contactBook.addContact(new Contact(name, phone, email));
    }

    private void updateContact() {
        System.out.print("Enter Name to Update: ");
        String name = scanner.nextLine();

        System.out.print("Enter New Phone (press ENTER to keep old): ");
        String phone = scanner.nextLine();

        System.out.print("Enter New Email (press ENTER to keep old): ");
        String email = scanner.nextLine();

        contactBook.updateContact(name, phone, email);
    }


    private void searchContact() {
        System.out.print("Enter Name to Search: ");
        String name = scanner.nextLine();
        contactBook.searchContact(name);
    }
}
