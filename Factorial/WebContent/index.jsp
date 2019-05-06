<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.ArrayList,model.History" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Factorial Calculator</title>
<link href="<c:url value="/inc/bootstrap/css/bootstrap.css"/>" rel="stylesheet"/>
<link href="<c:url value="/inc/style.css"/>" rel="stylesheet"/>
</head>
<body>

<form method="post" action="<c:url value="/controller/FactorialCalculator"/>">

<label for="n">Value of n:</label>
<input type="number" name="n"/>

<input type="submit" value="Calculate"/>
</form>


<br/>
<br/>

<% ArrayList<History> list = (ArrayList<History>)session.getAttribute("historique"); %>

<% 

if(list!=null){
	 
	 out.println(list.get(list.size()-1).getValue_of_n()+"! = "+list.get(list.size()-1).getResultfactorial());
	 
}

%>

<br/>
<br/>

History



<br/>
<br/>

<table>

    <tr>
         <th>Date</th>
         <th>n</th>
         <th>n!</th>
    
    </tr>
    
    <%
         if(list==null){
        	 
        	 out.println("Liste vide");
        	 
         }
         else{
        	 
        	 out.println(list.size());
        	 
        	 
        	 %>
        	 
        	 
        	 <br/>
<br/>
        	 
        	 
        	 
        	    <%
         for(int i=0;i<list.size();i++){
        	 
     
        	 %>   	 
      
      
      
      
      
 <tr>
      <td> <% out.println(list.get(i).getDate().toString()); %>  </td>
      <td> <% out.println(list.get(i).getValue_of_n()); %> </td>
      <td> <% out.println(list.get(i).getResultfactorial()); %>  </td>
      
      
      
      
</tr>
         
    
    <%
    
    
    
    }
    
    %>
    
    <% //list.clear(); %>
    
        	 
        	 <% 
        	 
         }
    
    
    
    %>
    
    
    
    


</table>


</body>
</html>