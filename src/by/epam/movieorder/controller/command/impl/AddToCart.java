package by.epam.movieorder.controller.command.impl;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import by.epam.movieorder.beans.Movie;
import by.epam.movieorder.controller.command.Command;
import by.epam.movieorder.service.exception.ServiceException;

public class AddToCart implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		String movieIdStr = request.getParameter("movieId");

		int movieId = Integer.parseInt(movieIdStr);

		String name = request.getParameter("name");

		String priceStr = request.getParameter("price");

		double price = Double.parseDouble(priceStr);

		Movie movie = new Movie();

		movie.setId(movieId);
		movie.setName(name);
		movie.setPrice(price);

		HttpSession session = request.getSession();

		List<Movie> movieList;

		if (session.getAttribute("movieList") == null) {
			movieList = new ArrayList<>();
		} else {

			movieList = (ArrayList<Movie>) session.getAttribute("movieList");
		}

		movieList.add(movie);

		session.setAttribute("movieList", movieList);
		
		return "/Film.jsp";
	}

}
