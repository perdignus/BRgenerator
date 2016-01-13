package infrastructure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import data.AttributeListRule;
import data.BusinessRule;
import dto.DTO;

public class AttributeListDAO extends RootDAO {

	public BusinessRule getData(int id) {
		BusinessRule br = null;
		ArrayList<String> values = new ArrayList<String>();
		String query = "SELECT br.RuleName, br.BusinessRuleNr, tab.TableName, col.ColumnName, atlr.Operator"
				+ "FROM BusinessRule br, Attribute_List_rule atlr, Column col, Table tab " + "WHERE br.RuleNr =" + id
				+ " AND br.RuleNr = atlr.RuleNr AND atlr.ColumNr=col.ColumnNr AND col.TableNr=tab.TableNr";
		String query2 = "SELECT alrv.CompareValue" + "FROM Attribute_List_rule atlr, Attribute_List_Rule_Values alrv "
				+ "WHERE atlr.RuleNr =" + id + " AND atlr.RuleNr = alrv.RuleNr ";
		try (Connection con = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
			Statement stmt = con.createStatement();
			ResultSet dbResultSet = stmt.executeQuery(query);
			ResultSet dbResultSet2 = stmt.executeQuery(query2);
			while (dbResultSet2.next()) {
				values.add(dbResultSet2.getString("CompareValue"));
			}
			while (dbResultSet.next()) {
				br = new AttributeListRule(dbResultSet.getString("RuleName"), dbResultSet.getInt("BusinessRuleNr"),
						dbResultSet.getString("TableName"), dbResultSet.getString("ColumnName"), values,
						(dbResultSet.getString("Operator").equals("true")));
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}

		return br;
	}
	
	public DTO getDataDTO(int id) {
		DTO dto = new DTO();
		ArrayList<String> values = new ArrayList<String>();
	
		String query = "SELECT br.RuleName, br.BusinessRuleNr, tab.TableName, col.ColumnName, atlr.Operator"
				+ "FROM BusinessRule br, Attribute_List_rule atlr, Column col, Table tab " + "WHERE br.RuleNr =" + id
				+ " AND br.RuleNr = atlr.RuleNr AND atlr.ColumNr=col.ColumnNr AND col.TableNr=tab.TableNr";
		String query2 = "SELECT alrv.CompareValue" + "FROM Attribute_List_rule atlr, Attribute_List_Rule_Values alrv "
				+ "WHERE atlr.RuleNr =" + id + " AND atlr.RuleNr = alrv.RuleNr ";
		try (Connection con = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
			Statement stmt = con.createStatement();
			ResultSet dbResultSet = stmt.executeQuery(query);
			ResultSet dbResultSet2 = stmt.executeQuery(query2);
			while (dbResultSet2.next()) {
				values.add(dbResultSet2.getString("CompareValue"));
			}
			while (dbResultSet.next()) {
				
				dto = new DTO();
				dto.setRuleName(dbResultSet.getString("RuleName"));
				dto.setRuleNr(dbResultSet.getInt("BusinessRuleNr"));
				dto.setTable(dbResultSet.getString("TableName"));
				dto.setColumn(dbResultSet.getString("ColumnName"));
				dto.setIsIn(dbResultSet.getString("Operator").equals("true"));
				dto.setControleLijst(values);
				
				
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return dto;
	}

}
