package data;

import java.util.ArrayList;

import data.Typen.Type;
import infrastructure.BusinessRuleDAO;
import infrastructure.ObjectDAO;
import infrastructure.RootDAO;
import infrastructure.TargetDAO;

public class BusinessRuleService {
	private BusinessRule br;
	private BusinessRuleDAO brdao;
	private RootDAO rootDAO;
	private TargetDAO targetDAO;

	public void setBusinessRuleFromDAO(RootDAO rootDAO, TargetDAO targetDAO, int id) {
		this.rootDAO = rootDAO;
		this.targetDAO = targetDAO;
		br = rootDAO.getData(id);
	}

	public Type getRuleType() {
		return br.getType();
	}

	public ArrayList<String> getRulesToGenerate() {
		brdao = new BusinessRuleDAO();
		return brdao.getToBeGenerated();
	}

	public String getTargetColum() {
		return br.getRootColommen();
	}

	public String getNaamRule() {
		return br.getNaam();
	}

	public String getTargetTable() {
		return br.getRootTabel();
	}

	public int getMinWaarde() {
		return ((AttributeRangeRule) br).getControleMinWaarde();
	}

	public int getMaxWaarde() {
		return ((AttributeRangeRule) br).getControleMaxWaarde();
	}

	public boolean getIsIn() {
		boolean b = false;
		if (br.getType() == Typen.Type.ATTRIBUTE_RANGE) {
			b = ((AttributeRangeRule) br).getIsIn();
		}
		if (br.getType() == Typen.Type.ATTRIBUTE_LIST) {
			b = ((AttributeListRule) br).isIn();
		}
		return b;
	}

	public String getOperator() {
		return ((AttributeCompareRule) br).getOperator();
	}

	public ArrayList<String> getCompareValue() {
		ArrayList<String> ret = new ArrayList<String>();
		if (br.getType() == Typen.Type.ATTRIBUTE_RANGE) {
			ret.add(((AttributeCompareRule) br).getCompareValue());
		}
		if (br.getType() == Typen.Type.ATTRIBUTE_LIST) {
			ret = ((AttributeListRule) br).getCompareValues();
		}
		return ret;
	}

	public void excecuteCode(String code) {
		targetDAO.excecute(code);
		saveBusinessRule(br, "temp.obj");
	}

	public void saveBusinessRule(BusinessRule br, String naam) {
		ObjectDAO obDAO = new ObjectDAO();
		obDAO.save(br, naam);
	}

	public BusinessRule loadBusinessRule(String naam) {
		ObjectDAO obDAO = new ObjectDAO();
		return obDAO.load(naam);
	}

	// public void setDAO(DAO dao) {
	// // TODO Auto-generated method stub
	//
	// }
}
