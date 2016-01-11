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
		String query = "SELECT br.RuleName, br.BusinessRuleNr, tab.TableName, col.ColumnName,  atrr.MinimumValue, atrr.MaximumValue, attr.CompareType "
				+ "FROM BusinessRule br, Attribute_Range_rule atrr, Column col, Table tab " + "WHERE br.RuleNr =" + id
				+ " AND br.RuleNr = attr.RuleNr AND attr.ColumNr=col.ColumnNr AND col.TableNr=tab.TableNr";
		try (Connection con = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
			Statement stmt = con.createStatement();
			ResultSet dbResultSet = stmt.executeQuery(query);

			while (dbResultSet.next()) {
				br = new AttributeCompareRule(query, id, query, query);
//				break;
			}

			// ^database is nog niet compleet
			// if (id == 0) {
			// br = new AttributeRangeRule("name", id, "RootTable",
			// "RootColumn", 0, 2, true);
			// } else
			// br = new AttributeRangeRule("TEST", id, "RootTEST", "RootTEST",
			// 4, 2, false);
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}

		return br;
	}

}
