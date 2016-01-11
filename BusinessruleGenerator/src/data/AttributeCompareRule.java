package data;

import data.Typen.Type;

public class AttributeCompareRule extends BusinessRule{

	public AttributeCompareRule(String naam, int id, String rootTabel, String rootColom) {
		super(naam, id, rootTabel, rootColom, Typen.Type.ATTRIBUTE_COMPARE);
	}

}
