package by.epam.movieorder.controller.command.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.epam.movieorder.beans.Movie;
import by.epam.movieorder.controller.command.Command;
import by.epam.movieorder.service.MovieService;
import by.epam.movieorder.service.OrderService;
import by.epam.movieorder.service.exception.ServiceException;
import by.epam.movieorder.service.factory.ServiceFactory;

public class ShowMovieInfo implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		System.out.println("aaa");
		String movieName = request.getParameter("moviename");
		String goTo = null;
		try {
			ServiceFactory serviceFactory = ServiceFactory.getInstance();
			MovieService movieService = serviceFactory.getMovieService();
			Movie movie = movieService.showMovieInfo(movieName);
			System.out.println(movie);
			if (movie != null) {
				System.out.println("Info was found");

				goTo = "/film.jsp";
			} else {
				throw new ServiceException();

			}

		} catch (ServiceException e) {
			goTo = "/ShoppingCart.jsp";

		}

		return goTo;
	}

}
