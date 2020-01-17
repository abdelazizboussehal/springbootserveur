package dz.stic.trash.controller;

import com.google.gson.Gson;
import dz.stic.trash.doa.ChallengeDAO;
import dz.stic.trash.doa.PhotoDAO;
import dz.stic.trash.model.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

@RestController
@RequestMapping("/challenge")
public class ChallengeContoller {

    @Autowired
    ChallengeDAO challengeDAO;
    @Autowired
    PhotoDAO photoDAO;

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
    @RequestMapping("/download/{fileName}")
    public ResponseEntity<InputStreamResource> downloadFile1(
            @PathVariable String fileName) throws IOException {



        File file = new File( "C:\\Users\\Aziz\\AppData\\Local\\Temp\\photos"+ "/" + fileName);
        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

        return ResponseEntity.ok()
                // Content-Disposition
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + file.getName())
                // Content-Type
                // Contet-Length
                .contentLength(file.length()) //
                .body(resource);
    }

    @GetMapping("/img")
    public String greeting() {
        return "img";
    }
    @RequestMapping("/test")
    public String test() {
        Challenge challenge=new Challenge(1,1,null,null,null,null);
        Photo photo=new Photo(1,"aziz",null);
        Photo photo1=new Photo(2,",aziza",null);
        challenge.addPhoto(photo);
        challenge.addPhoto(photo1);
        photoDAO.persist(photo);
        photoDAO.persist(photo1);
        challengeDAO.persist(challenge);
        return "false";
    }
}
