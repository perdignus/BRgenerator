package infrastructure;

import java.util.ArrayList;

import data.BusinessRule;
import data.Typen.Type;

public class InfrastructureFacade {
	private RootDAO rdao;
	private TargetDAO tdao;
	private BusinessRuleDAO brdao;
	private BusinessRule br;

	public BusinessRule getData(int id, Type type) {
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

	public void runCode(String code) {
		tdao = new TargetDAO();
		tdao.excecute(code);
	}

	public ArrayList<String> getToBeGenerated() {
		brdao = new BusinessRuleDAO();
		return brdao.getToBeGenerated();
	}
}
