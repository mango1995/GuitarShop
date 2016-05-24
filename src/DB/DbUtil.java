package DB;



import java.sql.*;

public class DbUtil {
	private String DBDriver = "org.sqlite.JDBC";
	public Connection conn = null;
	public ResultSet rs = null;
	
	


   
    
	public ResultSet query(String mySql) throws Exception {
		try {
			Class.forName(DBDriver);
			conn = DriverManager.getConnection("jdbc:sqlite://e:/Guitars.s3db");
			Statement stmt = conn.createStatement();
			rs = stmt.executeQuery(mySql);
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Guitar²éÑ¯³ö´í£º"+e.getMessage());
		}
		return null;
	}

	public void update(String mySql) throws Exception {
		try {
			Class.forName(DBDriver);
			conn = DriverManager.getConnection("jdbc:sqlite://e:/Guitars.s3db");
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(mySql);
			stmt.close();
			conn.close();
		} catch (SQLException ee) {
			// TODO Auto-generated catch block
			System.out.println(ee.getMessage());
		}
	}

	public void setDBDriver(String DBDriver) {
		this.DBDriver = DBDriver;
	}

	public String getDBDriver() {
		return DBDriver;
	}

}
