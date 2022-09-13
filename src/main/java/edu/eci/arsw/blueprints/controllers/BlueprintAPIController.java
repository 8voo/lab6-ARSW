/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.blueprints.controllers;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gson.Gson;
import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.persistence.BlueprintNotFoundException;
import edu.eci.arsw.blueprints.persistence.BlueprintPersistenceException;
import edu.eci.arsw.blueprints.services.BlueprintsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author hcadavid
 */

@Service
@RestController
@RequestMapping(value = "/blueprint")
public class BlueprintAPIController {

    @Autowired
    private BlueprintsServices bps;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> manejadorGetBlueprints() {
        //obtener datos que se enviarán a través del API
        return new ResponseEntity<>(new Gson().toJson(bps.getAllBlueprints()), HttpStatus.ACCEPTED);
    }

    @RequestMapping("{autor}")
    public ResponseEntity<?> getBlueprientsById(@PathVariable String autor) throws BlueprintNotFoundException {
        if(bps.getBlueprintsByAuthor(autor).isEmpty()){
            return new ResponseEntity<>( HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<>(new Gson().toJson(bps.getBlueprintsByAuthor(autor)), HttpStatus.ACCEPTED);
        }
    }

    @RequestMapping("{autor}/{name}")
    public ResponseEntity<?> getEmployeesById(@PathVariable String autor, @PathVariable String name) throws BlueprintNotFoundException {
        if(bps.getBlueprint(autor, name) == null){
            return new ResponseEntity<>( HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<>(new Gson().toJson(bps.getBlueprint(autor,name)), HttpStatus.ACCEPTED);
        }
    }

}

