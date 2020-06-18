
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


	function sortBy(byWhat) {
		var urlStr;
		if (byWhat == 'id') {
			urlStr = "/product/prod?cmd=sortProc&by=id";
		} else if (byWhat == 'price') {
			urlStr = "/product/prod?cmd=sortProc&by=price";
		} else if (byWhat == 'count') {
			urlStr = "/product/prod?cmd=sortProc&by=count";
		}
		
		
		$.ajax({
			type : "GET",
			url : urlStr,
			contentType : "application/x-www-form-urlencoded; charset=utf-8", // "application/json",
			dataType : "json"
		})
		.done(function(result) {
			var tbodyItem = $("tbody");
			tbodyItem.empty();
			

			for (var p of result) {
				let trItem = `<tr id=tr-${p.id}>`;
				trItem += "<td>" + p.id + "</td>";
				trItem += "<td>" + p.name + "</td>";
				trItem += "<td>" + p.type + "</td>";
				trItem += "<td>" + p.price + "</td>";
				trItem += "<td>" + p.count + "</td>";
				trItem += `<td><button onclick="deleteById(${p.id})" class="waves-effect waves-light btn">삭제</button></td>`;
				trItem += "</tr>";

				tbodyItem.append(trItem);
				
				trItem = "";
				
			}
			// console.log("sortBy : tableItem : ", tableItem);
		})
		.fail(function(error) {
			console.log(error);
		});
	}