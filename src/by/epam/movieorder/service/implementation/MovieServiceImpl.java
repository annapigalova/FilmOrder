package by.epam.movieorder.service.implementation;

import java.util.List;

import by.epam.movieorder.beans.Movie;
import by.epam.movieorder.dao.exception.DaoException;
import by.epam.movieorder.dao.factory.DaoFactory;
import by.epam.movieorder.dao.interfaces.MovieDao;
import by.epam.movieorder.service.MovieService;
import by.epam.movieorder.service.exception.ServiceException;

public class MovieServiceImpl implements MovieService {

	@Override
	public Movie showMovieInfo(int movieId) throws ServiceException {

		try {

			DaoFactory daoObjectFactory = DaoFactory.getInstance();
			MovieDao movieDao = daoObjectFactory.getSqlMovieImpl();
			Movie movie = movieDao.showMovieInfo(movieId);

			return movie;

		} catch (DaoException e) {

			throw new ServiceException(e);
		}
	}

	@Override
	public List<Movie> searchMovieByName(String name) throws ServiceException {
		try {

			DaoFactory daoObjectFactory = DaoFactory.getInstance();
			MovieDao movieDao = daoObjectFactory.getSqlMovieImpl();
			List<Movie> movieList = movieDao.searchMovieByName(name);

			return movieList;

		} catch (DaoException e) {

			throw new ServiceException(e);
		}
	}

}
