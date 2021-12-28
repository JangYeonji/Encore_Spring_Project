<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="./include/header.jsp"%>

<!-- Main content -->
<section class="content">
	<div class="row">
		<!-- left column -->
		<div class="col-md-12">
			<!-- general form elements -->
			<div class="box box-primary">
				<div class="box-header">
					<h3 class="box-title">READ BOARD</h3>
				</div>
				<!-- /.box-header -->

<form role="form" method="post" action="ooo">

	<input type='hidden' name='seq' id='seq' value="${bbs.seq }">


	<div class="box-body">
		<div class="form-group">
			<label for="exampleInputEmail1">Subject</label> <input type="text"
				name='subject' class="form-control" value="${bbs.subject }"
				readonly="readonly">
		</div>
		<div class="form-group">
			<label for="exampleInputPassword1">Content</label>
			<textarea class="form-control" name="content" rows="3"
				readonly="readonly">${bbs.content }</textarea>
		</div>
		<div class="form-group">
			<label for="exampleInputEmail1">Writer</label> <input type="text"
				name="writer" class="form-control" value="${bbs.writer }"
				readonly="readonly">			
		</div>
	</div>
</form>

<!-- /.box-body -->

<div class="box-footer">
	<button type="button" class="btn btn-warning mine" id="modifyBtn">Modify</button>
	<button type="button" class="btn btn-danger mine" id="removeBtn">REMOVE</button>
	<button type="button" class="btn btn-primary" id="listallBtn">LIST ALL</button>
</div>


<script>
	$(document).ready(function(){
		$("#modifyBtn").click(function(){
			location.href="bbs_modifyForm?seq=" +$("#seq").val();
		});
		$("#removeBtn").click(function(){
			location.href="bbs_remove?seq=" +$("#seq").val();
		});
		$("#listallBtn").click(function(){
			location.href="bbs_list";
		});
		
		if(${bbs.writer!= loginUser.name}){
			$("#removeBtn").hide();
			$("#modifyBtn").hide();
		}
	});
</script>




			</div>
			<!-- /.box -->
		</div>
		<!--/.col (left) -->

	</div>
	<!-- /.row -->
</section>
<!-- /.content -->
</div>
<!-- /.content-wrapper -->

<%@include file="./include/footer.jsp"%>
