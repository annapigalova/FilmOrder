package by.epam.movieorder.dao.interfaces;

import by.epam.movieorder.beans.User;
import by.epam.movieorder.dao.exception.DaoException;

public interface CommentDao {
	boolean addComment(String text, User user, int movieId) throws DaoException;

//	void deleteComment(Comment comment) throws DaoException;

}
