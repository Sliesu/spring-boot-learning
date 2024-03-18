<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Freemarker 页面</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/webjars/bootstrap/5.1.3/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.bootcdn.net/ajax/libs/font-awesome/6.4.0/css/all.css">

</head>
<body>
<div class="container">
    <table class="table table-success table-hover">
        <tr>
            <td>id</td>
            <td>作者</td>
            <td>标题</td>
        </tr>

        <#list articles as article>
            <tr>
                <td>${article.id}</td>
                <td>${article.author}</td>
                <td>${article.title}</td>
            </tr>
        </#list>
    </table>
</div>
</body>
</html>