<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="pragma" content="no-cache">  
<meta http-equiv="cache-control" content="no-cache">  
<meta http-equiv="expires" content="0"> 
<title>${pageTitle }</title>

<link rel="stylesheet" href="${ctx}/static/bootstrap3/css/bootstrap.min.css">
<link rel="stylesheet" href="${ctx}/static/bootstrap3/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="${ctx}/static/css/blog.css">
<link href="${ctx}/favicon.ico" rel="SHORTCUT ICON">
<script src="${ctx}/static/bootstrap3/js/jquery-1.11.2.min.js"></script>
<script src="${ctx}/static/bootstrap3/js/bootstrap.min.js"></script>

<!-- 异步加载hm.js,类似<script src=""></script>这样加载的js，它的好处是异步的，不影响当前界面的渲染 -->
<script>
	var _hmt = _hmt || [];
	(function() {
	  var hm = document.createElement("script");
	  hm.src = "//hm.baidu.com/hm.js?aa5c701f4f646931bf78b6f40b234ef5";
	  var s = document.getElementsByTagName("script")[0]; 
	  s.parentNode.insertBefore(hm, s);
	})();
</script>

<style type="text/css">
	  body {
        padding-top: 10px;
        padding-bottom: 40px;
      }
</style>
</head>
<body>
<div class="container">
    <%--头--%>
	<jsp:include page="/foreview/head.jsp"/>
    <%--导航--%>
	<jsp:include page="/foreview/menu.jsp"/>
	
	<div class="row">
        <%--内容左--%>
		<div class="col-md-9">
			<jsp:include page="${mainPage}"></jsp:include>
		</div>
		<%--内容右--%>
		<div class="col-md-3">
            <%--博主信息栏--%>
			<div class="data_list">
				<div class="data_list_title">
					<a href="${ctx}/blogger/aboutMe.action" target="_blank"><img src="${ctx}/static/images/user_icon.png"/></a>
					博主信息
				</div>
				<div class="user_image">
					<a href="${ctx}/blogger/aboutMe.action" target="_blank">
						<img src="${ctx}/static/userImages/${blogger.image_name }"/>
					</a>
				</div>
				<div class="nickName">${blogger.nick_name }</div>
				<div class="userSign">(${blogger.sign })</div>
			</div>
			<%--博客类别栏--%>
			<div class="data_list">
				<div class="data_list_title">
					<img src="${ctx}/static/images/byType_icon.png"/>
					按博客类别
				</div>
				<div class="datas">
					<ul>
						<c:forEach var="blogTypeCount" items="${blogTypeCountList }">
                            <li><span><a href="${ctx}/index.action?typeId=${blogTypeCount.id }" target="_blank">${blogTypeCount.type_name }(${blogTypeCount.blogCount })</a></span></li>
                        </c:forEach>
					</ul>
				</div>
			</div>
			<%--发布日期栏--%>
			<div class="data_list">
				<div class="data_list_title">
					<img src="${ctx}/static/images/byDate_icon.png"/>
					按发布日期
				</div>
				<div class="datas">
					<ul>
						<c:forEach var="blogCount" items="${blogCountList }">
                        <li><span><a href="${ctx}/index.action?releaseDate=${blogCount.releaseDateStr }" target="_blank">${blogCount.releaseDateStr }(${blogCount.blogCount })</a></span></li>
                    </c:forEach>
					</ul>
				</div>
			</div>
			<%--友情链接栏--%>
			<div class="data_list">
				<div class="data_list_title">
					<img src="${ctx}/static/images/link_icon.png"/>
					友情链接
				</div>
				<div class="datas">
					<ul>
						<c:forEach var="link" items="${linkList }">
							<li><span><a href="${link.link_url }" target="_blank">${link.link_name }</a></span></li>
						</c:forEach>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<%--脚--%>
	<jsp:include page="/foreview/foot.jsp"/>
</div>
</body>
</html>