package iris.platform.shop.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/** 
 * @author: xinguiyuan
 * @date: 2018-10-17 22:57:36 
 */
@Controller
@RequestMapping("/")
@Slf4j
public class TestController {

    @RequestMapping("/")
    public String index(ModelMap modelMap) {
        log.info("here is the first page");
        return "login";
    }
}

