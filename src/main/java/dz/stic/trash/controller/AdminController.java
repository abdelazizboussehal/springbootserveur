package dz.stic.trash.controller;

import dz.stic.trash.doa.AdministratorDAO;
import dz.stic.trash.model.Administrator;
import dz.stic.trash.model.Challenge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdministratorDAO administratorDAO;
    @GetMapping("/")
    public List<Administrator> findAll1() {
        return administratorDAO.findAll();
    }

    @RequestMapping(value = "/",method = RequestMethod.POST, consumes="application/json")
    public Administrator addAdmin(@RequestBody Administrator administrator) {
        administratorDAO.persist(administrator);
        return administrator;
    }
}
