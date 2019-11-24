package com.upfile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
public class LoginControl {

    @RequestMapping("/get")
    public String err() {
        return "success";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String get(@RequestParam("passwd") String passwd, HttpServletRequest res){
        if ("097867".equals(passwd)) {
            HttpSession session = res.getSession();
            session.setAttribute("admin", "weiqiang");
            return "true";
        }
        return "false";
    }



}
