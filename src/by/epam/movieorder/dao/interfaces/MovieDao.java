package by.epam.movieorder.dao.interfaces;

import java.util.List;

import by.epam.movieorder.beans.Movie;
import by.epam.movieorder.dao.exception.DaoException;

public interface MovieDao {

	Movie showMovieInfo(int movieId) throws DaoException;
	List<Movie> searchMovieByName(String name) throws DaoException;

}
