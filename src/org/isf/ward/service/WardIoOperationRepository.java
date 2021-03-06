package org.isf.ward.service;

import java.util.List;

import org.isf.ward.model.Ward;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface WardIoOperationRepository extends JpaRepository<Ward, String> {
    public List<Ward> findAllByOrderByDescriptionAsc();    
    
    @Query(value = "SELECT * FROM WARD WHERE WRD_ID_A <> 'M'", nativeQuery= true)
    public List<Ward> findAllWhereWardIsM();
    
    @Query(value = "SELECT * FROM WARD WHERE WRD_ID_A LIKE :id", nativeQuery= true)
    public List<Ward> findAllWhereIdLike(@Param("id") String id);    
}