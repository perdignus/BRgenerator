package infrastructure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import data.AttributeCompareRule;
import data.BusinessRule;

public class AttributeCompareDAO extends RootDAO {

	public BusinessRule getData(int id) {
		BusinessRule br = null;
		String query = "SELECT br.RuleName, br.BusinessRuleNr, tab.TableName, col.ColumnName,  atcr.CompareValue, acrr.Operator, atcr.CompareType "
				+ "FROM BusinessRule br, Attribute_Compare_rule atcr, Column col, Table tab " + "WHERE br.RuleNr =" + id
				+ " AND br.RuleNr = atcr.RuleNr AND atcr.ColumNr=col.ColumnNr AND col.TableNr=tab.TableNr";
		try (Connection con = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
			Statement stmt = con.createStatement();
			ResultSet dbResultSet = stmt.executeQuery(query);

			while (dbResultSet.next()) {
				br = new AttributeCompareRule(dbResultSet.getString("RuleName"), dbResultSet.getInt("BusinessRuleNr"),
						dbResultSet.getString("TableName"), dbResultSet.getString("ColumnName"),
						dbResultSet.getString("Operator"), dbResultSet.getInt("CompareValue"));
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}

		return br;
	}

}
