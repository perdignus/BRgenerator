package infrastructure;

import data.BusinessRule;

public abstract class RootDAO extends RootConnector {
	public abstract BusinessRule getData(int id);
}
