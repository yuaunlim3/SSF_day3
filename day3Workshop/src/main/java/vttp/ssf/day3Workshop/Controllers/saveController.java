package vttp.ssf.day3Workshop.Controllers;

import java.util.List;

import org.springframework.boot.autoconfigure.security.oauth2.server.servlet.OAuth2AuthorizationServerProperties.Registration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import vttp.ssf.day3Workshop.model.taskToDo;

@Controller
@RequestMapping
public class saveController {

   @PostMapping("/exit")
   public String postExit(HttpSession sess, Model model) {
       //TODO: process POST request
       List<taskToDo> regList = (List<taskToDo>)sess.getAttribute(taskController.REG_LIST);

       System.out.printf(">>> reglist: %s\n", regList);

       // Destroy the session
       sess.invalidate();

       model.addAttribute("tasksTodo",new taskToDo());
       model.addAttribute("Number",0);

       
       return "index";
   }
}
