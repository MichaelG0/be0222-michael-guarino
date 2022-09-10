package com.epicode.m5w2d5.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.epicode.m5w2d5.dto.DeviceDto;

@Configuration
public class DeviceConfiguration {
	@Bean
	@Scope("prototype")
	public DeviceDto newDeviceDto() {
		return new DeviceDto();
	}
}
