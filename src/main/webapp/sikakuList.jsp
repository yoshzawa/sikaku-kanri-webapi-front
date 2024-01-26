<%@page import="api.Sikaku"%>
<%@page import="java.util.List"%>
<%@page import="api.Exam"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>資格管理システム</title>

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">

    <style>
        body {
            background-color: #eef7f1; /* 薄いグリーンの背景色 */
        }

        .container {
            display: flex;
        }

        .page-selector {
            width: 30%;
            padding: 20px;
        }

        .data-table {
            width: 70%;
        }

        .data-table table {
            width: 100%;
        }

        .data-table th, .data-table td {
            text-align: left;
            padding: 8px;
        }
    </style>
</head>

<body>
<%
	List<Sikaku> sikakus = (List<Sikaku>)request.getAttribute("sikakus");
%>

<div class="container">
    <div class="page-selector">
        <h2>資格管理システム</h2>
        <ul>
            <li><a href="sikakuList.jsp"><strong>合格資格一覧</strong></a></li>
            <li><a href="./voucherView.html">バウチャー一覧</a></li>
        </ul>
        <a href="./sikakuAdd.html" class="btn btn-primary">新規資格登録</a>
    </div>

    <div class="data-table">
        <h2>データ一覧</h2>
        <table class="table">
            <thead>
                <tr>
                    <th>番号</th>
                    <th>資格名</th>
                    <th>合格年月</th>
                </tr>
            </thead>
            <tbody>
            <% for( Sikaku e:sikakus){
            %>
                <tr>
                    <td><%= e.getID() %></td>
                    <td><%= e.getNAME() %></td>
                    <td><%= e.getDATE() %></td>
                </tr>
            <% }
            %>
            </tbody>
        </table>
        <a href="./add" class="btn btn-primary">新規資格登録</a>
    </div>
</div>

<!-- Bootstrap JS (Popper.js and Bootstrap JS) -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"></script>
</body>
</html>
