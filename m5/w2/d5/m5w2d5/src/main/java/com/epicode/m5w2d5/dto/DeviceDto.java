package com.epicode.m5w2d5.dto;

import com.epicode.m5w2d5.model.DeviceAvailability;
import com.epicode.m5w2d5.model.DeviceType;

import lombok.Data;

@Data
public class DeviceDto {
	private DeviceType type;
	private DeviceAvailability availability;
}
