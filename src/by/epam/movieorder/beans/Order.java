package by.epam.movieorder.beans;

import java.util.ArrayList;
import java.util.List;

public class Order {

	private int id;
	private List<Movie> movieList = new ArrayList<>();
	private boolean isPay;

	public Order() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {

		this.id = id;
	}

	public List<Movie> getMovieList() {
		return movieList;
	}

	public void addMovie(Movie e) {
		movieList.add(e);
	}

	public boolean isPay() {
		return isPay;
	}

	public void setPay(boolean isPay) {
		this.isPay = isPay;
	}

	@Override
	public String toString() {
		return "Order # " + id + System.lineSeparator() + movieList + System.lineSeparator() + "isPay= " + isPay;
	}

}
