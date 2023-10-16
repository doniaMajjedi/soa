package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "book_name")
    private String name;
    @Column(name = "book_price")
    private double  price;
    @Column(name = "book_author")
    private String  author;
    @Column(name = "book_type")
    private String  type;

    //constructor
    public Book(String name, double price,String author, String type) {
        this.name = name;
        this.price = price;
        this.author=author;
        this.type = type;
    }

    //getters and setters
    public long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public String getType() {
        return type;
    }
    public String getAuthor() {
        return author;
    }
}