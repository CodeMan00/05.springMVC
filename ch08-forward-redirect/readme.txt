ch08-forward-redirect：转发和重定向

forward：表示转发
redirect：表示重定向

forward和rediect都是框架内的关键字，都有一个共同的特点，都不和视图解析器一共工作。

请求转发：
	request.getRequestDispatcher("xx.jsp").forward)();

重定向:
	response.sendRedirect("xx.jsp");

springmvc中把这两个操作进行了封装，现在可以使用简单的方式是实现转发和重定向。
forward：表示转发，实现request.getRequestDispatcher("xx.jsp").forward();
redirect：表示重定向，实现response.sendRedirect("xxx.jsp);


转发是在服务器内进行实现的，所以客户端只需发送一次请求即可，且可以访问WEB-INF内部的资源。而重定向的页面，而不能为WEB-INF中的页面。

重定向是发送两次请求，且服务器响应两次，用户地址栏发送变化，是资源2的地址栏。因为两次都是用户发送的请求，所以不能访问WEB-INF目录下的资源。