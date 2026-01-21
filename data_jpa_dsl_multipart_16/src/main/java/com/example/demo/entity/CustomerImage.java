package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor


@Entity
@Table(name = "customer_with_pictures")
public class CustomerImage {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "content_type",length = 30)
	private String contentType;
	
	@Column(name = "file_name",length = 30)
	
	private String fileName;
	
	
	
	@Lob
	@Column(name = "image_ref")
	private byte[] imageRef;



	public CustomerImage(String contentType, String fileName, byte[] imageRef) {
		super();
		this.contentType = contentType;
		this.fileName = fileName;
		this.imageRef = imageRef;
	}
	
	
}
