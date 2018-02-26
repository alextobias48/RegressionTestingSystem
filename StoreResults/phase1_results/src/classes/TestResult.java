package classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TestResult {
	public String TestResultName;
	public int Result;
	public double RunTime;
	public String TestDate;

	 
	public TestResult(String testResultName, int result, double runTime,
			String testDate) {
		super();
		TestResultName = testResultName;
		Result = result;
		RunTime = runTime;
		TestDate = testDate;
	}
	public double getRunTime() {
		return RunTime;
	}
	public void setRunTime(double runTime) {
		RunTime = runTime;
	}
	public String getTestDate() {
		return TestDate;
	}
	public void setTestDate(String testDate) {
		TestDate = testDate;
	}

	public String getTestResultName() {
		return TestResultName;
	}

	public void setTestResultName(String testResultName) {
		TestResultName = testResultName;
	}

	public int getResult() {
		return Result;
	}

	public void setResult(int result) {
		Result = result;
	}
	
	public static void addTestResult(TestResult testResult) {
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
		
		String query = "INSERT INTO TestResults (TestResultName, TestResult, RunTime, TestDate) VALUES ( ?, ?, ?, ?);";
		PreparedStatement ps = null;

		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, testResult.getTestResultName());
			ps.setInt(2, testResult.getResult());
			ps.setDouble(3, testResult.getRunTime());
			ps.setString(4, testResult.getTestDate());
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
	
}
