/**
 * 
 */

let boardService = (function() {
	let csrfToken = $("meta[name='_csrf']").attr("content");
    let csrfHeader = $("meta[name='_csrf_header']").attr("content");
    
	function boardList(callback) {
		$.ajax({
			type : "GET",
			url : "/boards/list",
			success : function(result) {
				console.log(result);
				if (callback) {
					callback(result);
				}
			},
			error : function(e) {
				console.log(e);
			}
		});
	}

	function getBoard(id) {
		$.ajax({
			type : "GET",
			url : "/boards/" + id,
			success : function(result) {
				console.log(result);
			},
			error : function(e) {
				console.log(e);
			}
		});
	}

	function deleteBoard(id){
		$.ajax({
			type:"DELETE",
			url: "/boards/" + id,
			beforeSend : function(xhr) {
                xhr.setRequestHeader(csrfHeader, csrfToken);
            },
			success: function(result){
				console.log(result);
			},
			error: function(xhr,status,e){
                console.log(xhr.responseText);
				alert("삭제에 실패했습니다.");
			}
		});
	}
	
	return {
		list : boardList,
		get : getBoard,
		del : deleteBoard,
	};
})();