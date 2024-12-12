import java.util.Stack;
import java.util.Scanner;

public class LibrarySortingSystem {
    String[] books = {"Math1", "Math2", "Math3", "Science1", "Science2", "Science3", "Bible",};
    Stack<String> bookStack = new Stack<>();
   
    public void init() {
        for(String book: books){
        bookStack.push(book);
    }}
    //Adding books
    public void addBook(String bookTitle) {
        bookStack.push(bookTitle);
        System.out.println("Book added: " + bookTitle);
    }

    /*Removing the books using pop but you can choose freely which to remove 
    Using an auxiliary stack to remove the specific book
    */
    public void removeBook(String bookTitle) {  
        String compareString = bookTitle;
        Stack<String> auxStack = new Stack<>();
        while(!bookStack.isEmpty()) {
        String st = bookStack.pop();
        if(st.compareTo(compareString) != 0)
        auxStack.push(st);
}
System.out.println("Removed Book: "+compareString);
while(!auxStack.isEmpty()) 
    bookStack.push(auxStack.pop());
    }

    //Sorting the stack (Z-A)
    public void sortBooks() {
        if (bookStack.isEmpty()) {
            System.out.println("No books to sort.");
            return;
        }
        Stack<String> tempStack = new Stack<>();
        while (!bookStack.isEmpty()) {
            String temp = bookStack.pop();
            while (!tempStack.isEmpty() && tempStack.peek().compareTo(temp) > 0) {
                bookStack.push(tempStack.pop());
            }
            tempStack.push(temp);
        }
        bookStack = tempStack;
        System.out.println("Books sorted alphabetically.");
    }

    //Displaying the books
    public void displayBooks() {
        if (bookStack.isEmpty()) {
            System.out.println("No books in the library.");
        } else {
            System.out.println("Books in the library (top to bottom):");
            for (int i = bookStack.size() - 1; i >= 0; i--) {
                System.out.println(bookStack.get(i));
            }
        }
    }

    public static void main(String[] args) {
        LibrarySortingSystem library = new LibrarySortingSystem();
        Scanner scanner = new Scanner(System.in);
         
        library.init();
        //Lines for the options
        while (true) {
            System.out.println("\nLibrary Sorting System");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Sort Books");
            System.out.println("4. Display Books");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter book title: ");
                    String bookTitle = scanner.nextLine();
                    library.addBook(bookTitle);
                }
                case 2 -> {
                    System.out.print("Enter book title: ");
                    String bookTitle = scanner.nextLine();
                    library.removeBook(bookTitle);
                }
                case 3 -> library.sortBooks();
                case 4 -> library.displayBooks();
                case 5 -> {
                    System.out.println("Exiting system. Goodbye!");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }
}