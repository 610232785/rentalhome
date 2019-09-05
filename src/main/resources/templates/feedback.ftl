<!doctype html>
<html lang="en" class="feedback">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
    <title>问题反馈</title>
    <link rel="stylesheet" href="../../static/css/mui.min.css">
    <link rel="stylesheet" href="../../static/css/feedback.css">
</head>

<body>
<header class="mui-bar mui-bar-nav">
    <a class="mui-action-back mui-icon mui-icon-left-nav mui-pull-left"></a>
    <button id="submit" class="mui-btn mui-btn-blue mui-btn-link mui-pull-right">发送</button>
    <h1 class="mui-title">问题反馈</h1>
</header>
<div class="mui-content">
    <div class="mui-content-padded">
        <div class="mui-inline">问题和意见</div>
    </div>
    <div class="row mui-input-row">
        <textarea id='question' class="mui-input-clear question" placeholder="请详细描述你的问题和意见..." maxlength="200" ></textarea>
    </div>
    <p>手机号码</p>
    <div class="mui-input-row">
        <input id='contact' type="tel" class="mui-input-clear contact" maxlength="11" placeholder="(选填,方便我们联系你 )" />
    </div>
    <br />
</div>
<script src="../../static/js/mui.min.js"></script>
</body>

</html>