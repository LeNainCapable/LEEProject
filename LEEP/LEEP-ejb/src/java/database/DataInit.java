package database;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class DataInit {

	public static void createTables() {
		Configuration config = DBConnection.getConfig();
		//SchemaExport schemaExport = new SchemaExport(config);
		//schemaExport.create(true, true);
	}
}
