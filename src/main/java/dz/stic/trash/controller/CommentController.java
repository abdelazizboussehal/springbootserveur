package dz.stic.trash.controller;

import dz.stic.trash.doa.ChallengeDAO;
import dz.stic.trash.doa.CommentDAO;
import dz.stic.trash.model.Challenge;
import dz.stic.trash.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    CommentDAO commentDAO;

    @GetMapping("/")
    public List<Comment> findAll() {
        return commentDAO.findAll();
    }
    @GetMapping("/{id}")
    public Comment findById(@PathVariable Integer id) {
        return commentDAO.findById(id);
    }

    @DeleteMapping("/")
    public boolean deleteAll() {
        commentDAO.deleteAll();
        return true;
    }

    @RequestMapping(value = "/",method = RequestMethod.POST, consumes="application/json")
    boolean newComment(@RequestBody Comment comment) {
        commentDAO.persist(comment);
        return true;
    }

    @PutMapping("/{id}")
    Comment PutComment(@RequestBody Comment comment, @PathVariable int id) {
        comment.setId(id);
        commentDAO.update(comment);
        return commentDAO.findById(id);
    }
    @DeleteMapping("/{id}")
    void deleteComment(@PathVariable int id) {
        Comment comment=new Comment(id);
        commentDAO.delete(comment);
    }
}
