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
import org.springframework.web.servlet.ModelAndView;

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


    @GetMapping("/AllChallenge")
    /*@ResponseBody*/
    public String viewHomePage(Model model) {
        List<Challenge> listChallenge = challengeDAO.findAll();
        model.addAttribute("listChallenge", listChallenge);
        return "index";
    }
// Modifier challenge
    @RequestMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("edit_form");
        Challenge challenge = challengeDAO.findById(id);
        mav.addObject("challenge", challenge);
        return mav;
    }

    @RequestMapping(value = "/a", method = RequestMethod.POST)
    public String challenge(@ModelAttribute("challenge") Challenge challenge) {
        challenge.setCreatedDate("raoudd");
        challengeDAO.update(challenge);
        return "index";
    }

    // supprimé challenge
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable(name = "id") int id) {
        Challenge challenge=new Challenge(id);
        challengeDAO.delete(challenge);
        return "index";
    }

    // New Challenge
    @RequestMapping("/new")
    public String showNewForm(Model model) {
        Challenge challenge = new Challenge();
        model.addAttribute("challenge", challenge);
        return "Créer_Challenge";
    }
    @PostMapping(value = "/" )
    public String challenge1(@RequestParam("challenge") Challenge challenge) {
        challengeDAO.persist(challenge);
        return "redirect:/";
    }

}
