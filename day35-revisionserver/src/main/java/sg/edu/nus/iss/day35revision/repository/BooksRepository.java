package sg.edu.nus.iss.day35revision.repository;

import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import sg.edu.nus.iss.day35revision.model.Book;

@Repository
public class BooksRepository {
    
    @Autowired
    MongoTemplate mongoTemplate;

    public List<Book> findSimilarTitle(Integer limit, String text) {
        
        String cText = ".*" + text + ".*";
        Query query = new Query();
        query.addCriteria(Criteria.where("title")
            .regex(cText, "i"));
        query.limit(limit);

        List<Book> b = mongoTemplate.find(query, Document.class, "details")
                            .stream()
                            .map(d -> Book.createFromDoc(d))
                            .toList();

        System.out.println(">> in repo: " + b);

        return b;

    }
}
