<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@include file="./include/header.jsp"%>

<!-- Main content -->
<section class="content">
	<div class="row">
		<!-- left column -->
		<div class="col-md-12">
			<!-- general form elements -->

			<div class="box">
				<div class="box-header with-border">
					<h3 class="box-title">New Board</h3>
				</div>
				<div class="box-body">
		              <!-- ajax 통신을 위한 검색 기능 -->
		              <select id="searchCondition" name="searchCondition">
		              	<option value="subject">제 목</option>
		              	<option value="writer">작성자</option>
		              	<option value="content">내 용</option>
		              </select>
		              <input type="text" id="searchKeyword" name="searchKeyword"/>
		              <button id="searchBtn">Search</button>
		              <button id="newBtn">New Board</button>
				</div>
				
			</div>
			
			<div class="box">
				<div class="box-header with-border">
					<h3 class="box-title">LIST ALL PAGE</h3>
				</div>
				<div class="box-body">
				
					<table class="table table-bordered">
						<tr>
							<th style="width: 10px">BNO</th>
							<th>SUBJECT</th>
							<th>WRITER</th>
							<th>REGDATE</th>
							<th style="width: 40px">VIEWCNT</th>
						</tr>
					
						<tbody id="tbody">
						<c:forEach var="bbs" items="${boards }">
							<tr>
								<td>${bbs.seq }</td>
								<td><a href="bbs_read?seq=${bbs.seq }">${bbs.subject }</a></td>
								<td>${bbs.writer }</td>
								<td>${bbs.regdate }</td>
								<td><span class="badge bg-red">${bbs.viewcnt }</span></td>
							</tr>
						</c:forEach>
						</tbody>
					</table>

				</div>
				<!-- /.box-body -->
				<div class="box-footer">Footer</div>
				<!-- /.box-footer-->
			</div>
		</div>
		<!--/.col (left) -->

	</div>
	<!-- /.row -->
</section>
<!-- /.content -->
</div>
<!-- /.content-wrapper -->

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("#newBtn").click(function(){
			location.href="bbs_registerForm";
		});
		
		// ajax 통신 처리 버튼
		$("#searchBtn").click(function(){
			$.ajax({
				url : "bbs_search",
				type : "post",
				data : {searchCondition:$("#searchCondition").val(), searchKeyword:$("#searchKeyword").val()},
				dataType : "json",
				success : function(data){
					$("#tbody").empty();
					trs = ""
					$.each(data, function(idx, obj){
						trs += "<tr>"
						trs += "<td>"+obj.seq+"</td>"
						trs += "<td><a href='bbs_read?seq="+obj.seq+"'>"+obj.subject+"</a></td>"
						trs += "<td>"+obj.writer+"</td>"
						trs += "<td>"+obj.regdate+"</td>"
						trs += "<td><span class='badge bg-red'>"+obj.viewcnt+"</span></td>"
						trs += "</tr>"
					})
					$("#tbody").html(trs);
				}
			})
		});
	})
</script>

<%@include file="./include/footer.jsp"%>
