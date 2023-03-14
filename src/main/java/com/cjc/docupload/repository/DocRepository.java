package com.cjc.docupload.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cjc.docupload.model.Documents;

@Repository
public interface DocRepository extends JpaRepository<Documents, Integer>{

}
