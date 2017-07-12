 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html lang="en">
<head>

<style>
.div1 {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 25px;
}
</style>

  <title>WEB SEARCH ENGINE:LOGIN</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<c:set var="context" value="${pageContext.request.contextPath}" />
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">WEB SEARCH ENGINE</a>
    </div>
    <ul class="nav navbar-nav">
   	 <li><a href="index.jsp" class="active">Insert</a></li>
      <li><a href="${context }/AutoFill">Search</a></li>
     
    </ul>
  </div>
</nav>
  
<div class="div1">
 <h1><a href="index.jsp" class="active">Insert</a></h1>
 <h1><a href="${context }/AutoFill">Search</a></h1>
</div>

</body>
</html>