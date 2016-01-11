package infrastructure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class BusinessRuleDAO extends RootConnector {

	public ArrayList<String> getToBeGenerated() {
		ArrayList<String> ret = new ArrayList<String>();
		String query = "SELECT br.RuleNr, br.RuleTypeName FROM BusinessRule br WHERE br.Status IN ('created','edited');";

		try (Connection con = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
//			Statement stmt = con.createStatement();
//			ResultSet dbResultSet = stmt.executeQuery(query);
//			while (dbResultSet.next()) {
//				ret.add("" + dbResultSet.getInt(0) + "-" + dbResultSet.getString(1));
//			}
			
//			^ sde database is nog niet volledig
			ret.add("0-ATTRIBUTE_RANGE");
			ret.add("1-ATTRIBUTE_RANGE");
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}

		return ret;
	}

}
