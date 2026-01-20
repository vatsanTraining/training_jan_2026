package com.example.demo.utils;

import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.demo.dto.InvoiceDto;
import com.example.demo.entity.Invoice;


@Mapper(componentModel = "spring" ,builder=@Builder(disableBuilder = true))
public interface InvoiceMapper {

	@Mapping(target = "createDate", ignore = true)
	@Mapping(target = "modifiedDate", ignore = true)
	@Mapping(target = "createdBy", ignore = true)
	Invoice toEntity(InvoiceDto dto);
	
	InvoiceDto toDto(Invoice entity);
	
	
	
}
