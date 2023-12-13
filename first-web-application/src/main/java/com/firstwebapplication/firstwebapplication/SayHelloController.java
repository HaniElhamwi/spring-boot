package com.firstwebapplication.firstwebapplication;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class  SayHelloController {



    @RequestMapping("/scratch")
    public String goToLogin(@RequestParam String name , ModelMap model)  {
        model.put("name", name);
        return "scratch";
    }

}
