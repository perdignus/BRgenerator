package data;

public class AttributeRangeRule extends BusinessRule {
	private int controleMinWaarde;
	private int controleMaxWaarde;
	private Boolean isIn;

	public AttributeRangeRule(String naam, int id, String rootTabel, String rootColom, int controleMinWaarde,
			int controleMaxWaarde, boolean isIn) {
		super(naam, id, rootTabel, rootColom, null);
		this.controleMaxWaarde = controleMaxWaarde;
		this.controleMinWaarde = controleMinWaarde;
		this.isIn = isIn;
	}

	public Boolean getIsIn() {
		return isIn;
	}

	public void setIsIn(Boolean isIn) {
		this.isIn = isIn;
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
}
