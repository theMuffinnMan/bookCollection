import ecs100.*;
/**
 * Write a support class for books
 *
 * Fleur
 * 7/4/2025
 */
public class Book
{
    // fields
    private int id;
    private String name;
    private String author;
    private int quantity;
    private String image;
    static final String DEFAULT_IMAGE = "book.jpg"; // set a defualt image

    /**
     * Constructor for objects of class Book
     * overloaded???
     */
    public Book(int key, String nm, String auth, int qty, String img)
    {
        this.id = key;
        this.name = nm;
        this.author = auth;
        this.quantity = qty;
        if(img == null){
            this.image = DEFAULT_IMAGE; // add defualt img is user clicks cancel
        }
        else{
            this.image = img;
        }
    }
    
    /**
     * Constructor for objects of class Book
     */
    public Book(int key, String nm, String auth, int qty)
    {
        this(key, nm, auth, qty, DEFAULT_IMAGE);
    }

    
    /**
     * Display image on GUI
     */
    public void displayBook(){
        int locX = 100; //img x start pos
        int locY = 100; //img y start pos
        
        final double WIDTH = 250;
        final double HEIGHT = 300;
        
        UI.drawImage(this.image, locX, locY, WIDTH, HEIGHT);
    }
    /**
     * getter for id number
     */
    public int getId(){
        return this.id;
    }
    /**
     * Getter for name
     */
    public String getName(){
        return this.name;
    }
    /**
     * Getter for author
     */
    public String getAuthor(){
        return this.author;
    }
    /**
     * Getter for quantity
     */
    public int getQuantity(){
        return this.quantity;
    }
}
