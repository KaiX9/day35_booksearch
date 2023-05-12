package sg.edu.nus.iss.day35revision.model;

import org.bson.Document;

import jakarta.json.Json;
import jakarta.json.JsonObject;

public class Book {
    
    private Integer bookID;
    private String title;
    private String authors;
    private double average_rating;
    private String language_code;
    private Integer num_pages;
    private Integer ratings_count;
    private Integer text_reviews_count;
    private String publication_date;
    private String publisher;

    public Book() {

    }
    
    public Book(Integer bookID, String title, String authors, double average_rating, String language_code,
            Integer num_pages, Integer ratings_count, Integer text_reviews_count, String publication_date,
            String publisher) {
        this.bookID = bookID;
        this.title = title;
        this.authors = authors;
        this.average_rating = average_rating;
        this.language_code = language_code;
        this.num_pages = num_pages;
        this.ratings_count = ratings_count;
        this.text_reviews_count = text_reviews_count;
        this.publication_date = publication_date;
        this.publisher = publisher;
    }

    public Integer getBookID() {
        return bookID;
    }
    public void setBookID(Integer bookID) {
        this.bookID = bookID;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthors() {
        return authors;
    }
    public void setAuthors(String authors) {
        this.authors = authors;
    }
    public double getAverage_rating() {
        return average_rating;
    }
    public void setAverage_rating(double average_rating) {
        this.average_rating = average_rating;
    }
    public String getLanguage_code() {
        return language_code;
    }
    public void setLanguage_code(String language_code) {
        this.language_code = language_code;
    }
    public Integer getNum_pages() {
        return num_pages;
    }
    public void setNum_pages(Integer num_pages) {
        this.num_pages = num_pages;
    }
    public Integer getRatings_count() {
        return ratings_count;
    }
    public void setRatings_count(Integer ratings_count) {
        this.ratings_count = ratings_count;
    }
    public Integer getText_reviews_count() {
        return text_reviews_count;
    }
    public void setText_reviews_count(Integer text_reviews_count) {
        this.text_reviews_count = text_reviews_count;
    }
    public String getPublication_date() {
        return publication_date;
    }
    public void setPublication_date(String publication_date) {
        this.publication_date = publication_date;
    }
    public String getPublisher() {
        return publisher;
    }
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    @Override
    public String toString() {
        return "Book [bookID=" + bookID + ", title=" + title + ", authors=" + authors + ", average_rating="
                + average_rating + ", language_code=" + language_code + ", num_pages=" + num_pages + ", ratings_count="
                + ratings_count + ", text_reviews_count=" + text_reviews_count + ", publication_date="
                + publication_date + ", publisher=" + publisher + "]";
    }

    public static Book createFromDoc(Document d) {
        Book b = new Book();

        b.setBookID(d.getInteger("bookID"));
        b.setTitle(d.getString("title"));
        b.setAuthors(d.getString("authors"));
        b.setAverage_rating(d.getDouble("average_rating"));
        b.setLanguage_code(d.getString("language_code"));
        b.setNum_pages(d.getInteger("num_pages"));
        b.setRatings_count(d.getInteger("ratings_count"));
        b.setText_reviews_count(d.getInteger("text_reviews_count"));
        b.setPublication_date(d.getString("publication_date"));
        b.setPublisher(d.getString("publisher"));
        
        return b;
    }

    public JsonObject toJSON() {
        return Json.createObjectBuilder()
            .add("bookID", getBookID())
            .add("title", getTitle())
            .build();
    }

}
