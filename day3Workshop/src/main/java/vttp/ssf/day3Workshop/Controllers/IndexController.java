package vttp.ssf.day3Workshop.Controllers;

import java.util.logging.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import vttp.ssf.day3Workshop.model.taskToDo;

@Controller
@RequestMapping(path={"/", "index.html"})
public class IndexController {
       private final Logger logger = Logger.getLogger(IndexController.class.getName());
   @GetMapping
   public String getIndex(Model model) {

      model.addAttribute("tasksTodo", new taskToDo());
      model.addAttribute("Number",0);

      logger.info("New session started");


      return "index";
   }
   
   
}
