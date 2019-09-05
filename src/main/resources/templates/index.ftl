<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
    <link href="../../../css/mui.min.css" rel="stylesheet" />
    <link rel="stylesheet" type="text/css" href="list-to-detail.css" />
</head>

<body>

<div class="mui-content">
    <!--顶部banner图 开始-->
    <div id="kr-article-banner" class="kr-article-banner">
        <div id="kr-article-cover" class="kr-article-cover">
            <img :src="cover">
        </div>
        <h2 id="kr-article-title" class="kr-article-title">{{title}}</h2>
    </div>
    <!--顶部banner图 结束-->

    <div class="kr-article-content">
        <!-- 文章作者、发布时间等信息 -->
        <div class="kr-article-meta">
            <div id="kr-article-author" class="kr-article-author">{{author}}</div>
            <div class="kr-article-text">发表于</div>
            <div id="kr-article-time" class="kr-article-time">{{time}}</div>
        </div>
        <!--文章详细内容-->
        <div id="kr-article-article" class="kr-article-article" v-html="content"></div>
    </div>
</div>

<script src="../../../js/mui.min.js"></script>
<script src="vue.min.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">
    mui.init();

    function getDefaultData() {
        return {
            cover: '',
            title: '',
            author: '',
            time: '',
            content: ''
        }
    }

    var vm = new Vue({
        el: '.mui-content',
        data: getDefaultData(),
        methods: {
            resetData: function() {//重置数据
                Object.assign(this.$data, getDefaultData());
            }
        }
    });

    //监听自定义事件，获取新闻详情
    document.addEventListener('get_detail', function(event) {
        var guid = event.detail.guid;
        if(!guid) {
            return;
        }

        //前页传入的数据，直接渲染，无需等待ajax请求详情后
        vm.cover = event.detail.cover;
        vm.title = event.detail.title;
        vm.author = event.detail.author;
        vm.time = event.detail.time;
        //向服务端请求文章详情内容
        mui.ajax('http://spider.dcloud.net.cn/api/news/36kr/' + guid, {
            type:'GET',
            dataType: 'json', //服务器返回json格式数据
            timeout: 15000, //15秒超时
            success: function(rsp) {
                vm.content = rsp.content;
            },
            error: function(xhr, type, errorThrown) {
                mui.toast('获取文章内容失败');
                //TODO 此处可以向服务端告警
            }
        });
    });

    //重写返回逻辑
    mui.back = function() {
        plus.webview.currentWebview().hide("auto", 300);
    }

    //窗口隐藏时，重置页面数据
    mui.plusReady(function () {
        var self = plus.webview.currentWebview();
        self.addEventListener("hide",function (e) {
            window.scrollTo(0, 0);
            vm.resetData();
        },false);
    })

</script>
</body>

</html>