package by.epam.movieorder.service.implementation;

import by.epam.movieorder.beans.Movie;
import by.epam.movieorder.dao.exception.DaoException;
import by.epam.movieorder.dao.factory.DaoFactory;
import by.epam.movieorder.dao.interfaces.MovieDao;
import by.epam.movieorder.service.MovieService;
import by.epam.movieorder.service.exception.ServiceException;

public class MovieServiceImpl implements MovieService {

	@Override
	public Movie showMovieInfo(String name) throws ServiceException {

		try {

			DaoFactory daoObjectFactory = DaoFactory.getInstance();
			MovieDao movieDao = daoObjectFactory.getSqlMovieImpl();
			Movie movie = movieDao.showMovieInfo(name);

			return movie;

		} catch (DaoException e) {

			throw new ServiceException(e);
		}
	}

}
