package by.epam.movieorder.dao.interfaces;

import by.epam.movieorder.beans.User;
import by.epam.movieorder.dao.exception.DaoException;

public interface UserDao {
	User logIn(String login, String password) throws DaoException;
	boolean registration(User user) throws DaoException;

}
