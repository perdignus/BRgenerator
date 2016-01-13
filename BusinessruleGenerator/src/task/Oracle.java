package task;

import data.BusinessRuleService;

public class Oracle extends TriggerGenerate {

	public Oracle(BusinessRuleService bc) {
		super(bc);
	}

	public String generateAttributeRangeTrigger() {
		StringBuilder sb = new StringBuilder();
		String name = bc.getNaamRule();
		String targetTable = bc.getTargetTable();
		String targetColum = bc.getTargetColum();
		int controleMinWaarde = bc.getMinWaarde();
		int controleMaxWaarde = bc.getMaxWaarde();
		boolean isIn = bc.getIsIn();
		String between;
		if (isIn) {
			between = "between";
		} else {
			between = "NOT between";
		}
		sb.append("CREATE OR REPLACE " + name);
		sb.append(" before insert or update of " + targetColum);
		sb.append(" on " + targetTable);
		sb.append(" begin");
		sb.append(" if(:NEW." + targetColum + " " + between + " " + controleMinWaarde + " and " + controleMaxWaarde
				+ ") then");
		sb.append(" raise_application_error(-20002,'trigger " + name + " violated');");
		sb.append(" end if;");
		sb.append("end " + name + ";");

		return sb.toString();
	}

	@Override
	public String generateAttributeCompareTrigger() {

		StringBuilder sb = new StringBuilder();
		String name = bc.getNaamRule();
		String targetTable = bc.getTargetTable();
		String targetColum = bc.getTargetColum();
		String operator = bc.getOperator();
		String compareValue = bc.getCompareValue().get(0);
		sb.append("CREATE OR REPLACE " + name);
		sb.append(" before insert or update of " + targetColum);
		sb.append(" on " + targetTable);
		sb.append(" begin");
		sb.append(" if(:NEW." + targetColum + " " + operator + " " + compareValue + ") then");
		sb.append(" raise_application_error(-20002,'trigger " + name + " violated');");
		sb.append(" end if;");
		sb.append("end " + name + ";");
		return sb.toString();
	}
	
	//test rick push

	@Override
	public String generateAttributeListTrigger() {

		StringBuilder sb = new StringBuilder();
		String name = bc.getNaamRule();
		String targetTable = bc.getTargetTable();
		String targetColum = bc.getTargetColum();
		boolean isIn = bc.getIsIn();
		boolean b = false;
		StringBuilder compareValue = new StringBuilder();
		for (String s : bc.getCompareValue()) {
			if (b) {
				compareValue.append(" ,");
			}
			compareValue.append(" '" + s + "' ");
			b = true;
		}
		compareValue.toString();
		sb.append("CREATE OR REPLACE " + name);
		sb.append(" before insert or update of " + targetColum);
		sb.append(" on " + targetTable);
		sb.append(" begin");
		if (isIn) {
			sb.append(" if(:NEW." + targetColum + " IN (" + compareValue + ")) then");
		} else {
			sb.append(" if(:NEW." + targetColum + " NOT IN (" + compareValue + ")) then");
		}
		sb.append(" raise_application_error(-20002,'trigger " + name + " violated');");
		sb.append(" end if;");
		sb.append("end " + name + ";");
		return sb.toString();
	}

	@Override
	public String generateAttributeOtherTrigger() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String generateTupleCompareTrigger() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String generateTupleOtherTrigger() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String generateEntityOtherTrigger() {
		// TODO Auto-generated method stub
		return null;
	}

}
