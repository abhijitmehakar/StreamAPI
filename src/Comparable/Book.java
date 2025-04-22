package Comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Book implements Comparable<Book> {
    private String title;
    private String author;
    private int price;


    public Book(String title, String author, int price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Title= "+title +" Author= "+author +" Price= "+price;
    }

    @Override
    public int compareTo(Book other) {
        return this.title.compareToIgnoreCase(other.title);
    }
}

class BookSortByTitle{
    public static void main(String[] args) {
        List<Book>books=new ArrayList<>();
        books.add(new Book("To Kill a Mockingbird","Harper Lee",999));
        books.add(new Book("1984","George Orwell",2999));
        books.add(new Book("The Great Gatsby","F. Scott Fitzgerald",1336));
        books.add(new Book("Pride and Prejudice","Gane Auston",455));

        Collections.sort(books);
        System.out.println("Book sorted by Title");

        for (Book book:books){
            System.out.println(book);
        }

    }
}