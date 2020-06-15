<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product 메인 페이지</title>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
	function deleteById(id) {
		console.log("deleteById : " + id);
		$.ajax({
			type : "POST",
			url : "/product/prod?cmd=delete",
			data : "id=" + id,
			contentType : "application/x-www-form-urlencoded; charset=utf-8",
			dataType : "text"
		})
		.done(function(result) {
			if (result == 1) {
				alert("삭제 성공");
				var trItem = $("#tr-"+id);
				trItem.remove();
			} else {
				alert("삭제 실패");
			}
		})
		.fail(function(error) {
				alert("삭제 실패");
		});
	}

	function sortByPrice() {
		
	}

</script>

</head>
<body>
	<h1>Product</h1>
	
	<div class="buttons">
		<button>처음으로</button>
		<button onclick="sortByPrice()">가격순</button>
		<button>판매순</button>
	</div>
	<div class="tables">
		<table border="1">
			<tr>
				<th>번호</th>
				<th>이름</th>
				<th>종류</th>
				<th>가격</th>
				<th>판매수</th>
			</tr>
	<c:forEach var="p" items="${products}">
			<tr id="tr-${p.id}">
				<td>${p.id}</td>
				<td>${p.name}</td>
				<td>${p.type}</td>
				<td>${p.price}</td>
				<td>${p.count}</td>
				<td><button onclick="deleteById(${p.id})">삭제</button></td>
			</tr>
	</c:forEach>
		</table>
	</div>
</body>
</html>

