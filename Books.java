import java.util.HashMap;
import ecs100.*;
import java.util.Scanner;
/**
 * Holds a collection of books in a hashmap
 * allows a user to add, find, print all or edit from a menu
 * delete
 * prevent user from adding duplicate book
 *
 * Fleur
 * 7/4/2025
 */
public class Books
{
    // fields
    private HashMap<Integer, Book> library; // declearing the hashmap
    private int currBookId; // store the current id number of hte book being added
    private Book currBook; // store the instance of hte current book
    private Scanner scanner;

    /**
     * Constructor for objects of class Books
     */
    public Books()
    {
        //intitailse the fields
        library = new HashMap<Integer, Book>(); // initialise hashmap
        scanner = new Scanner(System.in);
        
        //create books
        Book b1 = new Book(1, "The Wicked King", "Holly Black", 12);
        Book b2 = new Book(2, "Gideon the Ninth", "Tamsin Miur", 2);
        Book b3 = new Book(3, "Good Omens", "Terry Prachet", 6);
        
        // add books to collection
        library.put(1, b1);
        library.put(2, b2);
        library.put(3, b3);
        
        this.currBookId = 3; // store the current book Id number
    }
    
    /**
     * Set BookId
     */
    public void setBookId(){
        this.currBookId += 1;
    }
    
    /**
     * find a book based on the name
     * set the current book instance if found
     * @return boolean false or true
     */
    public boolean findBook(String name){
        //search for the book
        for (int bookId: library.keySet()){
            if (library.get(bookId).getName().toLowerCase().equals(name.toLowerCase())){
                currBook = library.get(bookId);
                return true;
            }
        }
        return false;
    }

    /**
     * Add a book to the hashMap
     */
    public void addBook(String name, String author, int qty){
        this.setBookId();
        library.put(currBookId, new Book(currBookId, name, author, qty));
    }
    
    /**
     * Print all books
     */
    public void printAll(){
        for(int bookId: library.keySet()){
            System.out.println(bookId + " Details: ");
            System.out.println(library.get(bookId).getName() + " "
            + library.get(bookId).getAuthor() + " "
            + library.get(bookId).getQuantity());
        }
    }
    /**
     * Create a menu to pritn all and call appropriate methods
     * 
     */
        public void menu(){
        // print menu and force choice
        String choice;
        do{
            UI.println("(A)dd a book");
            UI.println("(F)ind a book");
            UI.println("(P)rint all books");
            UI.println("(Q)uit");
            
            choice = scanner.nextLine().trim().toUpperCase();
            
            switch(choice){
                case "A":
                    System.out.println("Enter Book title: ");
                    String title = scanner.nextLine();
                    System.out.println("Enter Book author: ");
                    String author = scanner.nextLine();
                    
                    //check for existing books
                    if(findBook(title)){
                        System.out.println("A book with this title already exists");
                        break;
                    }
                    System.out.println("Enter quantity: ");
                    int qty = Integer.parseInt(scanner.nextLine());
                    
                    addBook(title, author, qty);
                    System.out.println("Book added successully!");
                    break;
                    
                case "F":
                    System.out.println("Enter book title to find: ");
                    String searchTitle = scanner.nextLine();
                    
                    if(findBook(searchTitle)){
                        System.out.println("Book found");
                        System.out.println(currBook);
                    }
                    else{
                        System.out.println("Book not found");
                    }
                    break;
                case "P":
                    printAll();
                    break;
                    
                case "Q":
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid Choice");
            }
        }while(!choice.equalsIgnoreCase("Q"));
        scanner.close();
    }
    public static void main(String[] args){
        new Books().menu();
    }
}
