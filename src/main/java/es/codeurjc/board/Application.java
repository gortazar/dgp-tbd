package es.codeurjc.board;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import es.codeurjc.board.repository.PostRepository;
import es.codeurjc.board.repository.mongo.PostMongoRepository;
import es.codeurjc.board.service.PostServiceSQL;
import es.codeurjc.board.service.PostServiceInterface;
import es.codeurjc.board.service.PostServiceMongo;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public PostServiceInterface postSvc(PostMongoRepository posts) {
		return new PostServiceMongo(posts);
	}
	
}