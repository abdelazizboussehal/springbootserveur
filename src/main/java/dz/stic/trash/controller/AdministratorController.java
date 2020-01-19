package dz.stic.trash.controller;

import dz.stic.trash.doa.AdministratorDAO;
import dz.stic.trash.doa.ChallengeDAO;
import dz.stic.trash.model.Administrator;
import dz.stic.trash.model.Challenge;
import dz.stic.trash.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdministratorController {

    @Autowired
    AdministratorDAO administratorDAO;
    @Autowired
    ChallengeDAO challengeDAO;

    @GetMapping("/")
    public List<Administrator> findAll() {
        return administratorDAO.findAll();
    }
    @GetMapping("/{id}")
    public Administrator findById(@PathVariable Integer id) {
        return administratorDAO.findById(id);
    }

    @GetMapping("/AaallChallenge")
    public List<Challenge> findAllChallenge() {

        return challengeDAO.findAll();
    }
    @GetMapping("/AllChallenge")
    /*@ResponseBody*/
    public String viewHomePage(Model model) {
        List<Challenge> listChallenge = challengeDAO.findAll();
        model.addAttribute("listChallenge", listChallenge);
        return "index";
    }
}
