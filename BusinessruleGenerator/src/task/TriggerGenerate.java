package task;

import data.BusinessRuleService;

public abstract class TriggerGenerate {
	protected String code;
	protected BusinessRuleService bc;

	public TriggerGenerate(BusinessRuleService bc){
		this.bc=bc;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public abstract String generateAttributeRangeTrigger();
	public abstract String generateAttributeCompareTrigger();
	public abstract String generateAttributeListTrigger();
	public abstract String generateAttributeOtherTrigger();
	public abstract String generateTupleCompareTrigger();
	public abstract String generateTupleOtherTrigger();
	public abstract String generateEntityOtherTrigger();
	
	
}
