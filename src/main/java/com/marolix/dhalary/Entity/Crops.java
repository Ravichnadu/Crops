package com.marolix.dhalary.Entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.annotation.Generated;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Crops {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String cropName;
	
	private String price;
	
	private String type;
	
	@Lob
	@Column(columnDefinition = "BLOB")
	private String image;
	
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE },targetEntity = Dhalary.class)
	@JoinTable(name = "crops_dhalaries",
	joinColumns = {@JoinColumn(name="crop_id",referencedColumnName = "id")},
	inverseJoinColumns = {@JoinColumn(name="dhalary_id",referencedColumnName = "id")})
	@JsonIgnore
	private List<Dhalary> dhalaries;
}
