package classes;

import javax.servlet.http.*;

import classes.TestCase;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestCaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		
		String  testCaseName  = request.getParameter("scriptName");
		String  scriptType = "Sahi"; 
		String  script = request.getParameter("script");
		
		TestCase testCase = new TestCase(testCaseName, scriptType, script);
		testCase.addTestCase(testCase);
		
		try {
			response.sendRedirect("ScriptUpload.jsp");
		} catch (Exception e) {
			
		}

	}
}
