package com.example.ex3.controller;



import org.springframework.web.bind.annotation.RestController;

import com.example.ex3.model.Door;
import com.example.ex3.service.DoorService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
public class DoorController {
    private DoorService doorService;

    public DoorController(DoorService doorService) {
        this.doorService = doorService;
    }
    @PostMapping("/api/door")
    public ResponseEntity<Door> postDetail(@RequestBody Door door)
    {
        Door d=doorService.postDetail(door);
        return new ResponseEntity<Door>(d, HttpStatus.CREATED);
    }
    @GetMapping("/api/door")
    public ResponseEntity<List<Door>> getAll()
    {
        List<Door> list=doorService.getAll();
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
    @GetMapping("/api/door/{doorId}")
    public ResponseEntity<Door> getById(@PathVariable int doorId)
    {
        Door d=doorService.getByDoorId(doorId);
        return new ResponseEntity<Door>(d, HttpStatus.OK);
    }
    @GetMapping("/api/door/accesstype/{accessType}")
    public ResponseEntity<List<Door>> getByAccessType(@PathVariable String accessType)
    {
        List<Door> list=doorService.getByAccessType(accessType);
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
 
}
