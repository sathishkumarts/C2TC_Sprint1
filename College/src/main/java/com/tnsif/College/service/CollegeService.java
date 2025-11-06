//package com.tnsif.College.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.tnsif.College.entity.College;
//import com.tnsif.College.repository.CollegeRepository;
//
//import java.util.List;
//
//@Service
//public class CollegeService {
//	
//	@Autowired
//	private CollegeRepository repo;
//	
//	public List<College> getAll(){
//		return repo.findAll();		
//	}
//	
//	public College get(int id) {
//		return repo.findById(id).get();
//	}
//	
//	public void save( College s) {
//		repo.save(s);
//	}
//	
//	public void update(College s) {
//		repo.save(s);
//	}
//	
//	public void delete(int id) {
//		repo.deleteById(id);
//	}
//
//}






package com.tnsif.College.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import com.tnsif.College.entity.College;
import com.tnsif.College.repository.CollegeRepository;

@Service
public class CollegeService {

    @Autowired
    private CollegeRepository collegeRepository;

    // Get all colleges
    public List<College> getAllColleges() {
        return collegeRepository.findAll();
    }

    // Get college by ID
    public College getCollegeById(int collegeId) {
        Optional<College> college = collegeRepository.findById(collegeId);
        return college.orElse(null);
    }

    // Add a new college
    public void addCollege(College college) {
        collegeRepository.save(college);
    }

    // Update an existing college
    public void updateCollege(College college) {
        collegeRepository.save(college);
    }

    // Delete a college by ID
    public void deleteCollege(int collegeId) {
        collegeRepository.deleteById(collegeId);
    }
}
