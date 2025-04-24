package es.codeurjc.board.controller;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

import java.io.IOException;
import java.net.URI;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.engine.jdbc.BlobProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import es.codeurjc.board.model.Post;
import es.codeurjc.board.service.PostDto;
import es.codeurjc.board.service.PostServiceSQL;
import es.codeurjc.board.service.PostServiceInterface;

@RestController
@RequestMapping("/posts")
public class PostController {

	@Autowired
	private PostServiceInterface posts;

	@GetMapping("/")
	public List<PostDto> getPosts() {
		return posts.findAll();
	}

	@GetMapping("/{id}")
	public PostDto getPost(@PathVariable long id) {

		return posts.findById(id).orElseThrow();
	}

	@PostMapping("/")
	public ResponseEntity<PostDto> createPost(@RequestBody PostDto post) {

		posts.save(post);

		URI location = fromCurrentRequest().path("/{id}").buildAndExpand(post.getId()).toUri();

		return ResponseEntity.created(location).body(post);
	}

	@PutMapping("/{id}")
	public PostDto replacePost(@RequestBody PostDto newPost, @PathVariable long id) {

		newPost.setId(id);

		posts.replace(newPost);

		return newPost;
	}

	@DeleteMapping("/{id}")
	public PostDto deletePost(@PathVariable long id) {

		PostDto post = posts.findById(id).orElseThrow();

		posts.deleteById(id);

		return post;
	}

	@PostMapping("/{id}/image")
	public ResponseEntity<Object> uploadImage(@PathVariable long id, @RequestParam MultipartFile imageFile)
			throws IOException {

		PostDto post = posts.findById(id).orElseThrow();

		URI location = fromCurrentRequest().build().toUri();

		post.setImage(location.toString());
		post.setImageFile(imageFile.getInputStream().readAllBytes());
		posts.save(post);

		return ResponseEntity.created(location).build();
	}

//	@GetMapping("/{id}/image")
//	public ResponseEntity<Object> downloadImage(@PathVariable long id) throws SQLException {
//
//		PostDto post = posts.findById(id).orElseThrow();
//
//		if (post.getImageFile() != null) {
//
//			Resource file = new InputStreamResource(post.getImageFile());
//
//			return ResponseEntity.ok().header(HttpHeaders.CONTENT_TYPE, "image/jpeg")
//					.contentLength(post.getImageFile().length()).body(file);
//
//		} else {
//			return ResponseEntity.notFound().build();
//		}
//	}
//
//	@DeleteMapping("/{id}/image")
//	public ResponseEntity<Object> deleteImage(@PathVariable long id) throws IOException {
//
//		Post post = posts.findById(id).orElseThrow();
//
//		post.setImageFile(null);
//		post.setImage(null);
//		
//		posts.save(post);
//
//		return ResponseEntity.noContent().build();
//	}
}
