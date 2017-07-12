
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<style>
ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
  overflow: hidden;
  background-color: #333;
}

li {
  float: left;
}

li a {
  display: block;
  color: white;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}

li a:hover:not(.active) {
  background-color: #111;
}

.active {
  background-color: #4CAF50;
}
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

div {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 25px;
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

</head>

<title>Web Search Engine</title>

<body>
<script type="text/javascript">

function alphabatizerDivShow()
{
document.getElementById("alphabatizerDiv").style.display="";
document.getElementById("rem").style.display="none";
}


</script>
<!-- 
<c:choose>
	<c:when test="${requestScope.PageParameter == 'circularShiftPage'}">
		<ul>
			<li><a href="">Input</a></li>
			<li><a class="active" href="Search_book.jsp">Shifted Lines</a></li>
			
			
			</ul>
			
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
				${finalLists }
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
	
	
			<ul>
			<li><a class="active" href="">Input</a></li>
			
			
			
			</ul>
			
			
			
			
			<form method="post" action="Indexing" >
			<div>
			
			<input type="text" name="input_lines" placeholder="Please enter the text" required>
			<input type="hidden" value="searchForString" name="actionParameter" />
			</br>
			<input class="fsSubmitButton" type="submit" value="Generate Shifts"></div>
			</form>
	
	</c:otherwise>

</c:choose>
 -->
 
 <form method="post" action="InsertData" >
			<div>
			
			<input type="text" name="input_lines" placeholder="Please enter the text" required>
			<input type="hidden" value="searchForString" name="actionParameter" />
			</br>
			<input class="fsSubmitButton" type="submit" value="Generate Shifts"></div>
			</form>
</body>
</html>