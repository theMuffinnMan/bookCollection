import ecs100.*;
/**
 * GUI class for books manager 
 * Allows add, print, find books on GUI
 * 
 * ??? delete
 * click the book cover to like the book
 * show the total number of likes
 *
 * @Fleur
 * @29/4
 */
public class GUI
{
    // instance variables - replace the example below with your own
    private Books books; //declare books instance
    private Book book; //declare book instance

    /**
     * Constructor for objects of class GUI
     */
    public GUI()
    {
        // initialise instance variables
        books = new Books();  //instiantiate the books
        
        // set up UI
        UI.initialise();
        UI.addButton("Print All",books::printAll);
        UI.addButton("Add", this::addBook);
        UI.addButton("Find", this::findBook);
        UI.addButton("Delete Book", this::deleteBook);
        UI.addButton("Quit", UI::quit);
        UI.setMouseListener(this::doMouse);
        
    }

    /**
     * add a book to collection
     */
    public void addBook()
    {
        // force a range of quantity
        final int MAX_QUANTITY = 99; // max quantity it can add to hashmap
        int quantity;
        
        //ask the user for details
        String name = UI.askString("Title: ");
        String author = UI.askString("Author: ");
        
        //check boundaries for the number of books added 
        do{
            quantity = UI.askInt("Quantity: ");
            if((quantity > 0) && (quantity <= MAX_QUANTITY)){
                UI.println("Added");
            }
            else if(quantity > MAX_QUANTITY) {
                UI.println("Must be less than 100");
            }
            else if (quantity < 1){
                UI.println("Must be greater than 0");
            }
            else{
                UI.println("Must be a number!");
            }
        }while (0 > quantity || quantity > MAX_QUANTITY);
        //add a book image or display
        String imgFileName = UIFileChooser.open("Choose Image File: ");
        
        //set likes to 0
        int like = 0;
        
        //add books with images
        this.books.addBook(name, author, quantity, imgFileName, like);
    }
    
    /**
     * Finds books based on name
     * prints out the author and qty if found
     */
    public void findBook(){
        String bookName = UI.askString("Name of Books: ");
        if(this.books.findBook(bookName.toLowerCase().trim())){
            //Refer back to Books instance books method findBook ot return true or false
            UI.println("Found Book!");
            
            this.book = books.getBook();
            this.book.displayBook();
            UI.println("Author: " + this.book.getAuthor());
            UI.println("Quantity: " + this.book.getQuantity());
            UI.println("Likes: " + this.book.getLikes());
        }
        else{
            UI.println("That book does not exist!");
        }
    }
    
    /**
     * delete book
     */
    public void deleteBook(){
        String bookName = UI.askString("Name of Books: ");
        if(this.books.findBook(bookName.toLowerCase().trim())){
            books.deleteBook();
            
            UI.println("Book Deleted!");
        }
        else{
            UI.println("That book does not exist!");
        }
    }
    
    /**
     * Print book likes
     */
    public void printLikes(){
        UI.println(book.getName() + " has " + book.getLikes() + " likes");
    }
    
    /**
     * doMouse
     * mouse interaction with book cover
     */
    public void doMouse(String action, double x, double y){
        // returns true or false wether mouse clikced on book cover or not
        
        //mouse clicked on book cover
        if (action.equals("clicked") && x > book.getLocX() && x < book.getLocX() + book.getWidth()
           && y > book.getLocY() && y < book.getLocY() + book.getHeight()){
            book.setLikes();
            this.printLikes();
        }
    }
    
    /**
     * Main routine
     */
    public static void main(String[] args) {
        new GUI();
    }
}
