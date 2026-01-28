package com.visionrestro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.visionrestro.entity.ProductSave;
import com.visionrestro.service.ProductSaveService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "https://vision-restro.netlify.app/") // React
public class ProductSaveController {

    @Autowired
    private ProductSaveService saveService;

    // Existing POST
    @PostMapping("/productsave")
    public ProductSave saveData(@RequestBody ProductSave data) {
        return saveService.saveData(data);
    }

    // ✅ PUT endpoint for table transfer
    @PutMapping("/updatetable")
    public ProductSave updateTable(
            @RequestParam String fromTable,
            @RequestParam String toTable
    ) {
        return saveService.updateTableName(fromTable, toTable);
    }
 // ✅ Dashboard active tables
    @GetMapping("/active-tables")
    public List<String> activeTables() {
        return saveService.getActiveTables();
    }
}
