package by.epam.movieorder.dao.interfaces;

import by.epam.movieorder.beans.Movie;

public interface MovieDao {
	void addMovie (Movie movie);
	void deleteMovie (Movie movie);

}
