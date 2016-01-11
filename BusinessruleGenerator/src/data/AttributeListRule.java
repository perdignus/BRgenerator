package data;

import java.util.ArrayList;

public class AttributeListRule extends BusinessRule {
	private ArrayList<String> compareValues;
	private boolean isIn;

	public AttributeListRule(String naam, int id, String rootTabel, String rootColom, ArrayList<String> compareValues,
			boolean isIn) {
		super(naam, id, rootTabel, rootColom, Typen.Type.ATTRIBUTE_LIST);
		this.compareValues = compareValues;
		this.isIn = isIn;
	}

	public ArrayList<String> getCompareValues() {
		return compareValues;
	}

	public void setCompareValues(ArrayList<String> compareValues) {
		this.compareValues = compareValues;
	}

	public boolean isIn() {
		return isIn;
	}

	public void setIn(boolean isIn) {
		this.isIn = isIn;
	}

}
