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
    private int like;
    
    private double locX = 100; //img x start pos
    private double locY = 100; //img y start pos
        
    private final double WIDTH = 250;
    private final double HEIGHT = 300;
    

    /**
     * Constructor for objects of class Book
     * overloaded???
     */
    public Book(int key, String nm, String auth, int qty, String img, int likes)
    {
        this.id = key;
        this.name = nm;
        this.author = auth;
        this.quantity = qty;
        this.like = likes;
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
    public Book(int key, String nm, String auth, int qty, int likes)
    {
        this(key, nm, auth, qty, DEFAULT_IMAGE, likes);
    }

    
    /**
     * Display image on GUI
     */
    public void displayBook(){
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
    /**
     * Getter for likes
     */
    public int getLikes(){
        return this.like;
    }
    /**
     * Getter for locX - img starting pos x
     */
    public double getLocX(){
        return this.locX;
    }
    /**
     * Getter for locY - img starting pos y
     */
    public double getLocY(){
        return this.locY;
    }
    /**
     * Getter for width - img width
     */
    public double getWidth(){
        return this.WIDTH;
    }
    /**
     * Getter for height - img height
     */
    public double getHeight(){
        return this.HEIGHT;
    }
    /**
     * Setter for likes
     */
    public void setLikes(){
        this.like += 1;
    }
}
