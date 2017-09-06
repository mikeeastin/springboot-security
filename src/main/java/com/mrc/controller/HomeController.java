package com.mrc.controller;

import com.mrc.domain.Reader;
import com.mrc.properties.GrilProperties;
import com.mrc.respository.ReaderRespository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * HomeController 登录、注册
 */
@Controller
public class HomeController {
    /**
     * slfj 日志.
     */
    private final static org.slf4j.Logger logger = LoggerFactory.getLogger(HomeController.class);

    /**
     * readerRespository 使用 jpa Respository.
     */
    @Autowired
    private ReaderRespository readerRespository;

    /**
     * 应用首页
     *
     * @return
     */
    @GetMapping(value = {"/"})
    public String index() {
        return "index";
    }

    /**
     * 注册用户页面
     *
     * @param reader
     * @return
     */
    @GetMapping(value = {"/register"})
    public String doRegister(Reader reader) {
        return "register";
    }

    /**
     * 注册用户，保存到数据库
     *
     * @param reader
     * @return
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerUser(@ModelAttribute("reader") Reader reader) {
        logger.info(" 注册的username:" + reader.getUsername() + " password:" + reader.getPassword());
        Reader dbReader = readerRespository.findOne(reader.getUsername());
        if (dbReader != null) {
            return "";
        } else {
            readerRespository.save(reader);
            return "redirect:/reader/" + reader.getUsername();
        }
    }

    /**
     * 注册成功，显示对应的账号
     *
     * @param username
     * @param model
     * @return
     */
    @GetMapping(value = "/reader/{username}")
    public String showReader(@PathVariable String username, Model model) {
        Reader reader = readerRespository.findOne(username);
        model.addAttribute(reader);
        return "success";
    }

    /*public String listReaders(){
        readerRespository.findAll();
        return
    }
*/
}