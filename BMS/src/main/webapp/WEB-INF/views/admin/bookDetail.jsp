<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table class="dv-table" border="0" style="width:100%;">
	
		<tr>
			<td class="dv-label" width="100px">图书编号:</td>
			<td width="100px">${bookInfo.bookId}</td>
			<td class="dv-label" width="100px">图书名:</td>
			<td width="100px">${bookInfo.bookName}</td>
			<td class="dv-label">图书类别:</td>
			<td>${bookInfo.bookKind}</td>
		</tr>
		<tr>
			<td class="dv-label">作者:</td>
			<td>${bookInfo.bookAuthor}</td>
			<td class="dv-label">出版社:</td>
			<td>${bookInfo.bookPubl}</td>
			<td class="dv-label">出版时间:</td>
			<td>${bookInfo.publDate}</td>
		</tr>
		<tr>
			<td class="dv-label">价格:</td>
			<td>${bookInfo.bookPrice}</td>
		</tr>	
	
	</table>
</body>
</html>