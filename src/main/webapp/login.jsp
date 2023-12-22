<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>資格管理システム - ログイン</title>

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">

    <style>
        body {
            background-color: #eef7f1; /* 薄いグリーンの背景色 */
        }
    </style>
</head>
<body>

<div class="container">
    <div class="row justify-content-center mt-5">
        <div class="col-md-6">
            <div class="card">
                <div class="card-header">
                    ログイン - 資格管理システム
                </div>
                <div class="card-body">
                    <form id="loginForm">
                        <div class="mb-3">
                            <label for="username" class="form-label">ユーザー名</label>
                            <input type="text" class="form-control" id="username" name="username" required>
                        </div>
                        <div class="mb-3">
                            <label for="password" class="form-label">パスワード</label>
                            <input type="password" class="form-control" id="password" name="password" required>
                        </div>
                        <button type="submit" class="btn btn-primary">ログイン</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- Bootstrap JS (Popper.js and Bootstrap JS) -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"></script>
<!-- jQuery -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/crypto-js/4.1.1/crypto-js.min.js"></script>

<script>
    // フォームが送信されたときの処理
    $('#loginForm').submit(function (event) {
        event.preventDefault(); // デフォルトの動作をキャンセル

        var username = $('#username').val(); // ユーザー名
        var password = $('#password').val(); // パスワード

        // パスワードをSHA-256でハッシュ化
        var hashedPassword = CryptoJS.SHA256(password).toString(CryptoJS.enc.Hex);

        // 送信するデータを準備
        var postData = {
            username: username,
            password: hashedPassword  // ハッシュ化されたパスワードを送信
        };

        // POSTリクエストを送信
        $.ajax({
            type: 'POST',
            url: './check', // 送信先のURLを指定
            data: postData, // 送信するデータ
            success: function (response) {
                // 成功時の処理
                console.log(response); // レスポンスをコンソールに表示
                // ここに成功時の処理を記述
            },
            error: function (error) {
                // エラー時の処理
                console.error(error); // エラーをコンソールに表示
                // ここにエラー時の処理を記述
            }
        });
    });
</script>





</html>