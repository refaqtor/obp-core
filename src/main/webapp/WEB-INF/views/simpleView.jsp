<%--
  Created by Robert Jaremczak
  Date: 10/2/13
  Time: 1:01 PM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="obp" tagdir="/WEB-INF/tags/obp"%>

<html>
<head>
    <script src="<c:url value="/scripts/jquery-2.0.3.min.js"/>"></script>
    <style>
        .obpButton {
            display: table-cell;
            text-align: center;
            vertical-align: middle;
            background: white;
            height: 80px;
            width: 120px;
            border-radius: 10px;
        }

        .obpButton:hover {
            background-color: #c9e8f5;
            cursor: pointer;
        }

        table td {
            padding: 10px;
        }

        .propButton {
            font-size: 20px;
            font-weight: normal;
        }

        .propLabel {
            font-size: 20px;
            font-weight: bold;
        }

        .propValue {
            font-size: 15px;
            font-weight: normal;
        }
    </style>
</head>
<body style="background: #5f859f; font-family: sans-serif; color: black">
<table align="center" style="height: 100%; width: 280px; text-align: center">
    <tr>
        <td>
            <div class="obpButton" onclick="location.href='<c:url value="/simple/map"/>'">
                <span class="propLabel">Position</span></br>
                <span id="position" class="propValue">13E 23N</span>
            </div>
            <br>
            <div class="obpButton" onclick="location.href='<c:url value="/simple/view"/>'">
                <span class="propLabel">Depth</span></br>
                <span class="propValue">n/a</span>
            </div>
            <br>
            <div class="obpButton" onclick="location.href='<c:url value="/simple/view"/>'">
                <span class="propLabel">Heading</span></br>
                <span id="heading" class="propValue">13E 23N</span>
            </div>
            <br>
            <div class="obpButton" onclick="location.href='<c:url value="/simple/start"/>'">
                <span class="propButton">Back</span></br>
            </div>
        </td>
        <td>
            <div class="obpButton" onclick="location.href='<c:url value="/simple/view"/>'">
                <span class="propLabel">Wind</span></br>
                <span class="propValue">n/a</span>
            </div>
            <br>
            <div class="obpButton" onclick="location.href='<c:url value="/simple/view"/>'">
                <span class="propLabel">Speed</span></br>
                <span  id="speed" class="propValue">13E 23N</span>
            </div>
            <br>
            <div class="obpButton" onclick="location.href='<c:url value="/simple/view"/>'">
                <span class="propLabel">Aux</span></br>
                <span class="propValue">...</span>
            </div>
            <br>
            <div class="obpButton" onclick="location.href='<c:url value="/login"/>'">
                <span class="propButton">Home</span></br>
            </div>
        </td>
    </tr>
</table>
<script type="text/javascript">
    $(document).ready(function() {
        setInterval("ajaxd()",3000);
        ajaxd();
    });

    function ajaxd() {
        $.ajax({
            type: "GET",
            url: "<c:url value="/simple/viewDataFeed"/>",
            data: "user=success",
            success: function(data){
                $("#position,#heading,#speed").fadeOut("fast");
                $("#position").text(data.position);
                $("#heading").text(data.heading);
                $("#speed").text(data.speed);
                $("#position,#heading,#speed").fadeIn("fast");
            }
        });
    }

    function avoidNaN(num) {
        return isNaN(num) ? "n/a" : String(num);
    }
</script>
</body>
</html>