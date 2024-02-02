<%@page import="java.util.List"%>
<%@page import="api.VoucherType"%>
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

        .page-selector {
            width: 30%;
            float: left;
            padding: 20px;
        }

        .data-table {
            width: 70%;
            float: left;
        }

        .data-table table {
            width: 100%;
        }

        .data-table th, .data-table td {
            text-align: left;
            padding: 8px;
        }

        .btn-container {
            margin-top: 20px;
        }
    </style>
</head>
<body>
<%
	List<VoucherType> vouchers = (List<VoucherType>)request.getAttribute("vouchers");
%>
<div class="container">
    <div class="page-selector">
        <h2>資格管理システム</h2>
        <ul>
            <li><a href="../sikaku/list">合格資格一覧</a></li>
            <li><a href="../voucher/list"><strong>バウチャー一覧</strong></a></li>
        </ul>
    </div>

    <div class="data-table">
        <h2>バウチャー一覧</h2>
        <table class="table">
            <thead>
                <tr>
                    <th>番号</th>
                    <th>バウチャー名</th>
                </tr>
            </thead>
            <tbody>
            <% for(VoucherType vt : vouchers) {%>
                <tr>
                    <td><%= vt.getID() %></td>
                    <td><%= vt.getNAME() %></td>
                </tr>
                <% } %>

            </tbody>
        </table>
        <div class="btn-container">
            <a href="./voucherAdd.html" class="btn btn-primary">新規バウチャー登録</a>
        </div>
    </div>
</div>

<!-- Bootstrap JS (Popper.js and Bootstrap JS) -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"></script>
</body>
</html>

