<%@page import="java.util.List"%>
<%@page import="api.Exam"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>資格追加フォーム</title>

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">

    <!-- Datepicker CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/flatpickr/dist/flatpickr.min.css">

    <style>
        body {
            background-color: #eef7f1; /* 薄いグリーンの背景色 */
        }

        .container {
            margin-top: 50px;
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
        <div class="mb-3">
            <label for="qualificationSelect" class="form-label">資格名</label>
            <select class="form-select" id="qualificationSelect" name="examId">
                <option selected disabled>資格を選択してください</option>
                <%for(Exam e : exams){                %>
                <option value="<%= e.getID() %>"><%= e.getNAME() %> </option>
                <%}                %>
            </select>
        </div>
                <a href="../exam/list" class="btn btn-primary">新規資格登録</a>
        <div class="mb-3">
            <label for="datePicker" class="form-label">合格年月</label>
            <input type="text" name="examDate" class="form-control" id="datePicker" placeholder="カレンダーから選択">
        </div>
        <button type="submit" class="btn btn-primary">登録</button>
            <a href="./list" class="btn btn-danger">戻る</a>
        
    </form>
        
</div>

<!-- Bootstrap JS (Popper.js and Bootstrap JS) -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"></script>

<!-- Datepicker JS -->
<script src="https://cdn.jsdelivr.net/npm/flatpickr"></script>
<script>
    flatpickr("#datePicker", {
        dateFormat: "Y/m/d", // 日付フォーマットを設定
        locale: "ja", // 日本語に設定
    });
</script>
</body>
</html>
