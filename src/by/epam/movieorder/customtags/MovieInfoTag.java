package by.epam.movieorder.customtags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import by.epam.movieorder.beans.Movie;

public class MovieInfoTag extends TagSupport {
	private static final long serialVersionUID = 1L;

	private Movie movie;

	public int doStartTag() throws JspException {

		JspWriter out = pageContext.getOut();

		try {

			out.write("<table border = '0' style='width:20%'>");
			out.write("<tr>" + "<th align = 'left'>Name</th>" + "<td align = 'left'>"
					+ ((movie.getName() == null) ? "" : movie.getName()) + "</td></tr>");
			out.write("<tr>" + "<th align = 'left'>Director</th>" + "<td align = 'left'>"
					+ ((movie.getDirector() == null) ? "" : movie.getDirector()) + "</td></tr>");
			out.write("<tr>" + "<th align = 'left'>Duration</th>" + "<td align = 'left'>"
					+ ((movie.getDuration() == 0) ? "" : movie.getDuration()) + "</td></tr>");
			out.write("<tr>" + "<th align = 'left'>Genre</th>" + "<td align = 'left'>"
					+ ((movie.getGenre() == null) ? "" : movie.getGenre()) + "</td></tr>");
			out.write("<tr>" + "<th align = 'left'>Description</th>" + "<td align = 'left'>"
					+ ((movie.getDescription() == null ? "" : movie.getDescription())) + "</td></tr>");
			out.write("<tr>" + "<th align = 'left'>Price</th>" + "<td align = 'left'>"
					+ ((movie.getPrice() == 0 ? "" : movie.getPrice())) + "</td></tr>");
			out.write("</table>");

		} catch (IOException e) {
			throw new JspException(e);
		}

		return SKIP_BODY;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

}
