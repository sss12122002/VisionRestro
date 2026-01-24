package com.visionrestro.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.visionrestro.entity.ProductSave;

public interface ProductSaveRepository extends JpaRepository<ProductSave, Integer>{
	 Optional<ProductSave> findByTableName(String tableName);
	 
	// ✅ Dashboard ke liye active tables
	    @Query("SELECT DISTINCT p.tableName FROM ProductSave p")
	    List<String> findAllActiveTables();
}
