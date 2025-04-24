package es.codeurjc.board.service;

import java.util.List;
import java.util.Optional;

public abstract class PostServiceInterface {

	public abstract void save(PostDto post);

	public abstract List<PostDto> findAll();

	public abstract Optional<PostDto> findById(long id);
	
	public void replace(PostDto updatedPost) {

		this.findById(updatedPost.getId()).orElseThrow();

		this.save(updatedPost);		
	}

	public abstract void deleteById(long id);

	
}
