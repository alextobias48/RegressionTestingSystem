package classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PendingTests {

public String TestCaseName;
public String ScriptType;
public String Script;
public String ScheduleName;
public String Time;
public String Day;
public String Environment;
public String Os;	
	
	public PendingTests(String TestCaseName, String ScriptType, String Script, String ScheduleName, String Time, String Day,
			String Environment, String Os) {
		this.TestCaseName = TestCaseName;
		this.ScriptType = ScriptType;
		this.Script = Script;
		this.ScheduleName = ScheduleName;
		this.Time = Time;
		this.Day = Day;
		this.Environment = Environment;
		this.Os = Os;
	}
	
	public PendingTests() {
		// TODO Auto-generated constructor stub
	}


public PendingTests getPendingTests(){
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (InstantiationException e) {
			System.out.println("InstantiationException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			System.out.println("IllegalAccessException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
		Connection conn = null;

		try {
			conn = DriverManager.getConnection(DatabaseInfo.url, DatabaseInfo.username, DatabaseInfo.password);
		} catch (SQLException e) {
			System.out.println("SQLException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		String query = "SELECT * FROM PendingTests";
		PreparedStatement ps = null;
		ResultSet rs = null;
		PendingTests pendTest = new PendingTests();
		try {
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				pendTest.setTestCaseName(rs.getString("TestCaseName"));
				pendTest.setScriptType(rs.getString("ScriptType"));
				pendTest.setScript(rs.getString("Script"));
				pendTest.setScheduleName(rs.getString("ScheduleName"));
				pendTest.setTime(rs.getString("Time"));
				pendTest.setDay(rs.getString("Day"));
				pendTest.setEnvironment(rs.getString("Environment"));
				pendTest.setOs(rs.getString("Os"));
			}
			rs.close();
		}catch (SQLException e) {
			System.out.println("SQLException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		}try {
			if(rs != null && !rs.isClosed())
				rs.close();
			if(ps != null && !ps.isClosed())
				ps.close();
			if(conn != null && !conn.isClosed())
				conn.close();
		} catch (SQLException e) {
			System.out.println("SQLException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return pendTest;	
	}

	public void deletePendingTest(){	
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (InstantiationException e) {
			System.out.println("InstantiationException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			System.out.println("IllegalAccessException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
		Connection conn = null;

		try {
			conn = DriverManager.getConnection(DatabaseInfo.url, DatabaseInfo.username, DatabaseInfo.password);
		} catch (SQLException e) {
			System.out.println("SQLException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		String query = "DELETE FROM PendingTests;";
		PreparedStatement ps = null;
		ResultSet rs = null;
		TestCase testCase = new TestCase();
		
		try {
			ps = conn.prepareStatement(query);
			ps.executeUpdate();
		}catch (SQLException e) {
			System.out.println("SQLException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		}try {
			if(rs != null && !rs.isClosed())
				rs.close();
			if(ps != null && !ps.isClosed())
				ps.close();
			if(conn != null && !conn.isClosed())
				conn.close();
		} catch (SQLException e) {
			System.out.println("SQLException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	

	public String getTestCaseName() {
		return TestCaseName;
	}



	public void setTestCaseName(String testCaseName) {
		TestCaseName = testCaseName;
	}



	public String getScriptType() {
		return ScriptType;
	}



	public void setScriptType(String scriptType) {
		ScriptType = scriptType;
	}



	public String getScript() {
		return Script;
	}



	public void setScript(String script) {
		Script = script;
	}



	public String getScheduleName() {
		return ScheduleName;
	}



	public void setScheduleName(String scheduleName) {
		ScheduleName = scheduleName;
	}



	public String getTime() {
		return Time;
	}



	public void setTime(String time) {
		Time = time;
	}



	public String getDay() {
		return Day;
	}



	public void setDay(String day) {
		Day = day;
	}



	public String getEnvironment() {
		return Environment;
	}



	public void setEnvironment(String environment) {
		Environment = environment;
	}



	public String getOs() {
		return Os;
	}



	public void setOs(String os) {
		Os = os;
	}
	
}
