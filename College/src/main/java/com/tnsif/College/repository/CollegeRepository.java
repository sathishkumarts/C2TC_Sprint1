//package com.tnsif.College.repository;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//
//import com.tnsif.College.entity.College;
//
//public interface CollegeRepository extends JpaRepository<College, Integer> {
//
//}



package com.tnsif.College.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tnsif.College.entity.College;

@Repository
public interface CollegeRepository extends JpaRepository<College, Integer> {

    // You can add custom query methods if needed
    // Example:
    // List<College> findByUniversity(String university);
    // College findByCollegeName(String collegeName);
}
