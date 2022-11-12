package com.example.spingsecurity.service;


import com.example.spingsecurity.model.Region;
import com.example.spingsecurity.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class RegionService {

    private RegionRepository regionRepository;

    @Autowired
    public RegionService(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

//    Menampilkan semua data
    public List<Region> getAll(){
        return regionRepository.findAll();
    }

//    Menampilkan berdasarkan id
    public Region getById(Long id){
        return regionRepository.findById(id).get();
    }

//    Create
    public Region create(Region region) {
        if (region.getId() != null) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Region already exist");
        }
        if (regionRepository.findByName(region.getName()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Region name already exist");
        }
        return regionRepository.save(region);
    }

    public Region update(Long id, Region region) {
        getById(id);
        region.setId(id);
        return regionRepository.save(region);
    }

    public Region delete(Long id) {
        Region region = getById(id);
        regionRepository.delete(region);
        return region;
    }
}
