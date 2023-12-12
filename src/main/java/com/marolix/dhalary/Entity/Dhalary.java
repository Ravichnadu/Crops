package com.marolix.dhalary.Entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dhalary {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private String quantity;
	
	private String transpotation;
	
	private String location;
	
	private String mobile;
	
	@ManyToMany(cascade = CascadeType.REMOVE,mappedBy = "dhalaries")
	@JsonBackReference
	private List<Crops> crops;
}
