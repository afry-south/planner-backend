package com.afconsult.planner.controller;

import com.afconsult.planner.exception.NotFoundException;
import com.afconsult.planner.repository.AbsenceInfo;
import com.afconsult.planner.service.AbsenceInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @AbsenceInfoController provides endpoints for retrieving all absences,
 * absence for a specific user and creating a absence for a user.
 */

@RestController
@RequestMapping(value = "/info", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class AbsenceInfoController {

    @Autowired
    private AbsenceInfoService absenceInfoService;

    /**
     * Endpoint for retrieving absence information for a specific user.
     * @param userId
     * @return ResponseEntity Object with absence information.
     * @throws NotFoundException if no information is found.
     */
    @GetMapping(value = "/{userId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity getAbscenseInfoBy(@PathVariable int userId){
        Optional<AbsenceInfo> result = absenceInfoService.getAbscenseInfoByUser(userId);
        if(!result.isPresent()){
            throw new NotFoundException("The information is not found!");
        }
        return ResponseEntity.ok(result);
    }

    /**
     * Endpoint for retrieving all absence information in a batch.
     * @return ResponseEntity Object with absence information.
     * @throws NotFoundException if no information is found.
     */
    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity getAllAbscenses(){
        List<AbsenceInfo> allInfo = absenceInfoService.getAllAbscenses();
        if(allInfo.isEmpty()){
           throw new NotFoundException("The information is not found!");
        }
        return ResponseEntity.ok(allInfo);
    }

    /**
     * Endpoint for creating an new absence.
     * @param absenceInfo Object
     * @param userId
     * @return ResponseEntity Object with status of how the creation went.
     */
    @PostMapping(value = "{userId}/create",  produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseEntity createAbscense(@RequestBody  AbsenceInfo absenceInfo, @PathVariable int userId){
        AbsenceInfo result = absenceInfoService.createAbscense(absenceInfo,userId);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{userId}")
                .buildAndExpand(result.getId())
                .toUri();
        return ResponseEntity.created(uri).body(result);
    }
}
