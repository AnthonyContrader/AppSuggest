package it.contrader.dao;

import it.contrader.model.Apptype;
import it.contrader.utils.ConnectionSingleton;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Vittorio
 *
 *Per i dettagli della classe vedi Guida sez 6: DAO
 */
public class ApptypeDAO implements DAO<Apptype> {

	private final String QUERY_ALL = "SELECT * FROM apptype";
	private final String QUERY_CREATE = "INSERT INTO apptype (tag) VALUES (?)";
	private final String QUERY_READ = "SELECT * FROM apptype WHERE id=?";
	private final String QUERY_UPDATE = "UPDATE apptype SET tag=? WHERE id=?";
	private final String QUERY_DELETE = "DELETE FROM apptype WHERE id=?";

	public ApptypeDAO() {

	}

	public List<Apptype> getAll() {
		List<Apptype> apptypesList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Apptype apptype;
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String tag = resultSet.getString("tag");
				apptype = new Apptype(tag);
				apptype.setId(id);
				apptypesList.add(apptype);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return apptypesList;
	}

	public boolean insert(Apptype apptypeToInsert) {
		Connection connection = ConnectionSingleton.getInstance();
		try {	
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setString(1, apptypeToInsert.getTag());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			return false;
		}

	}

	public Apptype read(int apptypeId) {
		Connection connection = ConnectionSingleton.getInstance();
		try {


			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, apptypeId);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String tag;

			tag = resultSet.getString("tag");
			Apptype apptype = new Apptype(tag);
			apptype.setId(resultSet.getInt("id"));

			return apptype;
		} catch (SQLException e) {
			return null;
		}

	}

	public boolean update(Apptype apptypeToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		// Check if id is present
		if (apptypeToUpdate.getId() == 0)
			return false;

		Apptype apptypeRead = read(apptypeToUpdate.getId());
		if (!apptypeRead.equals(apptypeToUpdate)) {
			try {
				// Fill the apptypeToUpdate object
				if (apptypeToUpdate.getTag() == null || apptypeToUpdate.getTag().equals("")) {
					apptypeToUpdate.setTag(apptypeRead.getTag());
				}

				// Update the apptype
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setString(1, apptypeToUpdate.getTag());
				preparedStatement.setInt(2, apptypeToUpdate.getId());
				int a = preparedStatement.executeUpdate();
				if (a > 0)
					return true;
				else
					return false;

			} catch (SQLException e) {
				return false;
			}
		}

		return false;

	}

	public boolean delete(int id) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setInt(1, id);
			int n = preparedStatement.executeUpdate();
			if (n != 0)
				return true;

		} catch (SQLException e) {
		}
		return false;
	}


}
