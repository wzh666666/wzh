package com.juzheng.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class ActionController {
	@RequestMapping(value = "/wzh/test", method = RequestMethod.GET)
    public String wzhtest() {
        return "wzh/test.html";
    }
	
	@RequestMapping(value = "/wzh/index", method = RequestMethod.GET)
    public String wzhindex() {
        return "wzh/index.html";
    }
	
	@RequestMapping(value = "/wzh/table", method = RequestMethod.GET)
    public String wzhtable() {
        return "wzh/table.html";
    }
	
    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public String product() {
        return "product.html";
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "index.html";
    }

    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public String about() {
        return "about.html";
    }

    @RequestMapping(value = "/case", method = RequestMethod.GET)
    public String cased() {
        return "case.html";
    }

    @RequestMapping(value = "/news", method = RequestMethod.GET)
    public String news() {
        return "news.html";
    }

    @RequestMapping(value = "/newsDetail", method = RequestMethod.GET)
    public String newsDetail() {
        return "newsDetail.html";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)             
    public String login() {
        return "login.html";
    }
    @RequestMapping(value = "/login22", method = RequestMethod.GET)
    public String login22() {
        return "login22.html";
    }

    @RequestMapping(value = "/buytoday", method = RequestMethod.GET)
    public String buytoday() {
        return "buytoday.html";
    }

    @RequestMapping(value = "/information", method = RequestMethod.GET)
    public String information() {
        return "information.html";
    }

    @RequestMapping(value = "/shopcart", method = RequestMethod.GET)
    public String shopcart() {
        return "shopcart.html";
    }

    @RequestMapping(value = "/commodity", method = RequestMethod.GET)
    public String commodity() {
        return "commodity.html";
    }

    @RequestMapping(value = "/details", method = RequestMethod.GET)
    public String detail() {
        return "details.html";
    }
    @RequestMapping(value = "/map", method = RequestMethod.GET)
    public String map() {
        return "map.html";
    }
}
