package by.epam.movieorder.controller.command.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.epam.movieorder.beans.Movie;
import by.epam.movieorder.controller.command.Command;
import by.epam.movieorder.service.MovieService;
import by.epam.movieorder.service.exception.ServiceException;
import by.epam.movieorder.service.factory.ServiceFactory;

public class SearchFilm implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String name = request.getParameter("film");

		String goTo = null;
		try {

			ServiceFactory serviceFactory = ServiceFactory.getInstance();
			MovieService movieService = serviceFactory.getMovieService();
			List<Movie> movieList = movieService.searchMovieByName(name);
			request.setAttribute("movieList", movieList);
			goTo = "/SearchResult.jsp";
		 
		} catch (ServiceException e) {
			goTo = "/SearchResult.jsp";

		}
		return goTo;

	}
}
