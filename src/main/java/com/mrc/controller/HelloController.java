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
    private Logger logger;

    @Autowired
    private GrilProperties grilProperties;
    @Autowired
    private ReaderRespository readerRespository;

    @GetMapping(value = {"/"})
    public String index() {
        return "index";
    }

    @GetMapping(value = {"/register"})
    public String doRegister(Reader reader) {
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerUser(@ModelAttribute("reader") Reader reader) {
        System.out.println("-------" + reader + "  username:" + reader.getUsername() + " password:" + reader.getPassword());
        Reader dbReader = readerRespository.findOne(reader.getUsername());
        if (dbReader != null) {
            return "";
        } else {
            readerRespository.save(reader);
            return "redirect:/reader/" + reader.getUsername();
        }
    }
    @GetMapping(value="/reader/{username}")
    public String showReader(@PathVariable  String username,Model model){
         Reader reader = readerRespository.findOne(username);
         model.addAttribute(reader);
         return "registerSuccess";
    }

    @GetMapping(value = {"/say"})
    public String say(@PathVariable("id") int id) {
        return "hello " + grilProperties.getCupSize() + "  id:" + id;
    }

}