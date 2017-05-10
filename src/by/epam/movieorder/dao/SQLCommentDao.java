package by.epam.movieorder.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import by.epam.movieorder.beans.Comment;
import by.epam.movieorder.beans.User;
import by.epam.movieorder.dao.connection.OracleConnection;
import by.epam.movieorder.dao.exception.DaoException;
import by.epam.movieorder.dao.interfaces.CommentDao;

public class SQLCommentDao implements CommentDao {

	@Override
	public boolean addComment(String text, User user, int movieId) throws DaoException {
		Connection connection = null;
		PreparedStatement prepareSt = null;
		boolean isStatusOk = false;

		try {
			connection = OracleConnection.getConnection();

			String query = "INSERT INTO comments (comment_id, user_id, movie_id,  text) VALUES ( comments_seq.NEXTVAL,?,?,?)";

			prepareSt = connection.prepareStatement(query);

			connection.setAutoCommit(false);

			int userId = user.getId();
			String commentText = text;

			prepareSt.setInt(1, userId);
			prepareSt.setInt(2, movieId);
			prepareSt.setString(3, commentText);
			prepareSt.executeUpdate();
			connection.commit();
			isStatusOk = true;
			return isStatusOk;
		} catch (SQLException e) {
			throw new DaoException(e);

		}
	}

}
