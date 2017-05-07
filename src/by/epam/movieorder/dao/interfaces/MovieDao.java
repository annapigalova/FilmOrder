package by.epam.movieorder.dao.interfaces;

import by.epam.movieorder.beans.Movie;
import by.epam.movieorder.dao.exception.DaoException;

public interface MovieDao {

	Movie showMovieInfo(String name) throws DaoException;

}
