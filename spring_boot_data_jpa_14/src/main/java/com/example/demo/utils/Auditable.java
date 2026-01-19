package com.example.demo.utils;

import java.time.LocalDateTime;

import org.springframework.data.annotation.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@EntityListeners(value = AuditingEntityListener.class)
@MappedSuperclass

@Data
public abstract class Auditable {

	
	@CreatedDate
	private LocalDateTime createDate;
	
	@LastModifiedDate
	private LocalDateTime modifiedDate;
	
	@CreatedBy
	private String createdBy;

}
