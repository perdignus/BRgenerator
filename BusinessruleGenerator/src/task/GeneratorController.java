package task;

import java.util.ArrayList;

import data.BusinessRule;
import data.BusinessRuleService;
import infrastructure.AttributeRangeDAO;
import infrastructure.RootDAO;
import infrastructure.TargetDAO;

public class GeneratorController {
	private RootDAO rootDAO;
	private TargetDAO targetDAO;
	private BusinessRuleService brc;
	private ArrayList<String> br;
	private ArrayList<String> code;

	public GeneratorController(BusinessRuleService brc) {
		this.brc = brc;
		code = new ArrayList<String>();
		br = new ArrayList<String>();
		targetDAO = new TargetDAO();
	}

	public ArrayList<String> controleer() {
		return brc.getRulesToGenerate();
	}

	public void generate() {
		for (String s : controleer()) {
			String temp[] = s.split("-");
			int id = Integer.parseInt(temp[0]);
			TriggerGenerate tg;
			switch (temp[1]) {
			case "ATTRIBUTE_RANGE":
				rootDAO = new AttributeRangeDAO();
				brc.setBusinessRuleFromDAO(rootDAO, targetDAO, id);
				tg = new Oracle(brc);
				code.add(tg.generateAttributeRangeTrigger());
				break;
			default:
				break;
			}
		}
	}

	public ArrayList<String> getCode() {
		return code;
	}

	public BusinessRule loadBusinessRule(String naam) {
		return brc.loadBusinessRule(naam);
	}

	public void saveBusinessRule(BusinessRule br, String naam) {
		brc.saveBusinessRule(br, naam);
	}

	public void excecute(String code) {
		brc.excecuteCode(code);
	}

}
