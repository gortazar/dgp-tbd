package es.codeurjc.board.service;

public class CommentDto {

	private long id;
    private String user;
    private String text;

    public String getUser() {
        return user;
    }
    public void setUser(String user) {
        this.user = user;
    }
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }

    
}
