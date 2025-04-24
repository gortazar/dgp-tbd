package es.codeurjc.board.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import es.codeurjc.board.repository.mongo.PostMongo;
import es.codeurjc.board.repository.mongo.PostMongoRepository;

public class PostServiceMongo extends PostServiceInterface {

	private ModelMapper mapper = new ModelMapper();
	private PostMongoRepository posts;

	public PostServiceMongo(PostMongoRepository posts) {
		this.posts = posts;
	}
	
	@Override
	public void save(PostDto post) {
		posts.save(mapper.map(post, PostMongo.class));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PostDto> findAll() {
		return mapper.map(posts.findAll(), List.class);
	}

	@Override
	public Optional<PostDto> findById(long id) {
		return mapper.map(posts.findById(id), Optional.class);
	}

	@Override
	public void deleteById(long id) {
		posts.deleteById(id);
	}

}
