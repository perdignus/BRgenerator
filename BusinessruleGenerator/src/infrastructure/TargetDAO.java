package infrastructure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import data.BusinessRule;

public class TargetDAO extends TargetConnector{

	public void excecute(String query) {
		try (Connection con = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
			Statement stmt = con.createStatement();
			ResultSet dbResultSet = stmt.executeQuery(query);
			// database is nog niet correct
			System.out.println(query);
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}

	}

}
