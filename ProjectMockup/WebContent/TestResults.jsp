<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*, classes.TestResult" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<style type="text/css">
table.example2 {background-color:transparent;border-collapse:collapse;width:100%;}
table.example2 th, table.example2 td {text-align:center;border:1px solid black;padding:5px;}
table.example2 td {background-color:#CACAE9;}
table.example2 td:first-child {width:20%;}
	title{
		font-family: arial, Sans-Serif;
		font-size: x-large;
	}
	tabrow{
		background-color: #B0C4DE; 
	}
	button{
		font-family: Arial, Helvetica, sans-serif;
		font-size: 14px;
		padding: 5px 20px;
		border: none;
		cursor: pointer;		
		
	}
	button:hover{
		background: -webkit-linear-gradient(top, #acc7a3, #506651);
		background: -moz-linear-gradient(top, #acc7a3, #506651);
		background: linear-gradient(top, #acc7a3, #506651);
	}
	button:active{
		background: -webkit-linear-gradient(top, #858565, #c5c9a9);
		background: -moz-linear-gradient(top, #858565, #c5c9a9);
		background: linear-gradient(top, #858565, #c5c9a9);
	}
	tr:nth-child(even) {
		background-color: #D3D3D3;
	}
	th{
	
	}
	td{

	}
	tr{
	
	}

</style>

  <title>Regression Mock-Up Page</title>
  <head>
	<h1 class="title"> Regression Test Results </h1></br>
    <script type="text/javascript">

      function activateTab(pageId) {
          var tabCtrl = document.getElementById('tabCtrl');
          var pageToActivate = document.getElementById(pageId);
          for (var i = 0; i < tabCtrl.childNodes.length; i++) {
              var node = tabCtrl.childNodes[i];
              if (node.nodeType == 1) { /* Element */
                  node.style.display = (node == pageToActivate) ? 'block' : 'none';
              }
          }
      }

    </script>
  </head>
  <body>
  <jsp:useBean id="testResults" class="classes.TestResult" scope="session" />
  <form action="/html/tags/html_form_tag_action.cfm" method="get">
  <table class="example2">
  <tr>
<td><a href="./ScriptUpload.jsp">Scripts</a></td><td><a href="./TestSuite.html">Test Suites</a></td><td><a href="./TestSchedule.jsp">Test Schedule</a></td><td><a href="./TestResults.jsp">Reports</a></td>
  </tr>
  </table><br /><br />
    <div id="tabCtrl">
      <div id="page1" style="display: block;">
        <table border="1">
          <tr>
            <td>'Test Case Name'</td>
            <td>Pass/Fail </td>
            <td>Run time </td>   
            <td>Date</td>  
          </tr>
          <%for(TestResult t : testResults.getTestResults()){ %>
			  	<tr>
			  	<td><%=t.testResultName %></td>
			  	<td><%=t.testResult %></td>
			  	<td><%=t.runTime %></td>
			  	<td><%=t.testDate %></td>
			  	</tr>
			  <%}%>
    </div>
  </body>
</html>