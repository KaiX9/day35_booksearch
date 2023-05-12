package sg.edu.nus.iss.day35revision.controller;

import java.io.StringReader;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonArrayBuilder;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import sg.edu.nus.iss.day35revision.model.Book;
import sg.edu.nus.iss.day35revision.repository.BooksRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class BookController {
    
    @Autowired
    private BooksRepository bkRepo;

    // @PostMapping(path="/book", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    // public ResponseEntity<String> getBookByTitle(@RequestBody MultiValueMap<String, String> form) {
    //     System.out.printf(">>> in getBookByTitle\n");

    //     String text = form.getFirst("text");

    //     List<Book> books = bkRepo.findSimilarTitle(10, text);
    //     System.out.println(">> in controller: " + books);
    //     JsonArrayBuilder arrBuilder = Json.createArrayBuilder();

    //     for (Book b : books) {
    //         arrBuilder.add(b.toJSON());
    //     }

    //     JsonArray resp = arrBuilder.build();

    //     return ResponseEntity.status(HttpStatus.OK)
    //                         .contentType(MediaType.APPLICATION_JSON)
    //                         .body(resp.toString());

    // }

    @PostMapping(path="/book", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getBookByTitleJson(@RequestBody String payload) {
        
        JsonReader reader = Json.createReader(new StringReader(payload));
        JsonObject jsonObj = reader.readObject();
        String text = jsonObj.getString("title");

        List<Book> books = bkRepo.findSimilarTitle(10, text);
        System.out.println(">> in controller: " + books);
        JsonArrayBuilder arrBuilder = Json.createArrayBuilder();

        for (Book b : books) {
            arrBuilder.add(b.toJSON());
        }

        JsonArray resp = arrBuilder.build();

        return ResponseEntity.status(HttpStatus.OK)
                            .contentType(MediaType.APPLICATION_JSON)
                            .body(resp.toString());

    }

}
