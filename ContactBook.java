import java.util.*;

public class ContactBook {
    private List<Contact> contacts;

    public ContactBook() {
        contacts = FileHandler.loadContacts();
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
        FileHandler.saveContacts(contacts);
        System.out.println("Contact added successfully.");
    }

    public void updateContact(String name, String newPhone, String newEmail) {
        for (Contact c : contacts) {
            if (c.getName().equalsIgnoreCase(name)) {

                // Update only if new value is entered
                if (!newPhone.isEmpty()) {
                    c.setPhone(newPhone);
                }

                if (!newEmail.isEmpty()) {
                    c.setEmail(newEmail);
                }

                FileHandler.saveContacts(contacts);
                System.out.println("Contact updated successfully.");
                return;
            }
        }
        System.out.println("Contact not found.");
    }


    public void searchContact(String name) {
        for (Contact c : contacts) {
            if (c.getName().equalsIgnoreCase(name)) {
                System.out.println(c);
                return;
            }
        }
        System.out.println("Contact not found.");
    }

    public void displayAllContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts available.");
            return;
        }

        for (Contact c : contacts) {
            System.out.println(c);
        }
    }
}
