package com.mrc.controller;

import com.mrc.domain.Reader;
import com.mrc.properties.GrilProperties;
import com.mrc.respository.ReaderRespository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class HelloController {
    private final  static org.slf4j.Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private GrilProperties grilProperties;
    @Autowired
    private ReaderRespository readerRespository;

    /**
     * 应用首页
     * @return
     */
    @GetMapping(value = {"/"})
    public String index() {
        return "index";
    }

    /**
     * 注册用户页面
     * @param reader
     * @return
     */
    @GetMapping(value = {"/register"})
    public String doRegister(Reader reader) {
        return "register";
    }

    /**
     * 注册用户，保存到数据库，使用 jpa
     * @param reader
     * @return
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerUser(@ModelAttribute("reader") Reader reader) {
        logger.info(" username:" + reader.getUsername() + " password:" + reader.getPassword());
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
     * @param username
     * @param model
     * @return
     */
    @GetMapping(value="/reader/{username}")
    public String showReader(@PathVariable  String username,Model model){
         Reader reader = readerRespository.findOne(username);
         model.addAttribute(reader);
         return "registerSuccess";
    }

    /**
     * 随便写的
     * @param id
     * @return
     */
    @GetMapping(value = {"/say"})
    public String say(@PathVariable("id") int id) {
        return "hello " + grilProperties.getCupSize() + "  id:" + id;
    }

}