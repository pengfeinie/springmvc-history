Here you define the inherited methods to be generated inside the servlet, by default each servlet should implement doGet and doPost methods, so just keep it.

After clicking finish, eclipse automatically creates a servlet class named HelloWorldServlet.java under org.example package as the following:

| Spec versions:          | Servlet 2.5                                                  |
| ----------------------- | ------------------------------------------------------------ |
| Main page:              | [JSR154](https://www.jcp.org/en/jsr/summary?id=154)          |
| Stable:                 | Maintenance Release                                          |
| Date:                   | 11 May, 2006                                                 |
| Download Page:          | [Overview](https://jcp.org/aboutJava/communityprocess/final/jsr315/index.html) [Direct Download](https://download.oracle.com/otndocs/jcp/servlet-3.0-fr-eval-oth-JSpec/) |
| Online Javadoc:         | [Java EE 5](https://docs.oracle.com/javaee/5/api/)(2006), JDK1.6(2006) |
| Minimum Tomcat version: | 6.0.0 (2007)                                                 |

```
package org.example;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloWorldServlet extends HttpServlet {

	 @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        resp.getOutputStream().write(name.getBytes());
    }
}
```

it also writes the definition of the servlet under web.xml as the following:

```
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xmlns="http://java.sun.com/xml/ns/javaee"
         xmlns:web="http://java.sun.com/xml/ns/javaee/web-app_2_5.xsd"
         xsi:schemaLocation="http://java.sun.com/xml/ns/javaee
http://java.sun.com/xml/ns/javaee/web-app_2_5.xsd"
         id="WebApp_ID" version="2.5">

    <servlet>
        <servlet-name>HelloWorldServlet</servlet-name>
        <servlet-class>org.example.HelloWorldServlet</servlet-class>
    </servlet>
    <servlet-mapping>
        <servlet-name>HelloWorldServlet</servlet-name>
        <url-pattern>/v1/hello/world</url-pattern>
    </servlet-mapping>

</web-app>
```

Now, let's test.

![image-20210903125137871](https://pengfeinie.github.io/images/image-20210903125137871.png)