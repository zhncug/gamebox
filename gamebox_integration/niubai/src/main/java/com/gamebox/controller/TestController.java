package com.gamebox.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gamebox.model.TcpTest;
import com.gamebox.service.TcpTestService;

@Controller(value = "testController")
@RequestMapping(value = "/test")
public class TestController {

    @Resource(name = "testService")
    private TcpTestService testService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public List<TcpTest> getAll(HttpServletRequest request, ModelMap model) {

        List<TcpTest> list = testService.getAll();
        return list;
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    @ResponseBody
    public String update(TcpTest test) {

        testService.updateById(test);
        return "OK";
    }

}
