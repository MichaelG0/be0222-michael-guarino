package com.epicode.m5w2d5.services;

import java.util.List;

import com.epicode.m5w2d5.dto.DeviceDto;
import com.epicode.m5w2d5.model.Device;

public interface IDeviceService {
	public List<Device> findAll();
	
	public Device findById(Long id);
	
	public Device create(DeviceDto dvcDto);
	
	public void update(Long id, DeviceDto dvcDto);
	
	public void delete(Long id);
	
	public void assignDevice(Long deviceId, Long userId);
}
