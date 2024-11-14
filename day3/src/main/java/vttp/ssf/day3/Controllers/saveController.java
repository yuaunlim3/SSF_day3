package vttp.ssf.day3.Controllers;

import java.util.List;

import org.springframework.boot.autoconfigure.security.oauth2.client.OAuth2ClientProperties.Registration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping

public class saveController {
    @PostMapping("/exit")
    public String postExit(HttpSession sess, Model model){
        List<Registration> regList = (List<Registration>)sess.getAttribute(formController.REG_LIST);
        System.out.println(regList);
        sess.invalidate();
        model.addAttribute("reg", new Registration());
        return "index";
    }
    
}
