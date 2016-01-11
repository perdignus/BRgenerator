package data;

public class AttributeCompareRule extends BusinessRule {
	private String operator;
	private String compareValue;

	public AttributeCompareRule(String naam, int id, String rootTabel, String rootColom, String operator,
			String compareValue) {
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

	public String getCompareValue() {
		return compareValue;
	}

	public void setCompareValue(String compareValue) {
		this.compareValue = compareValue;
	}

}
