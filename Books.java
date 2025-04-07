import java.util.HashMap;
import ecs100.*;
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

    /**
     * Constructor for objects of class Books
     */
    public Books()
    {
        //intitailse the fields
        library = new HashMap<Integer, Book>(); // initialise hashmap
        
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
            
            choice = UI.askString("Enter a choice: ");
            if (choice.equalsIgnoreCase("A")){
                //add books
            }
            else if (choice.equalsIgnoreCase("F")){
                // find book
            }
            else if (choice.equalsIgnoreCase("P")){
                //print all books
            }
            else if (choice.equalsIgnoreCase("Q")){
                //quit
                UI.println("GoodBye");
                UI.quit();
            }
            else{
                UI.println("Not a valid choice");
            }
        }while(!choice.equalsIgnoreCase("Q"));
    }
}
