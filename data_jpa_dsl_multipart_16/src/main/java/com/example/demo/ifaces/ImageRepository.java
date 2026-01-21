package com.example.demo.ifaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.CustomerImage;

public interface ImageRepository extends JpaRepository<CustomerImage, Integer> {

}
