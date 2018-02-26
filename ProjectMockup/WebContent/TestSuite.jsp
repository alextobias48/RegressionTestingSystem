<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style type="text/css">
table.example2 {background-color:transparent;border-collapse:collapse;width:100%;}
table.example2 th, table.example2 td {text-align:center;border:1px solid black;padding:5px;}
table.example2 td {background-color:AntiqueWhite;}
table.example2 td:first-child {width:20%;}
</style>
<body>
<form action="/html/tags/html_form_tag_action.cfm" method="get">
<table class="example2">
<tr>
<td><a href="./ScriptUpload.jsp">Scripts</a></td><td><a href="./TestSuite.html">Test Suites</a></td><td><a href="./TestSchedule.jsp">Test Schedule</a></td><td><a href="./TestResults.jsp">Reports</a></td>
</tr>
</table><br /><br />
<fieldset>
<legend>Group Test Suites</legend>
<table>
<tr>
<td>
<label for="suiteName">Suite Name:  </label>
</td>
<td><input type="text" name="suiteName" style="width:200px" /></td>
</tr>
<tr style="height: 250px;">
<td>Included scripts: </td>
<td>
<select style="width: 200px; height: 200px" multiple>
 <option value="0">AutoLogin</option>
 <option value="1">AssignmentRules</option>
 <option value="2">ClosingFeesSetup</option>
 <option value="3">AttachProfitLeadSrc</option>
 <option value="4">CreateProfitTable</option>
 <option value="5">CreateUser</option>
 <option value="6">CreateUser</option>
 <option value="7">CreateUser</option>
 <option value="8">CreateUser</option>
 <option value="9">CreateUser</option>
</select>
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
<td> Existing Test Suites: </td>
<td>
<select style="width: 200px; height: 100px" multiple>
 <option value="0">RegLev1</option>
 <option value="1">RegLev2</option>
 <option value="2">RegLev3</option>
 <option value="3">RegLev4</option>
 <option value="4">RegPreRelease</option>
 <option value="5">RegPostRelease</option>
</select>
</td>
</tr>
</table>
</form>
</body>
</html>