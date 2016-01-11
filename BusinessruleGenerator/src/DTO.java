

import java.util.ArrayList;

import data.Typen.Type;

public class DTO {
	private String rootTabel;
	private String rootColum;
	private Type type;
	private int controleMinWaarde;
	private int controleMaxWaarde;
	private String controleWaarde;
	private String operator;
	private ArrayList<String> controleLijst;
	private boolean isIn;
	private String controleColum;

	public DTO(String rootTabel, String rootColum, Type type, String naam) {

	}

	public String getRootTabel() {
		return rootTabel;
	}

	public void setRootTabel(String rootTabel) {
		this.rootTabel = rootTabel;
	}

	public String getRootColum() {
		return rootColum;
	}

	public void setRootColum(String rootColum) {
		this.rootColum = rootColum;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public int getControleMinWaarde() {
		return controleMinWaarde;
	}

	public void setControleMinWaarde(int controleMinWaarde) {
		this.controleMinWaarde = controleMinWaarde;
	}

	public int getControleMaxWaarde() {
		return controleMaxWaarde;
	}

	public void setControleMaxWaarde(int controleMaxWaarde) {
		this.controleMaxWaarde = controleMaxWaarde;
	}

	public String getControleWaarde() {
		return controleWaarde;
	}

	public void setControleWaarde(String controleWaarde) {
		this.controleWaarde = controleWaarde;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public ArrayList<String> getControleLijst() {
		return controleLijst;
	}

	public void setControleLijst(ArrayList<String> controleLijst) {
		this.controleLijst = controleLijst;
	}

	public boolean isIn() {
		return isIn;
	}

	public void setIn(boolean isIn) {
		this.isIn = isIn;
	}

	public String getControleColum() {
		return controleColum;
	}

	public void setControleColum(String controleColum) {
		this.controleColum = controleColum;
	}

}
