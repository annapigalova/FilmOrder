package by.epam.movieorder.service;

import java.util.List;

import by.epam.movieorder.beans.Movie;
import by.epam.movieorder.service.exception.ServiceException;

public interface MovieService {
	Movie showMovieInfo(int movieId) throws ServiceException;
	List<Movie> searchMovieByName (String name) throws ServiceException;

}
