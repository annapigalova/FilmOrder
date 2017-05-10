package by.epam.movieorder.dao.interfaces;

import by.epam.movieorder.beans.User;
import by.epam.movieorder.dao.exception.DaoException;

public interface UserDao {
	User logIn(String login, String password) throws DaoException;
	User registration(User user) throws DaoException;

}
