package data;

import java.io.Serializable;

import data.Typen.Type;

public class BusinessRule implements Serializable{
	private String naam;
	private String Voorbeeld;
	private Type type;
	private String rootTabel;
	private String rootColom;
	private int id;

	public String getRootColom() {
		return rootColom;
	}

	public void setRootColom(String rootColom) {
		this.rootColom = rootColom;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRootTabel() {
		return rootTabel;
	}

	public void setRootTabel(String tabel) {
		this.rootTabel = tabel;
	}

	public String getRootColommen() {
		return rootColom;
	}

	public void setRootColommen(String colom) {
		this.rootColom = colom;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public BusinessRule(String naam, int id, String rootTabel, String rootColom, Type ruleType) {
		this.naam = naam;
		this.id = id;
		this.rootTabel = rootTabel;
		this.rootColom = rootColom;
		this.type = ruleType;
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public String getVoorbeeld() {
		return Voorbeeld;
	}

	public void setVoorbeeld(String voorbeeld) {
		Voorbeeld = voorbeeld;
	}

}
