package infrastructure;

import java.util.ArrayList;

import data.BusinessRule;
import data.Typen.Type;
import dto.DTO;

public class InfrastructureFacade {
	
	public BusinessRule getData(int id, Type type) {
		RootDAO rdao;
		BusinessRule br;
		switch (type) {
		case ATTRIBUTE_RANGE:
			rdao = new AttributeRangeDAO();
			br = rdao.getData(id);
			break;
		case ATTRIBUTE_COMPARE:
			rdao = new AttributeCompareDAO();
			br = rdao.getData(id);
			break;
		case ATTRIBUTE_LIST:
			rdao = new AttributeListDAO();
			br = rdao.getData(id);
			break;
		default:
			br = null;
			break;
		}
		return br;
	}
	
	public DTO getDataDTO(int id, Type type) {
		DTO dto = new DTO();
		RootDAO rdao;
		switch (type) {
		case ATTRIBUTE_RANGE:
			rdao = new AttributeRangeDAO();
			dto = rdao.getDataDTO(id);
			break;
		case ATTRIBUTE_COMPARE:
			rdao = new AttributeCompareDAO();
			dto = rdao.getDataDTO(id);
			break;
		case ATTRIBUTE_LIST:
			rdao = new AttributeListDAO();
			dto = rdao.getDataDTO(id);
			break;
		default:
			dto = null;
			break;
		}
		
		return dto;
	}

	public void runCode(String code) {
		TargetDAO tdao;
		tdao = new TargetDAO();
		tdao.excecute(code);
	}

	public ArrayList<String> getToBeGenerated() {
		BusinessRuleDAO brdao;
		brdao = new BusinessRuleDAO();
		return brdao.getToBeGenerated();
	}
}
