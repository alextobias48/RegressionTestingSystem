package classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TestSchedule {
	public String testScheduleName;
	public String testCaseName;
	public String browserOS;
	public String environment; 
	public String selectedDay;
	public String timeOfDay;
	
	public TestSchedule(String testScheduleName, String testCaseName, String browserOS,
			String environment, String selectedDay, String timeOfDay) {
		this.testScheduleName = testScheduleName;
		this.browserOS = browserOS;
		this.environment = environment;
		this.selectedDay = selectedDay;
		this.timeOfDay = timeOfDay;
	}
	
	public TestSchedule() {
		this.testScheduleName = "";
		this.browserOS = "";
		this.environment = "";
		this.selectedDay = "";
		this.timeOfDay = "";
	}
	
	public String getTestScheduleName() {
		return testScheduleName;
	}
	public void setTestScheduleName(String testScheduleName) {
		this.testScheduleName = testScheduleName;
	}
	public String getBrowserOS() {
		return browserOS;
	}
	public void setBrowserOS(String browserOS) {
		this.browserOS = browserOS;
	}
	public String getEnvironment() {
		return environment;
	}
	public void setEnvironment(String environment) {
		this.environment = environment;
	}
	public String getSelectedDay() {
		return selectedDay;
	}
	public void setSelectedDay(String selectedDay) {
		this.selectedDay = selectedDay;
	}
	public String getTimeOfDay() {
		return timeOfDay;
	}
	public void setTimeOfDay(String timeOfDay) {
		this.timeOfDay = timeOfDay;
	}
	
	public void addPendingTest(TestSchedule testSchedule, TestCase testCase){
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
		
		String query = "INSERT INTO PendingTests (TestCaseName, ScriptType, Script, ScheduleName, Time, Day, Environment, Os) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?);";
		PreparedStatement ps = null;

		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, testCase.getTestCaseName());
			ps.setString(2, testCase.getScriptType());
			ps.setString(3, testCase.getScript());
			ps.setString(4, testSchedule.getTestScheduleName());
			ps.setString(5, testSchedule.getTimeOfDay());
			ps.setString(6, testSchedule.getSelectedDay());
			ps.setString(7, testSchedule.getEnvironment());
			ps.setString(8, testSchedule.getBrowserOS());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			System.out.println("SQLException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		try {
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
	
	public void addTestSchedule(TestSchedule testSchedule) {
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
		
		String query = "INSERT INTO TestSchedules (ScheduleName, Time, Day, Environment, Os) VALUES ( ?, ?, ?, ?, ?);";
		PreparedStatement ps = null;

		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, testSchedule.getTestScheduleName());
			ps.setString(2, testSchedule.getTimeOfDay());
			ps.setString(3, testSchedule.getSelectedDay());
			ps.setString(4, testSchedule.getEnvironment());
			ps.setString(5, testSchedule.getBrowserOS());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			System.out.println("SQLException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		try {
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
	
	
public ArrayList<TestSchedule> getTestSchedules(){
		
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
		String query = "SELECT * FROM TestSchedules";
		ArrayList<TestSchedule> testSchedule = new ArrayList<TestSchedule>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				String testScheduleName = rs.getString("ScheduleName");
				String testCaseName = rs.getString("TestCaseName");
				String browserOS = rs.getString("Os");
				String environment = rs.getString("Environment"); 
				String selectedDay = rs.getString("Day");
				String timeOfDay = rs.getString("Time");
				testSchedule.add(new TestSchedule(testScheduleName, testCaseName, browserOS, environment, selectedDay, timeOfDay));
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
		return testSchedule;	
	}

	public TestSchedule getTestSchedule(int testScheduleId ){	
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
		String query = "SELECT * FROM TestSchedules WHERE TestSchedules.TestScheduleID = " + testScheduleId;
		PreparedStatement ps = null;
		ResultSet rs = null;
		TestSchedule testSchedule = new TestSchedule();
		
		try {
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				testSchedule.setTestScheduleName(rs.getString("ScheduleName"));
				testSchedule.setTimeOfDay(rs.getString("Time"));
				testSchedule.setSelectedDay(rs.getString("Day"));
				testSchedule.setEnvironment(rs.getString("Environment"));
				testSchedule.setBrowserOS(rs.getString("Os"));
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
		return testSchedule;
	}
	
}
