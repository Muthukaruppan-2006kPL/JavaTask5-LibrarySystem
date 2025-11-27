import java.util.ArrayList;
import java.util.Scanner;

class Book {
    int id;
    String title;
    String author;
    boolean isAvailable = true;

    Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    void displayBook() {
        System.out.println("ID: " + id + " | Title: " + title + " | Author: " + author + 
                           " | Status: " + (isAvailable ? "Available" : "Borrowed"));
    }
}

public class LibrarySystem {

    public static void main(String[] args) {
        ArrayList<Book> books = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== LIBRARY MENU =====");
            System.out.println("1. Add Book");
            System.out.println("2. Display All Books");
            System.out.println("3. Search Book by ID");
            System.out.println("4. Borrow Book");
            System.out.println("5. Return Book");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Book Title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter Author Name: ");
                    String author = sc.nextLine();

                    books.add(new Book(id, title, author));
                    System.out.println("Book added successfully!");
                    break;

                case 2:
                    System.out.println("\n---- Book List ----");
                    for (Book b : books) {
                        b.displayBook();
                    }
                    break;

                case 3:
                    System.out.print("Enter Book ID to search: ");
                    int searchId = sc.nextInt();
                    boolean found = false;

                    for (Book b : books) {
                        if (b.id == searchId) {
                            b.displayBook();
                            found = true;
                            break;
                        }
                    }
                    if (!found) System.out.println("Book not found!");
                    break;

                case 4:
                    System.out.print("Enter Book ID to borrow: ");
                    int borrowId = sc.nextInt();
                    boolean borrowFound = false;

                    for (Book b : books) {
                        if (b.id == borrowId) {
                            borrowFound = true;
                            if (b.isAvailable) {
                                b.isAvailable = false;
                                System.out.println("Book borrowed successfully!");
                            } else {
                                System.out.println("Book already borrowed!");
                            }
                            break;
                        }
                    }
                    if (!borrowFound) System.out.println("Book not found!");
                    break;

                case 5:
                    System.out.print("Enter Book ID to return: ");
                    int returnId = sc.nextInt();
                    boolean returnFound = false;

                    for (Book b : books) {
                        if (b.id == returnId) {
                            returnFound = true;
                            if (!b.isAvailable) {
                                b.isAvailable = true;
                                System.out.println("Book returned successfully!");
                            } else {
                                System.out.println("This book was not borrowed!");
                            }
                            break;
                        }
                    }
                    if (!returnFound) System.out.println("Book not found!");
                    break;

                case 6:
                    System.out.println("Exiting Library System...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
