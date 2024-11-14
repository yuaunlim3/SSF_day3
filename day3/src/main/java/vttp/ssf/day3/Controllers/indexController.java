package vttp.ssf.day3.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import vttp.ssf.day3.model.Registration;

@Controller
@RequestMapping(path = {"/","index.html"})

public class indexController {
    @GetMapping
    public String getIndex(Model model){
        model.addAttribute("reg", new Registration());

        return "index";
    }
}
