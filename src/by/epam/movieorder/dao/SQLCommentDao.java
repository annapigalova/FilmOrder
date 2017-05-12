package by.epam.movieorder.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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

			String query = "INSERT INTO comments (comment_id, user_id, movie_id,  text, comment_dttm ) VALUES ( comments_seq.NEXTVAL,?,?,?, "
					+ "to_date('" + getCurrentTimeStamp() + "', 'yyyy-mm-dd hh24-mi-ss'))";

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

	private static String getCurrentTimeStamp() {

		Date date = Calendar.getInstance().getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		return sdf.format(date);

	}

}
