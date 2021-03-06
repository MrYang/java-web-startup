<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<meta name="menu" content="user" />
<meta name="subMenu" content="user" />

<div class="am-cf am-padding">
  <div class="am-fl am-cf"><a href="${ctx}/user/"> <strong class="am-text-primary am-text-lg">用户</strong></a> /
    <small>修改用户角色</small>
  </div>
</div>

<hr/>

<div class="am-g">
  <div class="am-u-sm-12 am-u-md-8">
    <form class="am-form am-form-horizontal" action="${ctx}/user/update/${user.id}/role" method="post">
      <div class="am-form-group">
        <label class="am-u-sm-3 am-form-label">角色</label>

        <div class="am-u-sm-9">

          <c:forEach items="${roles}" var="role">
            <label class="am-checkbox-inline">
              <input type="checkbox" name="roleIds" value="${role.id}" <c:if test="${role.checked}">checked</c:if> >${role.name}
            </label>
          </c:forEach>
        </div>
      </div>

      <div class="am-form-group">
        <div class="am-u-sm-9 am-u-sm-push-3">
          <button type="submit" class="am-btn am-btn-primary">保存</button>
        </div>
      </div>
    </form>
  </div>
</div>
