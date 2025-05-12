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

    /**
     * Constructor for objects of class Books
     */
    public Books()
    {
        //intitailse the fields
        library = new HashMap<Integer, Book>(); // initialise hashmap
    
        
        //create books
        Book b1 = new Book(1, "The Wicked King", "Holly Black", 2);
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
        library.put(this.currBookId, new Book(this.currBookId, name, author, qty));
    }
    
    /** 
     * add a book to the map and display the cover on canva
     * Override the method with different param
     * @ param name, author, qty, img
     */
    public void addBook(String name, String author, int qty, String img){
        this.setBookId();
        this.library.put(this.currBookId, new Book(this.currBookId, name, author, qty, img));
    }
    
    /**
     * Print all books
     */
    public void printAll(){
        for(int bookId: library.keySet()){
            UI.println(bookId + " Details: ");
            UI.println(library.get(bookId).getName() + " "
            + library.get(bookId).getAuthor() + " "
            + library.get(bookId).getQuantity());
        }
    }
    
    /**
     * book getter
     */
    public Book getBook(){
        return this.currBook;
    }
}
