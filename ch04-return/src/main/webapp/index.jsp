<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://s3.pstatp.com/cdn/expire-1-M/jquery/3.3.1/jquery.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $("button").click(function () {
                //alert("button click");
                $.ajax({
                    // url:"returnVoid-ajax.do",
                    //url:"returnStudentJson.do",
                    // url:"returnStudenstJsonArray.do",
                    url:"returnStringData.do",
                    data:{
                        name:"zhangsan",
                        age:20
                    },
                    type:"post",
                    //dataType:"json",//这是告诉浏览器，返回的数据是json格式。
                    success:function (resp) {
                        // alert(resp.name +"    "+resp.age);
                        // $.each(resp,function (i,n) { //jquery循环
                        //     alert(n.name+"  "+n.age)
                        // })
                        alert(resp)
                    }
                })
            })
        })
    </script>
</head>
<body>
    <p>处理器方法返回String，表示视图名称</p>
    <form action="returnString-view.do" method="post">
        姓名：<input type="text" name ="name">
        <br/>
        年龄：<input type="text" name = "age">
        <br/>
        <input type="submit" value="提交参数">
    </form>
    <br/>
    <br/>
    <button id="btn">发起ajax请求</button>
</body>
</html>
