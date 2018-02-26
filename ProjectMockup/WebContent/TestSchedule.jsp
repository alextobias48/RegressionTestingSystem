<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*, classes.TestSchedule, classes.TestCase" %>
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
<jsp:useBean id="testSchedules" class="classes.TestSchedule" scope="session" />
<form method="post" action="TestSchedule">
<table class="example2">
<tr>
<td><a href="./ScriptUpload.jsp">Scripts</a></td><td><a href="./TestSuite.html">Test Suites</a></td><td><a href="./TestSchedule.jsp">Test Schedule</a></td><td><a href="./TestResults.jsp">Reports</a></td>
</tr>
</table><br /><br />
<fieldset>
<legend>Test Schedule Setup</legend>
<table>
<tr>
	<td>
		<label for="testSchedName">Test Schedule Name:  </label>
	</td>
	<td>
		<input type="text" name="testSchedName" style="width:200px" />
	</td>
</tr>
<tr>
	<td>
		<label for="testCase">Test Case:  </label>
	</td>
	<td>
		<select name="testCase" style="width: 200px; height: 200px" multiple>
			  <%for(TestCase t : testScripts.getTestCases()){ %>
			  	<option><%=t.getTestCaseName()%></option>
			  <%}%>
			</select> 
	</td>
</tr>
<tr>
	<td>
		<label for="browseros">Browser/OS:  </label>
	</td>
	<td>
		<select name="browseros">
		<option value ="Win7">IE9/Win7</option>
		<option value ="Chrome/Win7">Chrome/Win7</option>
		<option value ="IE8/XP">IE8/XP</option>
		<option value ="IE8/Win7">IE8/Win7</option>
		</select>
	</td>
</tr>
<tr>
	<td>
		<label for="environment">Environment:  </label>
	</td>
	<td>
		<select name="environment">
		<option value ="live">live</option>
		<option value ="dev1">dev1</option>
		<option value ="dev2">dev2</option>
		<option value ="dev3">dev3</option>
		</select>
	</td>
</tr>
<tr>
	<td>
		<label for="day">Weekly Schedule:  </label>
	</td>
	<td>
		<select name="day">
		<option value ="1">Sunday</option>
		<option value ="2">Monday</option>
		<option value ="3">Tuesday</option>
		<option value ="4">Wednesday</option>
		<option value ="5">Thursday</option>
		<option value ="6">Friday</option>
		<option value ="7">Saturday</option>
		</select>
	</td>
</tr>
<tr>
	<td>
		<label for="hourmin">Time of day:  </label>
	</td>
	<td>
		<table>
		<tr>
			<td>Hour:Min</td>
			<td>AM/PM</td>
		</tr>
		<tr>
			<td>
			<select name="Hour">
				<option value ="1">1</option>
				<option value ="2">2</option>
				<option value ="3">3</option>
				<option value ="4">4</option>
				<option value ="5">5</option>
				<option value ="6">6</option>
				<option value ="7">7</option>
				<option value ="8">8</option>
				<option value ="9">9</option>
				<option value ="10">10</option>
				<option value ="11">11</option>
				<option value ="12">12</option>
				<option value ="13">13</option>
				<option value ="14">14</option>
				<option value ="15">15</option>
				<option value ="16">16</option>
				<option value ="17">17</option>
				<option value ="18">18</option>
				<option value ="19">19</option>
				<option value ="20">20</option>
				<option value ="21">21</option>
				<option value ="22">22</option>
				<option value ="23">23</option>
				<option value ="24">24</option>
			</select>
		</td>
		</tr>
		</table>
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
	<td> Existing Test Schedules: </td>
	<td> 
		<select style="width: 200px" multiple>
		  <%for(TestSchedule t : testSchedules.getTestSchedules()){ %>
			  	<option><%=t.getTestScheduleName()%></option>
			  <%}%>
		</select> 
	</td>
</tr>
</table>
</form>
</body>
</html>

