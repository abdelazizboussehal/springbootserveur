package dz.stic.trash.controller;

import dz.stic.trash.doa.AdministratorDAO;
import dz.stic.trash.doa.ChallengeDAO;
import dz.stic.trash.doa.CommentDAO;
import dz.stic.trash.model.Administrator;
import dz.stic.trash.model.Challenge;
import dz.stic.trash.model.Comments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/adminn")
public class AdministratorController {

    @Autowired
    AdministratorDAO administratorDAO;
    @Autowired
    ChallengeDAO challengeDAO;
    @Autowired
    CommentDAO commentDAO;
    @GetMapping("/")
    public List<Administrator> findAll() {
        return administratorDAO.findAll();
    }
    @GetMapping("/{id}")
    public Administrator findById(@PathVariable Integer id) {
        return administratorDAO.findById(id);
    }


    @RequestMapping(value="/AllChallenge" , method = RequestMethod.GET)
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

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String challenge(@ModelAttribute("challenge") Challenge challenge) {
        challengeDAO.update(challenge);
        return "redirect:/adminn/AllChallenge";
    }

    // supprimé challenge
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable(name = "id") int id) {
        Challenge challenge=new Challenge(id);
        challengeDAO.delete(challenge);
        return "redirect:/adminn/AllChallenge";
    }

    // New Challenge
    @RequestMapping("/new")
    public String showNewForm(Model model) {
        Challenge challenge = new Challenge();
        model.addAttribute("challenge", challenge);
        return "Créer_Challenge";
    }
    @RequestMapping(value = "/new",method = RequestMethod.POST )
    public String challenge1(@ModelAttribute("challenge") Challenge challenge) {

        challengeDAO.persist(challenge);

        return "redirect:/adminn/AllChallenge";
    }
// Login
    @RequestMapping("/Login")
    public  ModelAndView Login() {
        ModelAndView mav = new ModelAndView("Login");
        List<Administrator> listAdmin =administratorDAO.findAll();
        mav.addObject("listAdmin", listAdmin);
        return mav;
    }
/*
    @RequestMapping("/state/{id}")
    public ModelAndView showEditState(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("edit_form1");
        Challenge challenge1 = challengeDAO.findById(id);
        mav.addObject("challenge1", challenge1);
        return mav;
    }

    @RequestMapping(value = "/update1", method = RequestMethod.POST)
    public String challengeState(@ModelAttribute("challenge") Challenge challenge1) {
        challengeDAO.update(challenge1);
        return "redirect:/adminn/AllChallenge";
    }
    @RequestMapping("/state/{id}")
    public String state(@PathVariable(name = "id") int id) {
        Challenge challenge=new Challenge(id);
            challenge.setState(0);
        challengeDAO.update(challenge);
        return "redirect:/adminn/AllChallenge";
    }*/
///////// Set State
@ModelAttribute
public void addAttributes(Model model) {
    List<Challenge> listChallenge = new ArrayList<>();
    model.addAttribute("listChallenge", listChallenge);
}
    @RequestMapping("/SetState/{id}")
    public String UpdateState(@PathVariable(name = "id") int id,
                              @ModelAttribute("listChallenge") List<Challenge>listChallenge,
                              Model model){

        Challenge challenge=challengeDAO.findById(id);
        if(challenge.getState()==1)
        { challenge.setState(0);}
        else{
            challenge.setState(1);}
        challengeDAO.update(challenge);
        listChallenge.addAll(challengeDAO.findAll());
        model.addAttribute("listChallenge", listChallenge);
        return "redirect:/adminn/AllChallenge";}

        ////////////////// Gestion des Commentairs ////////////////////////

    @RequestMapping(value="/challengeComment" , method = RequestMethod.GET)
    /*@ResponseBody*/
    public String viewCommentPage(Model model) {
        List<Challenge> listChallenge = challengeDAO.findAll();
        model.addAttribute("listChallenge", listChallenge);
        return "index_comment";
    }

}
