
<%@ page import="java.util.*, classes.TestCase" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style type="text/css">
table.example2 {background-color:transparent;border-collapse:collapse;width:100%;}
table.example2 th, table.example2 td {text-align:center;border:1px solid black;padding:5px;}
table.example2 td {background-color:#CACAE9;}
table.example2 td:first-child {width:20%;}
</style>
<body>
<jsp:useBean id="testScripts" class="classes.TestCase" scope="session" />

<form method="post" action="ScriptUpload">
<table class="example2">
<tr>
<td><a href="./ScriptUpload.jsp">Scripts</a></td><td><a href="./TestSuite.html">Test Suites</a></td><td><a href="./TestSchedule.jsp">Test Schedule</a></td><td><a href="./TestResults.jsp">Reports</a></td>
</tr>
</table><br /><br />
<fieldset>
<legend>Upload Script</legend>
<table>
<tr>
	<td>
		<label for="scriptName">Script name: </label><input type="text" name="scriptName">
	</td>
</tr>
<tr>
	<td>
		<label for="scriptType">Script type:  </label>
	</td>
	<td>
		<select name="scriptType"> 
		<option value ="1">Sahi</option>
		</select>
	</td>
</tr>
<tr>
	<td>
		<label for="browseros">Code:  </label>
	</td>
	<td>
		<textarea rows="10" cols="100" name="script">
		</textarea>
	</td>
</tr>
<tr>
	<td>
	<input type="submit" value="Save" />
	</td>
</tr>
</table>
</fieldset>
<br />
<table>
	<tr>
		<td> Existing Scripts: </td>
		<td> 
			<select style="width: 200px; height: 200px" multiple>
			  <%for(TestCase t : testScripts.getTestCases()){ %>
			  	<option><%=t.getTestCaseName()%></option>
			  <%}%>
			</select> 
		</td>
	</tr>
</table>
</form>
</body>
</html>
