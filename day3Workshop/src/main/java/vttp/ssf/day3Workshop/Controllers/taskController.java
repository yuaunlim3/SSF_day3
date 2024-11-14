package vttp.ssf.day3Workshop.Controllers;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import vttp.ssf.day3Workshop.model.taskToDo;


@Controller
@RequestMapping("/toDoList")
public class taskController {
    public static final String REG_LIST = "reglist";
    private final Logger logger = Logger.getLogger(taskController.class.getName());

    @PostMapping
    public String getTask(
        @Valid @ModelAttribute("tasksTodo") taskToDo task, BindingResult bindings, Model model, HttpSession sess
    ){
        List<taskToDo> regList = (List<taskToDo>)sess.getAttribute(REG_LIST);
        if(sess.getAttribute(REG_LIST) == null){
            //if new session then reglist = null
            regList = new LinkedList<>();
            sess.setAttribute(REG_LIST, regList);
        }
        if(bindings.hasErrors()){
            logger.warning("ERROR");
            model.addAttribute("reglist",regList);
            model.addAttribute("Number",regList.size());
            return "index";
        }

        logger.info("Task %s".formatted(task));

        regList.add(task);
        
        model.addAttribute("tasksTodo", task);
        model.addAttribute("reglist",regList);
        model.addAttribute("Number",regList.size());

        return "index";
    }
}
