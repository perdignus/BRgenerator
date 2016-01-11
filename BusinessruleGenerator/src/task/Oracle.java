package task;

import data.BusinessRuleService;

public class Oracle extends TriggerGenerate {

	public Oracle(BusinessRuleService bc) {
		super(bc);
	}

	public String generateAttributeRangeTrigger() {
		String cod;
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
		cod = "CREATE OR REPLACE " + name;
		cod += " before insert or update of " + targetColum;
		cod += " on " + targetTable;
		cod += " begin";
		cod += " if(:NEW." + targetColum + " " + between + " " + controleMinWaarde + " and " + controleMaxWaarde
				+ ") then";
		cod += " raise_application_error(-20002,'trigger " + name + " violated');";
		cod += " end if;";
		cod += "end " + name + ";";

		return cod;
	}

	@Override
	public String generateAttributeCompareTrigger() {
		// TODO Auto-generated method stub
		return null;
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
