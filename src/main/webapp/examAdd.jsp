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
	List<Exam> exams = (List<Exam>)request.getAttribute("exams");
%>

<div class="container">
    <h2>資格追加フォーム</h2>
    <form method="post" action="./list">

    <div class="row">
        <div class="col-md-6">
            <div class="mb-3">
                <label for="qualificationCode" class="form-label">資格コード</label>
                <input type="text" class="form-control" id="qualificationCode" value="資格コードを入力">
            </div>
        </div>
        <div class="col-md-6">
            <div class="mb-3">
                <label for="qualificationName" class="form-label">資格名</label>
                <input type="text" class="form-control" id="qualificationName" value="資格名を入力">
            </div>
        </div>
    </div>
            <button type="submit" class="btn btn-primary">登録</button>
                <a href="./list" class="btn btn-danger">戻る</a>
    
        </form>
    
</div>


<!-- Bootstrap JS (Popper.js and Bootstrap JS) -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"></script>
</body>
</html>
