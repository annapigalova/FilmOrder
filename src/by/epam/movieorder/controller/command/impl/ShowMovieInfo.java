package by.epam.movieorder.controller.command.impl;



import javax.servlet.http.HttpServletRequest;

import by.epam.movieorder.beans.Movie;
import by.epam.movieorder.controller.command.Command;
import by.epam.movieorder.service.MovieService;
import by.epam.movieorder.service.exception.ServiceException;
import by.epam.movieorder.service.factory.ServiceFactory;

public class ShowMovieInfo implements Command {

	@Override
	public String execute(HttpServletRequest request) {

		String idStr = request.getParameter("movieid");

		int movieId = Integer.parseInt(idStr);

		String goTo = null;
		try {

			ServiceFactory serviceFactory = ServiceFactory.getInstance();
			MovieService movieService = serviceFactory.getMovieService();
			Movie movie = movieService.showMovieInfo(movieId);

			request.setAttribute("movie", movie);

			if (movie != null) {

				goTo = "/Film.jsp";
			} else {
				throw new ServiceException();

			}

		} catch (ServiceException e) {
			goTo = "/ErrorPage.jsp";

		}

		return goTo;
	}

}
