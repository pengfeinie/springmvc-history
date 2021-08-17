package org.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.StandardCharsets;

@Controller
@EnableWebMvc
public class HelloWorldController {


    @RequestMapping(value = "/v1/hello/world")
    public void hello(@RequestParam String name, HttpServletResponse response) throws Exception{
        response.getOutputStream().write(name.getBytes(StandardCharsets.UTF_8));
    }

}