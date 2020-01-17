package dz.stic.trash.controller;


import org.springframework.web.bind.annotation.RequestMapping;

        import org.springframework.web.bind.annotation.RequestMethod;
        import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class PhotoController {

    @GetMapping("/photo")
    public String greeting() {
        return "img";
    }

}