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
//		String name = bc.getNaamRule();
//		String targetTable = bc.getTargetTable();
//		String targetColum = bc.getTargetColum();
//		String operator = bc.getOperator();
//		int compareValue = bc.getCompareVaule();
		StringBuilder sb = new StringBuilder();
//		sb.append("CREATE OR REPLACE " + name);
//		sb.append(" before insert or update of " + targetColum);
//		sb.append(" on " + targetTable);
//		sb.append(" begin");
//		sb.append(" if(:NEW." + targetColum + " " + between + " " + controleMinWaarde + " and " + controleMaxWaarde
//				+ ") then");
//		sb.append(" raise_application_error(-20002,'trigger " + name + " violated');");
//		sb.append(" end if;");
//		sb.append("end " + name + ";");
		return sb.toString();
	}

	@Override
	public String generateAttributeListTrigger() {
		// TODO Auto-generated method stub
		return null;
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
