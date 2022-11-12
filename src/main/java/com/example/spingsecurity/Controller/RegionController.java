package com.example.spingsecurity.Controller;

import com.example.spingsecurity.model.Region;
import com.example.spingsecurity.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/region")
public class RegionController {

    private RegionService regionService;

    @Autowired
    public RegionController(RegionService regionService) {
        this.regionService = regionService;
    }

    @GetMapping
    public ResponseEntity<List<Region>> getAll(){
        return new ResponseEntity<>(regionService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Region> getById(@PathVariable Long id){
        return new ResponseEntity<>(regionService.getById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Region> create(@RequestBody Region region){
        return new ResponseEntity<>(regionService.create(region), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Region> update(@PathVariable Long id, @RequestBody Region region){
        return new ResponseEntity<>(regionService.update(id, region), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Region> delete(@PathVariable Long id){
        return new ResponseEntity<>(regionService.delete(id), HttpStatus.OK);
    }
}
