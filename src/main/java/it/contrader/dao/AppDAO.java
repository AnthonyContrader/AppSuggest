package it.contrader.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import it.contrader.main.ConnectionSingleton;
import it.contrader.model.App;

public class AppDAO {
	private final String QUERY_ALL = "SELECT * FROM app";
	private final String QUERY_CREATE = "INSERT INTO app (appname, apptype) VALUES (?,?)";
	private final String QUERY_READ = "SELECT * FROM app WHERE id=?";
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
				String apptype = resultSet.getString("apptype");
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
			String appname, apptype;

			appname = resultSet.getString("appname");
			apptype = resultSet.getString("apptype");
			App app = new App(appname, apptype);
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

		App appRead = read(appToUpdate.getId());
		if (!appRead.equals(appToUpdate)) {
			try {
				// Fill the userToUpdate object
				if (appToUpdate.getAppname() == null || appToUpdate.getAppname().equals("")) {
					appToUpdate.setAppname(appRead.getAppname());
				}

				if (appToUpdate.getApptype() == null || appToUpdate.getApptype().equals("")) {
					appToUpdate.setApptype(appRead.getApptype());
				}

				// Update the user
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setString(2, appToUpdate.getAppname());
				preparedStatement.setString(3, appToUpdate.getApptype());
				preparedStatement.setInt(1, appToUpdate.getId());
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
