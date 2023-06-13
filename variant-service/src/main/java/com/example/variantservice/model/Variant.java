package com.example.variantservice.model;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;



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
@Table(name = "Variants")
@Data
@AllArgsConstructor
@NoArgsConstructor
@SQLDelete(sql = "UPDATE Variants SET is_deleted = true WHERE id=id")
@Where(clause = "is_deleted=false")
public class Variant {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="isDeleted")
	private boolean isDeleted= Boolean.FALSE;
	
	
}
