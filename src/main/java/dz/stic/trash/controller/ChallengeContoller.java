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
    ClientDAO clientDAO;

    @GetMapping("/")
    public List<Challenge> findAll() {
        return challengeDAO.findAll();
    }

    @GetMapping("/insert")
    public boolean ffindAll() {
        Challenge challenge=new Challenge(1,null,null,null,
                new Address(1,0.2,2.0,"khroub","constine","3","alegeria"));

        challengeDAO.persist(challenge);
        return true;
    }
    @GetMapping("/{state}/{lat}/{lon}/{city}")
    public Challenge newEmployee (@PathVariable int state,@PathVariable double lat,@PathVariable double lon,@PathVariable String city) {
        //challengeDAO.persist(newEmployee);
        Challenge challenge=new Challenge(state,null,null,null,
                new Address(0,lon,lat,"",city,"",""));
        challengeDAO.persist(challenge);
        return challenge;
    }
    @GetMapping("/{id}")
    public Challenge findById(@PathVariable Integer id) {
        return challengeDAO.findById(id);
    }

    @GetMapping("/delete/{id}")
    public boolean deleteById(@PathVariable Integer id) {
        Challenge challenge=new Challenge(id);
        challengeDAO.delete(challenge);
        return true;
    }

    @GetMapping("/delete/")
    public boolean deleteAll() {
        challengeDAO.deleteAll();
        return true;
    }




}
