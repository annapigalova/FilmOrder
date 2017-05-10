package by.epam.movieorder.controller.command.impl;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import by.epam.movieorder.beans.Cart;
import by.epam.movieorder.beans.Movie;
import by.epam.movieorder.controller.command.Command;

public class AddToCart implements Command {

	@Override
	public String execute(HttpServletRequest request) {

		String movieIdStr = request.getParameter("movieId");

		int movieId = Integer.parseInt(movieIdStr);

		String name = request.getParameter("name");

		String priceStr = request.getParameter("price");

		double price = Double.parseDouble(priceStr);

		Movie movie = new Movie();

		movie.setId(movieId);
		movie.setName(name);
		movie.setPrice(price);
		
		Cart cart = new Cart();
		
		
		HttpSession session = request.getSession();

		Object cartSession = session.getAttribute("cart");

		if (cartSession == null) {
			cart = new Cart();
		} else {
			cart = (Cart) cartSession;
		}

		cart.addMovie(movie);

		session.setAttribute("cart", cart);

		return request.getRequestURL().append('?').append((request.getParameter("url"))).toString();
	}

}
