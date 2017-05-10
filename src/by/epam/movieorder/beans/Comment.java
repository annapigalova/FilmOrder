package by.epam.movieorder.beans;

public class Comment {
	private int id; 
	private User user;  
	private String comment;
 
	
	public Comment (){
 	
	}

	public int getId() {
		return id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", user=" + user + ", comment=" + comment + "]";
	}
	
	
	

}
