package dz.stic.trash.controller;

import dz.stic.trash.doa.ChallengeDAO;
import dz.stic.trash.doa.ClientDAO;
import dz.stic.trash.model.Challenge;
import dz.stic.trash.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    ClientDAO clientDAO;

    @GetMapping("/auth")
    public List<Client> auth(@RequestHeader("username") String username,@RequestHeader("password") String password) {
        Client client=new Client();
        client.setUserName(username);
        client.setPassword(password);
        return clientDAO.auth(client);

    }
    @PutMapping("/{id}")
    Client modfierClient(@RequestBody Client client, @PathVariable int id) {
        client.setId(id);
        clientDAO.update(client);
        return clientDAO.findById(id);
    }
    @RequestMapping(value = "/",method = RequestMethod.POST, consumes="application/json")
    public Client creeClient(@RequestBody Client client){
        clientDAO.persist(client);
        return  client;
    }
    @GetMapping("/")
    public List<Client> getAll() {
        return clientDAO.findAll();

    }
    @DeleteMapping("/")
    public boolean deleteAll() {
        clientDAO.deleteAll();
        return true;
    }
    @DeleteMapping("/{id}")
    void deleteClient(@PathVariable int id) {
        Client client=new Client();
        client.setId(id);
        clientDAO.delete(client);
    }

}
