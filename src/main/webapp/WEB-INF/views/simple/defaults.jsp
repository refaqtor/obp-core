<%--
  Created by Robert Jaremczak
  Date: 2013-10-27
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="obp" tagdir="/WEB-INF/tags/obp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no"/>
    <link rel="stylesheet" href="<c:url value="/styles/obp.css"/>"/>
    <script src="<c:url value="/scripts/jquery-2.1.1.min.js"/>"></script>
    <script src="<c:url value="/scripts/layout.js"/>"></script>
</head>
<body>
<obp:header headline="Defaults" btnHome="false"/>
<div class="shortButton" onclick="location.href='<c:url value="/simple/more"/>'">back</div>
<div>
    <c:forEach items="${readouts}" var="entry">
        <form>
            <input style="width: 35%" class="inputLabel" type="text" name="name" value="${entry.key}" readonly="readonly"/>
            <input style="width: 35%; margin-right: 5%" class="inputField" type="text" name="value" value="${entry.value}"/>
            <input class="shortButton" type="button" value="update" onclick="doUpdate(this.form)"/>
        </form>
    </c:forEach>
</div>
<script type="text/javascript">
    function doUpdate(formObj) {
        var elements = formObj.elements;
        $.ajax({
            type: "GET",
            url: "<c:url value="/secure/defaults/update"/>",
            data: "name="+elements.namedItem("name").value+"&value="+elements.namedItem("value").value,
            success: function(data){
                location.reload();
            },
            error: function() {
                alert("update failed");
            }
        });
    }
</script>
</body>
</html>