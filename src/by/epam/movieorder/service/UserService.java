package by.epam.movieorder.service;

import by.epam.movieorder.beans.User;
import by.epam.movieorder.dao.exception.DaoException;
import by.epam.movieorder.service.exception.ServiceException;

public interface UserService {
	
	User logIn (String login, String password) throws ServiceException;
	boolean resistration (User user) throws ServiceException;

}
