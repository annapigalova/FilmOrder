package by.epam.movieorder.beans;

import java.sql.Timestamp;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Comment {
	private int id;
	private User user;
	private String comment;
	private Timestamp commentDt;

	public Comment() {

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

	public Timestamp getCommentDt() {
		return commentDt;
	}

	public void setCommentDt(Timestamp commentDt) {
		this.commentDt = commentDt;
	}

	

}
