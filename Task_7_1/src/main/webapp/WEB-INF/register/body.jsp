<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/7/18
  Time: 15:18
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="form">
    <ul class="tab-group">
        <li class="tab"><a href="#login">登录</a></li>
        <li class="tab active"><a href="#signup">注册</a></li>
    </ul>
    <div class="tab-content">
        <div id="signup">
            <h1>免费注册</h1>
            <form action="/ok" method="post">
                <div class="field-wrap">
                    <label>
                        昵称<span class="req">*</span>&nbsp;&nbsp;&nbsp;&nbsp;${name_error}
                    </label>
                    <input type="text" name="username" required autocomplete="off"/>
                </div>
                <div class="field-wrap">
                    <label>
                        邮箱<span class="req">*</span>&nbsp;&nbsp;&nbsp;&nbsp;${email_error}
                    </label>
                    <input type="email" name="email" required autocomplete="off"/>
                </div>
                <div class="field-wrap">
                    <label>
                        密码<span class="req">*</span>
                    </label>
                    <input type="password" name="password" required autocomplete="off"/>
                </div>
                <button type="submit" class="button button-block"/>
                注册</button>
            </form>
        </div>
        <div id="login">
            <h1>欢迎回来!</h1>
            <form action="/login" method="post">
                <div class="field-wrap">
                    <label>
                        邮箱<span class="req">*</span>
                    </label>
                    <input type="email" name="email" required autocomplete="off"/>
                </div>
                <div class="field-wrap">
                    <label>
                        密码<span class="req">*</span>
                    </label>
                    <input type="password" name="password" required autocomplete="off"/>
                </div>
                <a href="#">${failure}</a>
                <p class="forgot"><a href="#">忘记密码</a></p>
                <button class="button button-block"/>
                登录</button>
            </form>
        </div>
    </div><!-- tab-content -->
</div>
<!-- /form -->
<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

<script src="js/register.js"></script>
