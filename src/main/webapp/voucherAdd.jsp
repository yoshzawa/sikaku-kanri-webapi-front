<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>バウチャー情報入力</title>

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

<div class="container">
    <h2>バウチャー情報入力</h2>
    <form>
        <div class="mb-3">
            <label for="voucherNameSelect" class="form-label">バウチャー名</label>
            <select class="form-select" id="voucherNameSelect" name="voucherName">
                <option selected disabled>バウチャーを選択してください</option>
                <option value="ITパスポート試験">ITパスポート試験</option>
                <option value="FE/SG試験">FE/SG試験</option>
                <option value="Oracle 監督あり試験">Oracle 監督あり試験</option>
                <option value="Oracle 監督なし試験">Oracle 監督なし試験</option>
            </select>
        </div>
        <div class="mb-3">
            <label for="voucherCodeInput" class="form-label">バウチャーコード</label>
            <input type="text" class="form-control" id="voucherCodeInput" name="voucherCode" maxlength="50">
        </div>
        <div class="mb-3">
            <label for="deadlinePicker" class="form-label">期限</label>
            <input type="text" class="form-control" id="deadlinePicker" name="deadline" placeholder="カレンダーから選択">
        </div>
        <button type="submit" class="btn btn-primary">登録</button>
    </form>
</div>

<!-- Bootstrap JS (Popper.js and Bootstrap JS) -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"></script>

<!-- Datepicker JS -->
<script src="https://cdn.jsdelivr.net/npm/flatpickr"></script>
<script>
    flatpickr("#deadlinePicker", {
        dateFormat: "Y年m月d日", // 日付フォーマットを設定
        locale: "ja", // 日本語に設定
    });
</script>
</body>
</html>
