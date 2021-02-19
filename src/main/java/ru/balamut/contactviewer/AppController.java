/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.balamut.contactviewer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.balamut.contactviewer.entity.Contact;

/**
 *
 * @author Balamut
 */
@Controller
public class AppController {
    
    @Autowired 
    private ContactDataService contactDataService;
    
    @RequestMapping(value={"","/"})
    public String index() {
         return "index";
    }
    
    @PostMapping("/add")
    @ResponseBody
    public String doPostAdd(@RequestParam("fullName") String pFullName, @RequestParam("address") String pAddress, @RequestParam("phone") String pPhone) {
        try{
            contactDataService.updOne(new Contact(null, pFullName, pAddress, pPhone));
            return "{OK}";
        } catch (Exception e) {
            return "{ERR}";
        }
    }
     
    @PostMapping("/delete")
    @ResponseBody
    public String doPostDelete(@RequestParam("id") Long pId) {
        try{
            contactDataService.delOne(pId);
            return "{OK}";
        } catch (Exception e) {
            return "{ERR}";
        }
    }
    
    @PostMapping("/edit")
    @ResponseBody
    public String doPostEdit(@RequestParam("id") Long pId, @RequestParam("fullName") String pFullName, @RequestParam("address") String pAddress, @RequestParam("phone") String pPhone) {
         try{
            contactDataService.updOne(new Contact(pId, pFullName, pAddress, pPhone));
            return "{OK}";
        } catch (Exception e) {
            return "{ERR}";
        }
    }
    
    @GetMapping("/list")
    @ResponseBody
    public String doGetList() {
        
        //return "{src:doGetList}";
        ObjectMapper mapper = new ObjectMapper();
        
        String jsonList = "{dummy}";
        try {
            jsonList = mapper.writeValueAsString(contactDataService.getAll());
        } catch (JsonProcessingException e) {
            jsonList = "{error:"+e.getMessage()+"}";
        }
        return jsonList;
    }
    
    ///////////////////////////////////////////////////////
    // stubs
    
    @GetMapping("/edit")
    public String doGetEdit(ModelMap model) {
        model.addAttribute("message", "doGetEdit()");
        return "StubGet";
    }
    
    @GetMapping("/delete")
    public String doGetDelete(ModelMap model) {
        model.addAttribute("message", "doGetDelete()");
        return "StubGet";
    }
    
    @GetMapping("/add")
    public String doGetAdd(ModelMap model) {
        model.addAttribute("message", "doGetAdd()");
        return "StubGet";
    }
    
}
