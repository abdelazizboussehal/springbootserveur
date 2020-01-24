package dz.stic.trash.controller;

import com.google.gson.Gson;
import dz.stic.trash.doa.ChallengeDAO;
import dz.stic.trash.doa.CommentDAO;
import dz.stic.trash.model.Challenge;
import dz.stic.trash.model.Client;
import dz.stic.trash.model.Comments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    CommentDAO commentDAO;
    @Autowired
    ChallengeDAO challengeDAO;

    @GetMapping("/")
    public List<Comments> findAll() {
        return commentDAO.findAll();
    }

    @GetMapping("/{id}")
    public Comments findById(@PathVariable Integer id) {
        return commentDAO.findById(id);
    }

    @DeleteMapping("/")
    public boolean deleteAll() {
        commentDAO.deleteAll();
        return true;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST, consumes = "application/json")
    boolean newComment(@RequestBody Challenge challenge) {
        challengeDAO.update(challenge);
        return true;
    }

    @PutMapping("/{id}")
    Comments PutComment(@RequestBody Comments comments, @PathVariable int id) {
        comments.setId(id);
        commentDAO.update(comments);
        return commentDAO.findById(id);
    }

    @DeleteMapping("/{id}")
    void deleteComment(@PathVariable int id) {
        Comments comments = new Comments(id);
        commentDAO.delete(comments);
    }

    @GetMapping("/test")
    public List<Comments> findAlll() {
        Client client = new Client(5);
        Challenge challenge = new Challenge(41);
        Comments comments = new Comments("aziz");
        comments.addClient(client);
        challenge.addComment(comments);
        challenge.setrClient(client);
        Comments comments1 = new Comments("papa");
        comments1.addClient(client);
        challenge.addComment(comments1);
        challengeDAO.update(challenge);
        return commentDAO.findAll();
    }

    @PostMapping("/")
    boolean newComments(@RequestParam("comments") String sComment,@RequestParam("challenge") String schallenge) {
        Gson gson = new Gson();
        Challenge challenge = gson.fromJson(schallenge, Challenge.class);
        Comments comments = gson.fromJson(sComment, Comments.class);
        //challenge.getrComments().iterator().next().setId(1);
        challenge.addComment(comments);
        challengeDAO.update(challenge);
        return true;
    }

}
