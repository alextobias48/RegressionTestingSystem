package classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TestResult {
	public int TestResultID;
	public String testResultName;
	public String testResult;
	public String runTime;
	public String testDate;
	

	public TestResult(int testResultID, String testResultName,
			String testResult, String runTime, String testDate) {
		TestResultID = testResultID;
		this.testResultName = testResultName;
		this.testResult = testResult;
		this.runTime = runTime;
		this.testDate = testDate;
	}
	
	public TestResult() {
		TestResultID = 0;
		this.testResultName = "";
		this.testResult = "";
		this.runTime = "";
		this.testDate = "";
	}
	
	/*public void addTestResult(TestResult testResult) {
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
		
		String query = "INSERT INTO TestResults (TestResultName, TestResult) VALUES ( ?, ?);";
		PreparedStatement ps = null;

		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, testResult.getTestResultName());
			ps.setString(2, Double.toString(testResult.getResult()));
			
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {         
			System.out.println("SQLException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		try {
			if(ps != null && !ps.isClosed())columnIndex
				ps.close();
			if(conn != null && !conn.isClosed())
				conn.close();
		} catch (SQLException e) {    
			System.out.println("SQLException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		}	
	}*/
	
	
public ArrayList<TestResult> getTestResults(){
		
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
		String query = "SELECT * FROM TestResults";
		ArrayList<TestResult> testResult = new ArrayList<TestResult>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				String testResultId = rs.getString("TestResultID");
				String testResultName = rs.getString("TestResultName");
				String result = rs.getString("TestResult");
				String runTime = rs.getString("RunTime");
				String testDate = rs.getString("TestDate");
				if(result.contains("1")){
					result = "Pass";
				}else{
					result = "Fail";
				}
				testResult.add(new TestResult(Integer.parseInt(testResultId), testResultName, result, runTime, testDate));
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
		return testResult;	
	}

	/*public TestResult getTestResult(int testResultId ){	
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
		String query = "SELECT * FROM TestResults WHERE TestResults.TestResultsID = " + testResultId;
		PreparedStatement ps = null;
		ResultSet rs = null;
		TestResult testResult = new TestResult();
		
		try {
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				testResult.setTestResultID(Integer.parseInt(rs.getString("TestResultID")));
				testResult.setTestResultName((rs.getString("Time")));
				testResult.setResult(Double.parseDouble(rs.getString("Day")));
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
		return testResult;
	}*/
	
	
	
}
