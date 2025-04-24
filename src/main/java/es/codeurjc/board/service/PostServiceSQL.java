package es.codeurjc.board.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;

import es.codeurjc.board.model.Post;
import es.codeurjc.board.repository.PostRepository;

public class PostServiceSQL extends PostServiceInterface {
	
	private PostRepository posts;
	private ModelMapper mapper = new ModelMapper();
	
	public PostServiceSQL(PostRepository posts) {
		this.posts = posts;
	}

	public void deleteById(long id) {
		
		posts.deleteById(id);		
	}

	public void save(PostDto post) {
		posts.save(mapper.map(post, Post.class));		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PostDto> findAll() {
		return mapper.map(posts.findAll(), List.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Optional<PostDto> findById(long id) {
		return mapper.map(posts.findById(id), Optional.class);
	}
}
