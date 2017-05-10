package by.epam.movieorder.beans;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	
	private List <Movie> movieList = new ArrayList<>();

	public List <Movie> getMovieList() {
		return movieList;
	}

	public void addMovie(Movie movie) {
		movieList.add(movie);
	}
	
	

}
