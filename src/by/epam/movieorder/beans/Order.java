package by.epam.movieorder.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {

	private int id;
	private List<Movie> movieList = new ArrayList<>();
	private double totalAmount;
	private boolean isPay;
	private Date orderDate;

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

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

}
