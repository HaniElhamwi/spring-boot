package com.example.firstwebapplication;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class SayHelloController {
    @RequestMapping("/hello")
    @ResponseBody
    public String sayHello() {
        return "Hello World Developer!!!";
    }

    @RequestMapping("/hello-html")
    @ResponseBody
    public String sayHelloHtml() {
        StringBuffer htmlBuffer = new StringBuffer();
        // Append HTML content to the StringBuffer
        htmlBuffer.append("<html>\n");
        htmlBuffer.append("<head>\n");
        htmlBuffer.append("<title>My HTML Page</title>\n");
        htmlBuffer.append("</head>\n");
        htmlBuffer.append("<body>\n");
        htmlBuffer.append("<h1>Hello, World!</h1>\n");
        htmlBuffer.append("<p>This is a sample HTML page created using StringBuffer.</p>\n");
        htmlBuffer.append("</body>\n");
        htmlBuffer.append("</html>");
        return htmlBuffer.toString();
    }
}
