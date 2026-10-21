import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// --- Encapsulated Book Class ---
class Book {
    private int id;
    private String title;
    private String author;
    private boolean isBorrowed;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isBorrowed = false;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean isBorrowed() { return isBorrowed; }

    public void setBorrowed(boolean borrowed) { this.isBorrowed = borrowed; }

    public void displayBook() {
        System.out.printf("ID: %-5d | Title: %-25s | Author: %-20s | Status: %s\n",
                id, title, author, (isBorrowed ? "Borrowed" : "Available"));
    }
}

// --- User Abstract Base Class (Abstraction) ---
abstract class User {
    protected int userId;
    protected String name;

    public User(int userId, String name) {
        this.userId = userId;
        this.name = name;
    }

    public abstract void displayRole();
}

// --- Member Subclass (Inheritance) ---
class Member extends User {
    public Member(int userId, String name) {
        super(userId, name);
    }

    @Override
    public void displayRole() {
        System.out.println("User Role: Member | Name: " + name + " (ID: " + userId + ")");
    }
}

// --- Library Service Class ---
class Library {
    private List<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("✅ Book '" + book.getTitle() + "' added successfully!");
    }

    public void displayAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in library.");
            return;
        }
        System.out.println("\n-------------------------------------------------------------------------");
        System.out.println("                           LIBRARY CATALOG                               ");
        System.out.println("-------------------------------------------------------------------------");
        for (Book b : books) {
            b.displayBook();
        }
        System.out.println("-------------------------------------------------------------------------");
    }

    public void borrowBook(int bookId) {
        for (Book b : books) {
            if (b.getId() == bookId) {
                if (b.isBorrowed()) {
                    System.out.println("❌ Sorry, '" + b.getTitle() + "' is already borrowed!");
                } else {
                    b.setBorrowed(true);
                    System.out.println("✅ Successfully borrowed: " + b.getTitle());
                }
                return;
            }
        }
        System.out.println("❌ Book ID not found.");
    }

    public void returnBook(int bookId) {
        for (Book b : books) {
            if (b.getId() == bookId) {
                if (!b.isBorrowed()) {
                    System.out.println("❌ This book was not borrowed.");
                } else {
                    b.setBorrowed(false);
                    System.out.println("✅ Successfully returned: " + b.getTitle());
                }
                return;
            }
        }
        System.out.println("❌ Book ID not found.");
    }
}

// --- Main Application ---
public class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        // Seed initial books
        library.addBook(new Book(101, "Effective Java", "Joshua Bloch"));
        library.addBook(new Book(102, "Clean Code", "Robert C. Martin"));

        User member = new Member(1, "Mahima Chaudhari");
        int choice;

        do {
            System.out.println("\n====================================");
            System.out.println("    LIBRARY MANAGEMENT SYSTEM (OOP) ");
            System.out.println("====================================");
            member.displayRole();
            System.out.println("------------------------------------");
            System.out.println("1. Add Book");
            System.out.println("2. Display All Books");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");
            System.out.println("====================================");
            System.out.print("Enter choice (1-5): ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Clear buffer
                    System.out.print("Enter Book Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Author Name: ");
                    String author = scanner.nextLine();
                    library.addBook(new Book(id, title, author));
                    break;
                case 2:
                    library.displayAllBooks();
                    break;
                case 3:
                    System.out.print("Enter Book ID to borrow: ");
                    int borrowId = scanner.nextInt();
                    library.borrowBook(borrowId);
                    break;
                case 4:
                    System.out.print("Enter Book ID to return: ");
                    int returnId = scanner.nextInt();
                    library.returnBook(returnId);
                    break;
                case 5:
                    System.out.println("Exiting Library Management System. Goodbye! 👋");
                    break;
                default:
                    System.out.println("❌ Invalid choice! Select 1-5.");
            }
        } while (choice != 5);

        scanner.close();
    }
}