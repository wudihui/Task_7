<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/7/25
  Time: 9:00
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form name="serForm" action="/fileUpload" method="post"  enctype="multipart/form-data">
    <h1>采用流的方式上传文件</h1>
    <input type="file" name="file">
    <input type="submit" value="upload"/>
</form>

<form name="Form2" action="fileUpload2" method="post"  enctype="multipart/form-data">
    <h1>采用multipart提供的file.transfer方法上传文件</h1>
    <input type="file" name="file">
    <input type="submit" value="upload"/>
</form>

<form name="Form2" action="springUpload" method="post"  enctype="multipart/form-data">
    <h1>使用spring mvc提供的类的方法上传文件</h1>
    <input type="file" name="file">
    <input type="submit" value="upload"/>
</form>