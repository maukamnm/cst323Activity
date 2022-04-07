package com.mmunoz.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/objectTable")
public class Controller {

    @Autowired
    ObjectRepository objectRepo;

    @Autowired
    private ObjectClass objectClass;

    @PostMapping(path = "/add/{name}")
    public ResponseEntity<ObjectClass> addObj(@PathVariable (name = "name") String name) {
        ObjectClass student = objectRepo.save(new ObjectClass(name));
        return ResponseEntity.ok(student);
    }
    @PostMapping(path = "/edit/{id}/{name}")
    public ResponseEntity<ObjectClass> editObj(@PathVariable (name = "name") String name,@PathVariable (name = "id") int id) {
        ObjectClass student = objectRepo.save(new ObjectClass(id,name));
        return ResponseEntity.ok(student);
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<ObjectClass> deleteObj(@PathVariable (name = "id") String id) {
        ObjectClass student = objectRepo.save(new ObjectClass(id));
        return ResponseEntity.ok(student);
    }

    @GetMapping(path = "/add/{name}")
    public ResponseEntity<ObjectClass> getObj(@PathVariable (name = "name") String name) {
        ObjectClass student = objectRepo.save(new ObjectClass(name));
        return ResponseEntity.ok(student);
    }

}
