//package com.tnsif.College.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import java.util.List;
//
//import com.tnsif.College.entity.College;
//import com.tnsif.College.service.CollegeService;
//
//import jakarta.persistence.NoResultException;
//
//@RestController
//@RequestMapping("/student")
//public class CollegeController {
//	
//	@Autowired
//	private CollegeService service;
//	
//	@GetMapping
//	public List<College> list(){
//		return service.getAll();
//	}
//	
//	@GetMapping("/{id}")
//	public ResponseEntity<College> get(@PathVariable int id){
//		try {
//			College s = service.get(id);
//			return new ResponseEntity<College>(s, HttpStatus.OK);
//		}
//		catch(NoResultException e) {
//			return new ResponseEntity<College>(HttpStatus.NOT_FOUND);
//		}
//	}
//	
//	@PostMapping
//	public void add(@RequestBody College newStudent) {
//		service.save(newStudent);
//	}
//	
//	@PutMapping("/{id}")
//	public ResponseEntity<College> update(@PathVariable int id, @RequestBody College u_s){
//		try {
//			College e_s = service.get(id);
//			e_s.setId(u_s.getId());
//			e_s.setAddress(u_s.getAddress());
//			e_s.setCity(u_s.getCity());
//			e_s.setDept(u_s.getDept());
//			e_s.setDob(u_s.getDob());
//			e_s.setName(u_s.getName());
//			e_s.setReg_no(u_s.getReg_no());
//			service.update(e_s);
//			return new ResponseEntity<College>(e_s,HttpStatus.OK);
//		} catch (NoResultException e) {
//			return new ResponseEntity<College>(HttpStatus.NOT_FOUND);
//		}
//	}
//	
//	@DeleteMapping("/{id}")
//	public void delete(@PathVariable int id) {
//		service.delete(id);
//	}
//
//}









package com.tnsif.College.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

import com.tnsif.College.entity.College;
import com.tnsif.College.service.CollegeService;

@RestController
@RequestMapping("/college")
public class CollegeController {

    @Autowired
    private CollegeService collegeService;

    // Get all colleges
    @GetMapping
    public List<College> getAllColleges() {
        return collegeService.getAllColleges();
    }

    // Get a specific college by ID
    @GetMapping("/{collegeId}")
    public ResponseEntity<College> getCollegeById(@PathVariable int collegeId) {
        College college = collegeService.getCollegeById(collegeId);
        if (college != null) {
            return new ResponseEntity<>(college, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Add a new college
    @PostMapping
    public ResponseEntity<String> addCollege(@RequestBody College newCollege) {
        collegeService.addCollege(newCollege);
        return new ResponseEntity<>("College added successfully!", HttpStatus.CREATED);
    }

    // Update existing college details
    @PutMapping("/{collegeId}")
    public ResponseEntity<College> updateCollege(@PathVariable int collegeId, @RequestBody College updatedCollege) {
        College existingCollege = collegeService.getCollegeById(collegeId);

        if (existingCollege != null) {
            existingCollege.setCollegeName(updatedCollege.getCollegeName());
            existingCollege.setUniversity(updatedCollege.getUniversity());
            existingCollege.setLocation(updatedCollege.getLocation());
            existingCollege.setEstablishedYear(updatedCollege.getEstablishedYear());
            existingCollege.setPrincipalName(updatedCollege.getPrincipalName());
            existingCollege.setContactEmail(updatedCollege.getContactEmail());
            existingCollege.setContactNumber(updatedCollege.getContactNumber());

            collegeService.updateCollege(existingCollege);
            return new ResponseEntity<>(existingCollege, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete a college by ID
    @DeleteMapping("/{collegeId}")
    public ResponseEntity<String> deleteCollege(@PathVariable int collegeId) {
        College existingCollege = collegeService.getCollegeById(collegeId);
        if (existingCollege != null) {
            collegeService.deleteCollege(collegeId);
            return new ResponseEntity<>("College deleted successfully!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("College not found!", HttpStatus.NOT_FOUND);
        }
    }
}
