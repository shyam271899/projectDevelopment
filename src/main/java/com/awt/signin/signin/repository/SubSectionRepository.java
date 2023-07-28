package com.awt.signin.signin.repository;

import com.awt.signin.signin.entity.SubSection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubSectionRepository extends JpaRepository<SubSection,Integer> {
    Optional<SubSection> findBySubsectionName(String subsectionName);

    Optional<SubSection> findBySubsectionNameIgnoreCase(String subsectionName);
}
