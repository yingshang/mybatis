package com.example.mybatis.controller;

import com.example.mybatis.entity.User;
import com.example.mybatis.service.UserService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {


    private  static final Logger logger = LogManager.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping("/findAll")
    public List<User> findAll(){
        return userService.findAll();
    }

    @RequestMapping("/getUser")
    @ResponseBody
    public User toIndex(HttpServletRequest request, Model model){
        String username = request.getParameter("username");
        User user = this.userService.getUserName(username);
        return user;
    }

    @RequestMapping("/command")
    @ResponseBody
    public String Command(HttpServletRequest request) throws IOException, InterruptedException {
        String ip = request.getParameter("ip");
        System.out.println(ip);
        Runtime run = Runtime.getRuntime();
        Process p = run.exec("ping "+ip);
        InputStream is = p.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        p.waitFor();
        if (p.exitValue() != 0) {
            //说明命令执行失败
            //可以进入到错误处理步骤中
        }

        String s = null;
        String tmp = "";
        while ((s = reader.readLine()) != null) {
            System.out.println(s);
            tmp = tmp+s+"\n";
        }
        return tmp;
    }



    @RequestMapping("/log4j")
    @ResponseBody
    public String Log4j(HttpServletRequest request) throws IOException, InterruptedException {
        String msg = request.getParameter("msg");
        logger.error(msg);
        logger.debug(msg);
        return msg;
    }



}