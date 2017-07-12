 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>WEB SEARCH ENGINE:INSERT</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  
  <style>



.fsSubmitButton
{
padding: 10px 15px 11px !important;
font-size: 18px !important;
background-color: #57d6c7;
font-weight: bold;
text-shadow: 1px 1px #57D6C7;
color: #ffffff;
margin: 10px 300px 10px 620px;
border-radius: 5px;
-moz-border-radius: 5px;
-webkit-border-radius: 5px;
border: 1px solid #57D6C7;
cursor: pointer;
box-shadow: 0 1px 0 rgba(255, 255, 255, 0.5) inset;
-moz-box-shadow: 0 1px 0 rgba(255, 255, 255, 0.5) inset;
-webkit-box-shadow: 0 1px 0 rgba(255, 255, 255, 0.5) inset;

}

.fsSubButton
{
padding: 10px 15px 11px !important;
font-size: 18px !important;
background-color: #57d6c7;
font-weight: bold;
text-shadow: 1px 1px #57D6C7;
color: #ffffff;

border-radius: 5px;
-moz-border-radius: 5px;
-webkit-border-radius: 5px;
border: 1px solid #57D6C7;
cursor: pointer;
box-shadow: 0 1px 0 rgba(255, 255, 255, 0.5) inset;
-moz-box-shadow: 0 1px 0 rgba(255, 255, 255, 0.5) inset;
-webkit-box-shadow: 0 1px 0 rgba(255, 255, 255, 0.5) inset;

}

.cj {
  text-align: justify;
  margin: 0 auto;
  width: 30em;
}


input[type=text]{
  width: 30%;
  padding: 12px 20px;
  margin: 10px 300px 10px 500px;
  display: inline-block;
  border: 1px solid #ccc;
  
  border-radius: 4px;
  box-sizing: border-box;
}

</style>
<script type="text/javascript">

function alphabatizerDivShow()
{
document.getElementById("alphabatizerDiv").style.display="";
document.getElementById("rem").style.display="none";
}


</script>  
</head>
<body>

<c:set var="context" value="${pageContext.request.contextPath}" />

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">WEB SEARCH ENGINE</a>
    </div>
    <ul class="nav navbar-nav">
      <li><a href="newlogin.jsp" class="active">Home</a></li>
      <li><a href="${context }/AutoFill">Search</a></li>
     
    </ul>
  </div>
</nav>
  



<c:choose>
	<c:when test="${requestScope.PageParameter == 'circularShiftPage'}">
		
			
			<form method="post" action="Indexing" >
			<div>
			
			<!-- <input type="text" name="input_lines" placeholder="Please enter the text" required> -->
			<input type="hidden" value="searchForString" name="actionParameter" />
			
			<center>
			<h2>Circularly Shifted Lines</h2> 
			
			<c:forEach items="${requestScope.circulatList}" var="finalLists" varStatus="loop">
			<h3>Line ${loop.index +1}</h3>
			<c:forEach items="${finalLists}" var="ItemLists" varStatus="loop1">
			
			Shift ${loop1.index +1} :
			${ItemLists }
			<br/>
			</c:forEach>
			
			<br/>
			</c:forEach>
			</center>
			
			
			<div id="alphabatizerDiv" style="display:none"  >
			<center>
			<br/>
			<p>
			<h2>Final List with Noise Elimination and Sorting</h2>
			</center>
				<c:forEach items="${requestScope.finalLists}" var="finalLists" varStatus="loop">
				<br/>
				${loop.index +1}. 
				${finalLists.id },${finalLists.dataLines },${finalLists.refMainEntry }
				</c:forEach>
				
				</div>
				
			
				
			
			
			<div id="rem">
			<center>
			<p><input class="fsSubButton" type="button" value="Alphabetize" onclick="alphabatizerDivShow()" ></p></center></div>
			
			</form>
			
			
	</c:when>
	<c:when test="${requestScope.PageParameter == 'finalOutPutPage'}">
	
	</c:when>
	<c:otherwise>
	
	
			
			
			
			
			<form method="post" action="Index" >
			<div>
			
			<input type="text" name="URL" placeholder="Please enter the URL" required>
			<input type="text" name="Discription" placeholder="Please enter the description" required>
			<input type="text" name="Noise" placeholder="Enter Noise Words">
			<input type="hidden" value="searchForString" name="actionParameter" />
			</br>
			<input class="fsSubmitButton" type="submit" value="Generate Shifts"></div>
			</form>
	
	</c:otherwise>

</c:choose>



</body>
</html>




