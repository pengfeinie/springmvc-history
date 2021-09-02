package org.example.controller;

import org.example.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.nio.charset.StandardCharsets;

@Controller
public class HelloWorldController {


	@Autowired
	private HelloService helloService;
	
    @RequestMapping(value = "/v1/hello/world")
    public void hello(@RequestParam String name, HttpServletResponse response) throws Exception{
        response.getOutputStream().write(helloService.getHelloMessage(name).getBytes(StandardCharsets.UTF_8));
    }

}


