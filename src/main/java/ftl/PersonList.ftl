<html>
<head>
<title>用户列表</title>
</head>
<body>
<#include "hello.ftl">
<table border="1">
<th>学生信息</th>
<tr>
<td>序号</td>
<td>编号</td>
<td>姓名</td>
<td>电话</td>
<td>地址</td>
<td>生日</td>
</tr>
<#list personList as person>
<!-- if语法 -->
<#if person_index % 2 == 0>
<tr bgcolor="red">
<#else>
<tr bgcolor="blue">
</#if>
<!-- 循环下标 -->
<td>${person_index}</td>
<td>${person.id}</td>
<td>${person.name}</td>
<#if person.phone??>
<td>${person.phone}</td>
<#else>
<td>null</td>
</#if>
<td>${person.address}</td>
<!-- 生日（data类型数据）可以使用？进行隐式类型转换 -->
<td>${person.birthday?string("yyyy-MM-dd HH:mm:ss")}</td>
</tr>
</#list> 
</table>

</body>
</html>