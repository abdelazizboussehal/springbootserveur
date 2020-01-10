package dz.stic.trash.controller;

import dz.stic.trash.doa.ChallengeDAO;
import dz.stic.trash.doa.ClientDAO;
import dz.stic.trash.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/challenge")
public class ChallengeContoller {

    @Autowired
    ChallengeDAO challengeDAO;

    @GetMapping("/")
    public List<Challenge> findAll() {
        return challengeDAO.findAll();
    }


    @GetMapping("/{id}")
    public Challenge findById(@PathVariable Integer id) {
        return challengeDAO.findById(id);
    }


    @DeleteMapping("/")
    public boolean deleteAll() {
        challengeDAO.deleteAll();
        return true;
    }
    @RequestMapping(value = "/",method = RequestMethod.POST, consumes="application/json")
    boolean newEmployee(@RequestBody Challenge newChallenge) {
        challengeDAO.persist(newChallenge);
        return true;
    }

    @PutMapping("/{id}")
    Challenge remplaceChallenge(@RequestBody Challenge newChallenge, @PathVariable int id) {
        newChallenge.setId(id);
        challengeDAO.update(newChallenge);
        return challengeDAO.findById(id);
    }

    @DeleteMapping("/{id}")
    void deleteChallenge(@PathVariable int id) {
        Challenge challenge=new Challenge(id);
        challengeDAO.delete(challenge);
    }



}
