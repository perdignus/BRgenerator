package infrastructure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import data.AttributeCompareRule;
import data.BusinessRule;
import dto.DTO;

public class AttributeCompareDAO extends RootDAO {

	public BusinessRule getData(int id) {
		BusinessRule br = null;
		String query = "SELECT br.RuleName, br.BusinessRuleNr, tab.TableName, col.ColumnName,  atcr.CompareValue, atcr.Operator"
				+ "FROM BusinessRule br, Attribute_Compare_rule atcr, Column col, Table tab " + "WHERE br.RuleNr =" + id
				+ " AND br.RuleNr = atcr.RuleNr AND atcr.ColumNr=col.ColumnNr AND col.TableNr=tab.TableNr";
		try (Connection con = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
			Statement stmt = con.createStatement();
			ResultSet dbResultSet = stmt.executeQuery(query);

			while (dbResultSet.next()) {
				br = new AttributeCompareRule(dbResultSet.getString("RuleName"), dbResultSet.getInt("BusinessRuleNr"),
						dbResultSet.getString("TableName"), dbResultSet.getString("ColumnName"),
						dbResultSet.getString("Operator"), dbResultSet.getString("CompareValue"));
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}

		return br;
	}
	
	public DTO getDataDTO(int id){
		DTO dto = new DTO();
		
		String query = "SELECT br.RuleName, br.BusinessRuleNr, tab.TableName, col.ColumnName,  atcr.CompareValue, atcr.Operator"
				+ "FROM BusinessRule br, Attribute_Compare_rule atcr, Column col, Table tab " + "WHERE br.RuleNr =" + id
				+ " AND br.RuleNr = atcr.RuleNr AND atcr.ColumNr=col.ColumnNr AND col.TableNr=tab.TableNr";
		try (Connection con = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
			Statement stmt = con.createStatement();
			ResultSet dbResultSet = stmt.executeQuery(query);

			while (dbResultSet.next()) {
			dto.setRuleName(dbResultSet.getString("RuleName"));
			dto.setRuleNr(dbResultSet.getInt("BusinessRuleNr"));
			dto.setTable(dbResultSet.getString("TableName"));
			dto.setColumn(dbResultSet.getString("ColumnName"));
			dto.setOperator(dbResultSet.getString("Operator"));
			dto.setCompareValue(dbResultSet.getString("CompareValue"));
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		
		return dto;
	}

}
