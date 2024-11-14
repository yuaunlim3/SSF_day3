package vttp.ssf.day3.Controllers;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import vttp.ssf.day3.model.Registration;

@Controller
@RequestMapping("/registration")
public class formController {
    public static final String REG_LIST = "reglist";
    @PostMapping("/obj")

    public String postRegistration(
            @Valid @ModelAttribute("reg") Registration registration,
            // must be after valid
            BindingResult bindings,Model model, HttpSession sess) {

        System.out.printf("Bindings : %b\n", bindings.hasErrors());
        System.out.printf(">>>Registration: %s \n", registration);
        if(bindings.hasErrors()){
            model.addAttribute("reg", registration);
            return "index";
        }

        if("fred".equals(registration.getName().toLowerCase())){
            FieldError err = new FieldError("reg", "name","you cannot use the name fred");
            bindings.addError(err);
            ObjectError objErr1 = new ObjectError("globalError", "Error 1");
            bindings.addError(objErr1);
            ObjectError objErr2 = new ObjectError("globalError", "Error 2");
            bindings.addError(objErr2);
            return "index";
        }

        //check if sess has a list
        List<Registration> regList = (List<Registration>)sess.getAttribute(REG_LIST);
        if(sess.getAttribute(REG_LIST) == null){
            //if new session then reglist = null
            regList = new LinkedList<>();
            sess.setAttribute(REG_LIST, regList);
        }

        regList.add(registration);
        model.addAttribute("reg", registration);
        model.addAttribute("reglist", regList);

        return "registered";

    }

    @PostMapping

    public String postRegistration(
            @RequestBody MultiValueMap<String, String> form,
            @RequestBody String rawBody,
            Model model) {
        Registration reg = new Registration();
        reg.setName(form.getFirst("name"));
        reg.setEmail(form.getFirst("email"));
        reg.setComment(form.getFirst("comment"));

        System.out.printf("form: %s \n", form);
        System.out.printf("Rawbody: %s \n", rawBody);
        model.addAttribute("reg", reg);
        return "registered";

    }
}
