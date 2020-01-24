package dz.stic.trash.controller;

import dz.stic.trash.doa.NoteDAO;
import dz.stic.trash.model.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Note")
public class NoteController {

    @Autowired
    NoteDAO noteDAO;
    @GetMapping("/")
    public List<Note> findAll() {
        return noteDAO.findAll();
    }

    @GetMapping("/{id}")
    public Note findById(@PathVariable Integer id) {
        return noteDAO.findById(id);
    }

    @DeleteMapping("/")
    public boolean deleteAll() {
        noteDAO.deleteAll();
        return true;
    }

    @DeleteMapping("/{id}")
    void deleteComment(@PathVariable int id) {
        Note note=new Note(id);
        noteDAO.delete(note);
    }

    @RequestMapping(value = "/",method = RequestMethod.POST, consumes="application/json")
    boolean newNote(@RequestBody Note note) {
        noteDAO.persist(note);
        return true;
    }

    @PutMapping("/{id}")
    Note PutNote(@RequestBody Note note, @PathVariable int id) {
        note.setId(id);
        noteDAO.update(note);
        return noteDAO.findById(id);
    }

}
