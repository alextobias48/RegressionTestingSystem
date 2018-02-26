package classes;

import classes.TestSchedule;

import javax.servlet.http.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestScheduleServlet extends HttpServlet{
	private static final long serialVersionUID = 1L; 

	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		
		String  testScheduleName  = request.getParameter("testSchedName");
		String  testCaseName = request.getParameter("testCase"); 
		String  browser = request.getParameter("browseros");
		String environment = request.getParameter("environment");
		String day = request.getParameter("day");
		String time = request.getParameter("Hour");
		
		TestCase testCase = new TestCase();
		testCase = testCase.getTestCase(testCaseName);
		
		TestSchedule testSchedule = new TestSchedule(testScheduleName, testCaseName, browser, environment, day, time);
		testSchedule.addTestSchedule(testSchedule);
		testSchedule.addPendingTest(testSchedule, testCase);
		
		try {
			response.sendRedirect("TestSchedule.jsp");
		} catch (Exception e) {
			
		}

	}
}
