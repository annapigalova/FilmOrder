package by.epam.movieorder.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import by.epam.movieorder.beans.Comment;
import by.epam.movieorder.beans.Movie;
import by.epam.movieorder.beans.User;
import by.epam.movieorder.dao.connection.OracleConnection;
import by.epam.movieorder.dao.exception.DaoException;
import by.epam.movieorder.dao.interfaces.MovieDao;

public class SQLMovieDao implements MovieDao {

	@Override
	public Movie showMovieInfo(int movieId) throws DaoException {
		Connection connection = null;
		PreparedStatement prepareSt = null;
		ResultSet result = null;

		try {
			connection = OracleConnection.getConnection();

			String query = "SELECT m.movie_id as movie_id,name,director,genre,duration,description,price,c.TEXT as commenttext, u.LOGIN as login FROM  movies m left join comments c on m.MOVIE_ID = c.COMMENT_ID left join USERS u on u.USER_ID = c.USER_ID where m.movie_id=?";

			prepareSt = connection.prepareStatement(query);

			prepareSt.setInt(1, movieId);

			result = prepareSt.executeQuery();

			while (result.next()) {

				String movieName = result.getString("name");
				String director = result.getString("director");
				String genre = result.getString("genre");
				int duration = result.getInt("duration");
				String description = result.getString("description");
				double price = result.getDouble("price");
				String commentText = result.getString("commenttext");
				String comentatorLogin = result.getString("login");

				Movie movie = new Movie();

				movie.setId(movieId);
				movie.setName(movieName);
				movie.setDirector(director);
				movie.setGenre(genre);
				movie.setDuration(duration);
				movie.setDescription(description);
				movie.setPrice(price);

				Comment comment = new Comment();
				User user = new User();
				user.setLogin(comentatorLogin);
				comment.setUser(user);
				comment.setComment(commentText);

				movie.addComment(comment);

				return movie;

			}

			return null;

		} catch (SQLException e) {
			throw new DaoException(e);

		}
	}

	@Override
	public List<Movie> searchMovieByName(String name) throws DaoException {
		Connection connection = null;
		PreparedStatement prepareSt = null;
		ResultSet result = null;

		try {
			connection = OracleConnection.getConnection();

			String query = "SELECT movie_id, name FROM  movies where upper(name)  like ? ";

			prepareSt = connection.prepareStatement(query);

			prepareSt.setString(1, "%" + name.toUpperCase() + "%");

			result = prepareSt.executeQuery();
			List<Movie> movieList = new ArrayList<>();
			int i = 0;
			while (result.next()) {
				movieList.add(new Movie());
				movieList.get(i).setId(result.getInt("movie_id"));
				movieList.get(i).setName(result.getString("name"));
				i++;

			}
			return movieList;
		} catch (SQLException e) {
			throw new DaoException(e);

		}
	}
}
