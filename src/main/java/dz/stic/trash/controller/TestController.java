package dz.stic.trash.controller;

import dz.stic.trash.doa.AdminDAO;
import dz.stic.trash.doa.PhotoDAO;
import dz.stic.trash.model.Admin;
import dz.stic.trash.model.Photo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class TestController {

    @Autowired
    AdminDAO adminDAO;
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
    public Admin findAll(@PathVariable Integer id) {
        return adminDAO.findById(id);
    }


}
