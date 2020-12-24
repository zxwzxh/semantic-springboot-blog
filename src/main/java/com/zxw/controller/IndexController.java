package com.zxw.controller;

import com.zxw.exception.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author zxw
 * @create 2020-12-23 8:54
 */
@Controller
public class IndexController {

    @GetMapping("/")
    public String index() {
//        int i = 10 / 0;
        String blog = null;
        if (blog == null) {
            throw new NotFoundException("博客不存在！");
        }
        return "index";
    }

    @GetMapping("/blog")
    public String blog() {
        return "blog";
    }

    @GetMapping("about")
    public String about() {
        return "about";
    }
}
