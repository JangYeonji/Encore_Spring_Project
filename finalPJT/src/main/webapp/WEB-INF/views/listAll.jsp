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
					
					
						<c:forEach var="bbs" items="${boards }">
							<tr>
								<td>${bbs.seq }</td>
								<td><a href="bbs_read?seq=${bbs.seq }">${bbs.subject }</a></td>
								<td>${bbs.writer }</td>
								<td>${bbs.regdate }</td>
								<td><span class="badge bg-red">${bbs.viewcnt }</span></td>
							</tr>
						</c:forEach>
					
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

<script>
	$(document).ready(function(){
		$("#newBtn").click(function(){
			location.href="bbs_registerForm";
		});
	})
</script>

<%@include file="./include/footer.jsp"%>