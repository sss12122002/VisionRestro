package com.visionrestro.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="bookedrecord")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductSave {
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer id;
	 
	 @Column(name = "product_name")
	 private String productName;

	    private Double price;
	    private String uom;
	    private Integer qty;
	    private Double totalAmount;
	    private String tableName;
	    private Double vat;
	    private Double total;
	 
}
