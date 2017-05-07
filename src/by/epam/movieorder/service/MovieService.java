package by.epam.movieorder.service;

import by.epam.movieorder.beans.Movie;
import by.epam.movieorder.service.exception.ServiceException;

public interface MovieService {
	Movie showMovieInfo(String name) throws ServiceException;

}
