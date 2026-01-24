package com.visionrestro.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.visionrestro.entity.ProductSave;
import com.visionrestro.repository.ProductSaveRepository;

@Service
public class ProductSaveService {

    @Autowired
    private ProductSaveRepository saveRepository;

    // Existing save
    public ProductSave saveData(ProductSave data) {
        return saveRepository.save(data);
    }

    // ✅ Update tableName
    public ProductSave updateTableName(String fromTable, String toTable) {
        Optional<ProductSave> productOpt = saveRepository.findByTableName(fromTable);
        if (productOpt.isPresent()) {
            ProductSave product = productOpt.get();
            product.setTableName(toTable); // column update
            return saveRepository.save(product); // DB me update
        } else {
            throw new RuntimeException("Table not found: " + fromTable);
        }
    }
 // ✅ Dashboard ke liye
    public List<String> getActiveTables() {
        return saveRepository.findAllActiveTables();
    }
}
