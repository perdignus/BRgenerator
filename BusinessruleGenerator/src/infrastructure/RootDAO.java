package infrastructure;

import data.BusinessRule;
import dto.DTO;

public abstract class RootDAO extends RootConnector {
	public abstract BusinessRule getData(int id);
	public abstract DTO getDataDTO(int id);
}
