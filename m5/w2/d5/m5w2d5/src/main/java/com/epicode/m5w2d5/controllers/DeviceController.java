package com.epicode.m5w2d5.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epicode.m5w2d5.dto.DeviceDto;
import com.epicode.m5w2d5.model.Device;
import com.epicode.m5w2d5.services.DeviceService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/devices")
public class DeviceController {
	@Autowired
	private DeviceService deviceSrv;

	@GetMapping
	public List<Device> findAll() {
		return deviceSrv.findAll();
	}

	@GetMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Device> findById(@PathVariable Long id) {
		return ResponseEntity.ok(deviceSrv.findById(id));
	}

	@PostMapping
	public ResponseEntity<Device> create(@RequestBody DeviceDto dvcDto) {
		return ResponseEntity.ok(deviceSrv.create(dvcDto));
	}

	@PutMapping("/{id}")
	public ResponseEntity<String> update(@PathVariable Long id, @RequestBody DeviceDto dvcDto) {
		deviceSrv.update(id, dvcDto);
		return ResponseEntity.ok("Device updated successfully");
	}

	@DeleteMapping("/{id}")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		deviceSrv.delete(id);
		return ResponseEntity.ok("Device deleted");
	}

}
