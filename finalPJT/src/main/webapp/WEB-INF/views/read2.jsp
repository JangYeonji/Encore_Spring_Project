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

<div class="row">
		<div class="col-md-12">
			<div class="box box-success">
				<div class="box-header">
					<h3 class="box-title">ADD NEW REPLY</h3>
				</div>
				<div class="box-body">
					<label for="exampleInputEmail1">Writer</label>
					<input class="form-control" type="text" placeholder="USER ID"    id="newReplyWriter" value="${loginUser.name }" readonly>
					<label for="exampleInputEmail1">Reply Text</label>
					<input class="form-control" type="text" placeholder="REPLY TEXT" id="newReplyText">
				</div>
				<!-- /.box-body -->
				<div class="box-footer">
					<button type="button" class="btn btn-primary" id="replyAddBtn">ADD REPLY</button>
				</div>
			</div>
		
		<!-- The time line -->
		<ul class="timeline">
		  	<!-- timeline time label -->
			<li class="time-label" id="repliesDiv">
			  <span class="bg-green">
			    Replies List <small id='replycntSmall'> [ 000 ] </small>
			  </span>
			</li>
		</ul>
		<!--  -->
		<ul id="rlist">
				<c:forEach items="${bbs.rlist}" var="reply">
					
					<li class="time-label">${reply.rcontent }&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<c:if test="${reply.rwriter == loginUser.name}">
							<a href="javascript:removeReply(${reply.rseq },${reply.seq })">X</a>
						</c:if>
					</li>
				</c:forEach>
		</ul>
		<!--  -->
			<div class='text-center'>
				<ul id="pagination" class="pagination pagination-sm no-margin ">
				</ul>
			</div>
		</div>
		<!-- /.col -->
	</div>
	<!-- /.row -->


<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
	function removeReply(rseq,seq){
		$.ajax({
			url : "bbs_removeReply",
			type : "post",
			data : {rseq:rseq, seq:seq},
			dataType : "json",
			success : function(data){
				$("#rlist").empty();
				rl = ""
				$.each(data, function(idx, reply){
					rl += "<li class='time-label'>" + reply.rcontent + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
					if (reply.rwriter == "${loginUser.name}"){
						rl += "<a href='javascript:removeReply("+reply.rseq, reply.seq+")'>X</a>"
					}
					rl += "</li>"
				})
				$("#rlist").html(rl);
			}
		});
	}
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
		
		$("#replyAddBtn").click(function(){
			var loginUser = $("#newReplyWriter").val();
			$.ajax({
				url : "bbs_addReply",
				type : "post",
				data : {seq:$("#seq").val(), 
					rwriter:$("#newReplyWriter").val(),
					rcontent:$("#newReplyText").val()
				},
				dataType : "json",
				success : function(data){
					$("#rlist").empty();
					rl = ""
					$.each(data, function(idx, reply){
						rl += "<li class='time-label'>" + reply.rcontent + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
						if (reply.rwriter == "${loginUser.name}"){
							rl += "<a href='javascript:removeReply("+reply.rseq,reply.seq+")'>X</a>"
						}
						rl += "</li>"
					})
					$("#rlist").html(rl);
				}
			})
		});
	})
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
