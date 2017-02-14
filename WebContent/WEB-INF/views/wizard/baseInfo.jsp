<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>步骤1：基本信息</title>
</head>
<body>
	<p>
	向导中的页码从0开始；<br/>
	PARAM_TARGET = "_target"：<br/>
	用于选择向导中的要使用的页面参数名前缀，如“_target0”则选择第0个页面显示，即图中的“wizard/baseInfo”，以此类推，如“_target1”将选择第1页面，要得到的页码为去除前缀“_target”后的数字即是；<br/>
	PARAM_FINISH = "_finish"：<br/>
	如果请求参数中有名为“_finish”的参数，表示向导成功结束，将会调用processFinish方法进行完成时的功能处理；<br/>
	PARAM_CANCEL = "_cancel"：<br/>
	如果请求参数中有名为“_cancel”的参数，表示向导被取消，将会调用processCancel方法进行取消时的功能处理；
	</p>
	<form method="post">
		真实姓名:
		<input type="text" name="realname" value="${user.realname}"><br/>
		<input type="submit" name="_target1" value="下一步" />
	</form>
</body>
</html>
