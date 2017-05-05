package by.epam.movieorder.dao.interfaces;

import by.epam.movieorder.beans.Comment;

public interface CommentDao {
	void addComment(Comment comment);

	void deleteComment(Comment comment);

}
