package dz.stic.trash.controller;

import dz.stic.trash.doa.PhotoDAO;
import dz.stic.trash.model.Photo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class TestController {

    @Autowired
    PhotoDAO photoDAO;

    @GetMapping("/")
    public List<Photo> findAll() {

        return photoDAO.findAll();
    }

    @GetMapping("/insert")
    public boolean ffindAll() {
        Photo photo=new Photo(1,null,null);
        photoDAO.persist(photo);
        return true;
    }
    @GetMapping("/{id}")
    public Photo findById(@PathVariable Integer id) {
        return photoDAO.findById(id);
    }




}
