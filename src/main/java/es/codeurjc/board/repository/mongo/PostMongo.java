package es.codeurjc.board.repository.mongo;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import es.codeurjc.board.model.Comment;

@Document
public class PostMongo {

	private static AtomicLong nextId = new AtomicLong(0);
	
	@Id
	private long id;

	private String user;
	private String title;
	private String text;
	private String image;

	private List<CommentMongo> comments;

	private byte[] imageFile;

	public PostMongo() {
		this.id = nextId.getAndIncrement();
	}

	public PostMongo(String user, String title, String text) {
		this();
		this.user = user;
		this.title = title;
		this.text = text;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String name) {
		this.user = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String content) {
		this.text = content;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public byte[] getImageFile() {
		return imageFile;
	}

	public void setImageFile(byte[] image) {
		this.imageFile = image;
	}

	public void addComment(CommentMongo savedComment) {
		this.comments.add(savedComment);
	}
}
