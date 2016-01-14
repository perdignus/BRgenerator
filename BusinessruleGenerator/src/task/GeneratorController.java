package task;

import java.util.ArrayList;

import data.BusinessRule;
import data.BusinessRuleService;
import data.Typen.Type;
import dto.DTO;
import infrastructure.AttributeCompareDAO;
import infrastructure.AttributeListDAO;
import infrastructure.AttributeRangeDAO;
import infrastructure.RootDAO;
import infrastructure.TargetDAO;

public class GeneratorController {
	
	private BusinessRuleService brc;
	//private ArrayList<String> br;
	private ArrayList<String> code;

	public GeneratorController(BusinessRuleService brc) {
		this.brc = brc;
		code = new ArrayList<String>();
		//br = new ArrayList<String>();
	}

	public ArrayList<String> controleer() {
		return brc.getRulesToGenerate();
	}
	
	public ArrayList<DTO> controleerDTO() {
		return brc.getRulesToGenerateDTO();
	}

	public void generate() {
		for (String s : controleer()) {
			String temp[] = s.split("-");
			int id = Integer.parseInt(temp[0]);
			TriggerGenerate tg;
			switch (temp[1]) {
			case "ATTRIBUTE_RANGE":
				//rootDAO = new AttributeRangeDAO();
				brc.setBusinessRuleFromDAO(id, Type.ATTRIBUTE_RANGE);
				tg = new Oracle(brc);
				code.add(tg.generateAttributeRangeTrigger());
				break;
			case "ATTRIBUTE_COMPARE":
				//rootDAO = new AttributeCompareDAO();
				brc.setBusinessRuleFromDAO(id, Type.ATTRIBUTE_COMPARE);
				tg = new Oracle(brc);
				code.add(tg.generateAttributeCompareTrigger());
				//test
				break;
			case "ATTRIBUTE_LIST":
				//rootDAO = new AttributeListDAO();
				brc.setBusinessRuleFromDAO(id, Type.ATTRIBUTE_LIST);
				tg = new Oracle(brc);
				code.add(tg.generateAttributeListTrigger());
				break;
			default:
				break;
			}
		}
	}
	
	public void generateFromDTO() {
		for (DTO dto : controleerDTO()) {
			
			int id = dto.getRuleNr();
			TriggerGenerate tg;
			switch (dto.getRuleType()) {
			case "ATTRIBUTE_RANGE":
				//rootDAO = new AttributeRangeDAO();
				brc.setBusinessRuleFromDAO(id, Type.ATTRIBUTE_RANGE);
				tg = new Oracle(brc);
				code.add(tg.generateAttributeRangeTrigger());
				break;
			case "ATTRIBUTE_COMPARE":
				//rootDAO = new AttributeCompareDAO();
				brc.setBusinessRuleFromDAO(id, Type.ATTRIBUTE_COMPARE);
				tg = new Oracle(brc);
				code.add(tg.generateAttributeCompareTrigger());
				//test
				break;
			case "ATTRIBUTE_LIST":
				//rootDAO = new AttributeListDAO();
				brc.setBusinessRuleFromDAO(id, Type.ATTRIBUTE_LIST);
				tg = new Oracle(brc);
				code.add(tg.generateAttributeListTrigger());
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
