<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="com.baidu.ueditor.ActionEnter"
	import="java.io.File"
    pageEncoding="UTF-8"%>

<%

    request.setCharacterEncoding( "utf-8" );
	response.setHeader("Content-Type" , "text/html");
	
	String rootPath = application.getRealPath( "/" );
	//String rootPath=request.getServletPath();
	
	out.write( new ActionEnter( request, rootPath ).exec() );
	
%>