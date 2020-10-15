package it.contrader.dao;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;
import it.contrader.utils.ConnectionSingleton;
import it.contrader.model.App;

/**
 * 
 * @author Vittorio
 *
 *Per i dettagli della classe vedi Guida sez 6: DAO
 */
public class AppDAO implements DAO<App> {

	private final String QUERY_ALL = "SELECT app.*, apptype.* FROM app INNER JOIN apptype ON app.apptype = apptype.id";
	private final String QUERY_CREATE = "INSERT INTO app (appname, apptype) VALUES (?,?)";
	private final String QUERY_READ = "SELECT appname,tag FROM app,apptype where apptype.id = ?";
	private final String QUERY_UPDATE = "UPDATE app SET appname=?, apptype=? WHERE id=?";
	private final String QUERY_DELETE = "DELETE FROM app WHERE id=?";

	public AppDAO() {

	}

	public List<App> getAll() {
		List<App> appList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			App app;
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String appname = resultSet.getString("appname");
				String apptype = resultSet.getString("tag");
				app = new App(appname, apptype);
				app.setId(id);
				appList.add(app);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return appList;
	}

	public boolean insert(App appToInsert) {
		Connection connection = ConnectionSingleton.getInstance();
		try {	
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setString(1, appToInsert.getAppname());
			preparedStatement.setString(2, appToInsert.getApptype());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			return false;
		}

	}

	public App read(int appId) {
		Connection connection = ConnectionSingleton.getInstance();
		try {


			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, appId);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String appname, tag;

			appname = resultSet.getString("appname");
			tag = resultSet.getString("tag");
			App app = new App(appname, tag);
			app.setId(resultSet.getInt("id"));

			return app;
		} catch (SQLException e) {
			return null;
		}

	}

	public boolean update(App appToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		// Check if id is present
		if (appToUpdate.getId() == 0)
			return false;

		App appRead = read(Integer.parseInt(appToUpdate.getApptype()));//TODO controllare
		if (!appRead.equals(appToUpdate)) {
			try {
				// Fill the appToUpdate object
				if (appToUpdate.getAppname() == null || appToUpdate.getAppname().equals("")) {
					appToUpdate.setAppname(appRead.getAppname());
				}

				if (appToUpdate.getApptype() == null || appToUpdate.getApptype().equals("")) {
					appToUpdate.setApptype(appRead.getApptype());
				}

				// Update the app
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setString(1, appToUpdate.getAppname());
				preparedStatement.setString(2, appToUpdate.getApptype());
				preparedStatement.setInt(3, appToUpdate.getId());
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

