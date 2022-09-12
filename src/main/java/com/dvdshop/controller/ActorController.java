package com.dvdshop.controller;


import com.dvdshop.dto.ActorDTO;
import com.dvdshop.model.Actor;
import com.dvdshop.service.ActorService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Actor controller")
@AllArgsConstructor
@RestController
@RequestMapping(value = ActorController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class ActorController {

    static final String REST_URL = "/actor";
   private ActorService actorService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> createNewActor(@RequestBody ActorDTO dto){
       return new ResponseEntity(actorService.createActor(dto), HttpStatus.OK);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteActorById(@PathVariable Long id){
         return new ResponseEntity(actorService.deleteActor(id), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Actor> findById(@PathVariable Long id){
        return new ResponseEntity(actorService.findById(id), HttpStatus.OK);

    }
    @GetMapping("/getByFirstName")
    public ResponseEntity<List<Actor>> findActorByFirstName(@RequestParam(name = "firstName") String firstName){
        return new ResponseEntity(actorService.findActorByFirstName(firstName), HttpStatus.OK);
    }
    @GetMapping("/getByLastName")
    public ResponseEntity<List<Actor>> findActorByLastName(@RequestParam(name = "lastName") String lastName){
        return new ResponseEntity(actorService.findActorByLastName(lastName), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ActorDTO>> getAll() {
       return new ResponseEntity(actorService.getAll(), HttpStatus.OK);

    }

}
