package data;

import data.Typen.Type;

public class AttributeCompareRule extends BusinessRule {
	private String operator;
	private int compareValue;

	public AttributeCompareRule(String naam, int id, String rootTabel, String rootColom, String operator,
			int compareValue) {
		super(naam, id, rootTabel, rootColom, Typen.Type.ATTRIBUTE_COMPARE);
		this.operator = operator;
		this.compareValue = compareValue;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public int getCompareValue() {
		return compareValue;
	}

	public void setCompareValue(int compareValue) {
		this.compareValue = compareValue;
	}

}
