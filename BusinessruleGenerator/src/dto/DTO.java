package dto;


import java.util.ArrayList;

import data.Typen.Type;

public class DTO {
	
	
	private ArrayList<String> controleLijst;
	private boolean isIn;
	private String ruleName;
	private int ruleNr;
	private String table;
	private String column;
	private String operator;
	private String compareValue;
	private String ruleType;
	
	public DTO() {
	 
	}

	public ArrayList<String> getControleLijst() {
		return controleLijst;
	}

	public void setControleLijst(ArrayList<String> controleLijst) {
		this.controleLijst = controleLijst;
	}

	public boolean getIsIn() {
		return isIn;
	}

	public void setIsIn(boolean isIn) {
		this.isIn = isIn;
	}

	public String getRuleName() {
		return ruleName;
	}

	public void setRuleName(String ruleName) {
		this.ruleName = ruleName;
	}

	public int getRuleNr() {
		return ruleNr;
	}

	public void setRuleNr(int ruleNr) {
		this.ruleNr = ruleNr;
	}

	public String getTable() {
		return table;
	}

	public void setTable(String table) {
		this.table = table;
	}

	public String getColumn() {
		return column;
	}

	public void setColumn(String column) {
		this.column = column;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getCompareValue() {
		return compareValue;
	}

	public void setCompareValue(String compareValue) {
		compareValue = compareValue;
	}

	public String getRuleType() {
		return ruleType;
	}

	public void setRuleType(String ruleType) {
		this.ruleType = ruleType;
	}

}
