package by.epam.movieorder.service.implementation;

import by.epam.movieorder.beans.User;
import by.epam.movieorder.dao.exception.DaoException;
import by.epam.movieorder.dao.factory.DaoFactory;
import by.epam.movieorder.dao.interfaces.UserDao;
import by.epam.movieorder.service.UserService;
import by.epam.movieorder.service.exception.ServiceException;

public class UserServiceImpl implements UserService {

	@Override
	public User logIn(String login, String password) throws ServiceException {
		try {

			DaoFactory daoObjectFactory = DaoFactory.getInstance();
			UserDao userDao = daoObjectFactory.getUserDao();
			User user = new User();
			user = userDao.logIn(login, password);

			return user;

		} catch (DaoException e) {
			throw new ServiceException(e);
		}

	}

	@Override
	public User resistration(User user) throws ServiceException {
		try {
			
			DaoFactory daoObjectFactory = DaoFactory.getInstance();
			UserDao userDao = daoObjectFactory.getUserDao();
			user = userDao.registration(user);
			
			return user;

		} catch (DaoException e) {
			
			throw new ServiceException(e);
		}

	}
}
