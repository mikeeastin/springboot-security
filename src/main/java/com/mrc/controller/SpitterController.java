package com.mrc.controller;

/**
 * Created by Administrator on 2017-08-23.
 */


import com.mrc.domain.Spitter;
import com.mrc.respository.SpitterRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping("/spitter")
public class SpitterController {
    private final static org.slf4j.Logger logger = LoggerFactory.getLogger(SpitterController.class);
    /**
     * 使用 spring jdbc template
     * JdbcSpitterRepository implements SpitterRepository
     */
    private SpitterRepository spitterRepository;

    @Autowired
    public SpitterController(
            SpitterRepository spitterRepository) {
        this.spitterRepository = spitterRepository;
    }

    /**
     * 显示注册页面
     *
     * @return
     */
    @RequestMapping(value = "/register", method = GET)
    public String register() {
        return "registerSpitter";
    }

    /**
     * 注册spitter用户  使用 spring jdbc  template
     *新增 spitter
     * @param spitter
     * @return
     */
    @Transactional
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@ModelAttribute("spitter") @Valid Spitter spitter) {
        logger.info(" ------- " + spitter.getUsername() + " " + spitter.getPassword());
        spitterRepository.addSpitter(spitter);

        return "redirect:/spitter/" + spitter.getUsername();
    }

    /**
     * 查找 spitter
     *
     * @param username
     * @param model
     * @return
     */
    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public String showSpitterProfile(@PathVariable String username, Model model) {
        logger.info("sss"+spitterRepository);
        Spitter spitter = spitterRepository.findByUsername(username);
        logger.info(spitter.getUsername() + " password" + spitter.getPassword()+" model:"+model);
       // model.addAttribute(spitter);
        return "spitter";
    }

    /**
     * 列出所有的Spitter
     * @return
     */
    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    @ResponseBody
    public List<Map<String,Object>>  listAll(){
        List<Map<String,Object>> list =  spitterRepository.findAll();
        return list;
    }
    /**
     *  更新spitter
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public String  update(Spitter spitter){
        spitterRepository.updateSpitter(spitter);
        return "";
    }

    /**
     * 删除spitter
     * @return
     */
    @RequestMapping(value="/delete",method = RequestMethod.POST)
    public String delete(){
        return "";
    }
}
