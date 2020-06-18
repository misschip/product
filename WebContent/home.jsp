<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%

	request.setCharacterEncoding("utf-8");

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product 메인 페이지</title>
	  <!--Import Google Icon Font-->
      <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
      <!--Import materialize.css-->
      <link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>

</head>
<body>
	<h1>Product</h1>
	
	<div class="buttons">
		<button onclick="sortBy('id')" class="waves-effect waves-light btn">처음으로</button>
		<button onclick="sortBy('price')" class="waves-effect waves-light btn">가격순</button>
		<button onclick="sortBy('count')" class="waves-effect waves-light btn">판매순</button>
	</div>
	<div class="tables">
		<table class="striped">
			<thead>
				<tr>
					<th>번호</th>
					<th>이름</th>
					<th>종류</th>
					<th>가격</th>
					<th>판매수</th>
				</tr>
			</thead>
			
			<tbody>
				<c:forEach var="p" items="${products}">
					<tr id="tr-${p.id}">
						<td>${p.id}</td>
						<td>${p.name}</td>
						<td>${p.type}</td>
						<td>${p.price}</td>
						<td>${p.count}</td>
						<td><button onclick="deleteById(${p.id})" class="waves-effect waves-light btn">삭제</button></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript" src="js/materialize.min.js"></script>
<script src="js/product.js"></script>
</body>
</html>

