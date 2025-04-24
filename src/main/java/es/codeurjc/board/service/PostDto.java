package es.codeurjc.board.service;

import java.sql.Blob;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class PostDto {

	private long id;

	private String user;
	private String title;
	private String text;
	private String image;

	private List<CommentDto> comments;

	private byte[] imageFile;

	public PostDto() {
	}

	public PostDto(String user, String title, String text) {
		super();
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

	public void addComment(CommentDto savedComment) {
		this.comments.add(savedComment);
	}
}
