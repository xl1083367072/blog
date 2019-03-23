<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="row">
	<div class="col-md-4">
		<a href="${pageContext.request.contextPath }/index.action"><img alt="个人博客系统" title="个人博客系统" src="${pageContext.request.contextPath}/static/images/logo.jpg"></a>
	</div>
	<!-- 天气预报接口 -->
	<div class="col-md-8">
		<iframe style="float: right;" width="420" scrolling="no" height="60" frameborder="0" allowtransparency="true" src="http://i.tianqi.com/index.php?c=code&id=12&icon=1&num=5"></iframe>
	</div>
</div>