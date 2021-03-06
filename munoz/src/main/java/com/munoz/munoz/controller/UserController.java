package com.munoz.munoz.controller;


import com.munoz.munoz.repo.UserRepository;
import com.munoz.munoz.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/demo")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping(value = "/create/{name}")
    public String createUsers(@PathVariable("name") String name) {
        try {
            // This returns a JSON or XML with the users
            List<Student> users = (List<Student>) userRepository.findAll();
            int newId = users.get(users.size() - 1).getId() + 1;
            Student student = new Student();
            student.setId(newId);
            student.setName(name);
            userRepository.save(student);
                return "Success! You created " + student.getName() + " with an id of " + student.getName();
        }catch(Exception e){
            return "Failed to create";
        }
    }

    @GetMapping(value = "/findAll")
    public @ResponseBody
    Iterable<Student> getAllUsers() {
        // This returns a JSON or XML with the users
        return userRepository.findAll();
    }

    @GetMapping(value = "/update/{id}/{name}")
    public @ResponseBody
    String updateUser(@PathVariable("id") String id, @PathVariable("name") String name) {
        try {
            Student student = new Student();
            student.setId(Integer.parseInt(id));
            student.setName(name);
            userRepository.save(student);
            return "Success in updating!";
        } catch (Exception e) {
            return "Fail to update";
        }
    }

    @GetMapping(value = "/delete/{id}") //success
    public @ResponseBody
    String deleteUser(@PathVariable("id") String id) {
        // This returns a JSON or XML with the users
        try {
            userRepository.deleteById(Integer.parseInt(id));
            return "Success, deleted entry";
        } catch (Exception e) {
            return "Fail to delete";
        }
    }

//    @DeleteMapping(value = "/studentsD/{id}")
//    public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") int id) {
//        try {
//            userRepository.deleteById(id);
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @PutMapping("/studentsU/{id}")
//    public ResponseEntity<Student> updateTutorial(@PathVariable("id") int id, @RequestBody Student tutorial) {
//        Optional<Student> tutorialData = userRepository.findById(id);
//        if (tutorialData.isPresent()) {
//            Student _tutorial = tutorialData.get();
//            _tutorial.setName("pana");
//            return new ResponseEntity<>(userRepository.save(_tutorial), HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//
//    @PostMapping("newStudent/{name}") // Map ONLY POST Requests
//    public ResponseEntity<HttpStatus> addNewUser(@PathParam("name") String name) {
//        List<Student> users = (List<Student>) userRepository.findAll();
//        int newId = users.get(users.size()-1).getId()+1;
//        try {
//            Student student = new Student();
//            student.setId(newId);
//            student.setName(name);
//            userRepository.save(student);
//            return new ResponseEntity<>(HttpStatus.CREATED);
//        } catch (Exception e) {
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
}