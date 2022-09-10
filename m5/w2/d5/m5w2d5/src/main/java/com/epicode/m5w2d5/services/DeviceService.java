package com.epicode.m5w2d5.services;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epicode.m5w2d5.auth.users.User;
import com.epicode.m5w2d5.auth.users.UserRepository;
import com.epicode.m5w2d5.dto.DeviceDto;
import com.epicode.m5w2d5.model.Device;
import com.epicode.m5w2d5.model.DeviceAvailability;
import com.epicode.m5w2d5.repositories.DeviceRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DeviceService implements IDeviceService {
	private DeviceRepository deviceRepo;
	private UserRepository userRepo;

	@Override
	public List<Device> findAll() {
		return (List<Device>) deviceRepo.findAll();
	}

	@Override
	public Device findById(Long id) {
		if (!deviceRepo.existsById(id)) {
			throw new EntityNotFoundException("Device not found");
		}
		return deviceRepo.findById(id).get();
	}

	@Override
	public Device create(DeviceDto dvcDto) {
		Device dvc = new Device();
		BeanUtils.copyProperties(dvcDto, dvc);
		deviceRepo.save(dvc);
		return dvc;
	}

	@Override
	public void update(Long id, DeviceDto dvcDto) {
		if (!deviceRepo.existsById(id)) {
			throw new EntityNotFoundException("Device not found");
		}
		Device dvc = deviceRepo.findById(id).get();
		BeanUtils.copyProperties(dvcDto, dvc);
		deviceRepo.save(dvc);
	}

	@Override
	public void delete(Long id) {
		if (!deviceRepo.existsById(id)) {
			throw new EntityNotFoundException("Device not found");
		}
		deviceRepo.deleteById(id);
	}

	@Override
	public void assignDevice(Long deviceId, Long userId) {
		if (!userRepo.existsById(userId)) {
			throw new EntityNotFoundException("User not found");
		}
		Device dvc = this.findById(deviceId);
		User usr = userRepo.findById(userId).get();
		if (dvc.getAvailability() == DeviceAvailability.AVAILABLE) {
			dvc.setUser(usr);
			dvc.setAvailability(DeviceAvailability.ASSIGNED);
			deviceRepo.save(dvc);
		}
	}

}
