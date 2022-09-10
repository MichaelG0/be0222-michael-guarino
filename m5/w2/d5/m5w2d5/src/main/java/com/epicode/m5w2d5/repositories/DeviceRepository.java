package com.epicode.m5w2d5.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.epicode.m5w2d5.model.Device;

@Repository
public interface DeviceRepository extends CrudRepository<Device, Long> {
	
}
