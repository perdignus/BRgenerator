package infrastructure;
public class RootConnector {
	static final String DB_URL = "jdbc:oracle:thin:@ondora02.hu.nl:8521:cursus02";
	static final String DB_DRIVER = "oracle.jdbc.driver.OracleDriver";
	static final String DB_USERNAME = "tosad_2015_2c_team6";
	static final String DB_PASSWORD = "tosad_2015_2c_team6";
	
	static {
		try {
			Class.forName(DB_DRIVER).newInstance();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}	
}


