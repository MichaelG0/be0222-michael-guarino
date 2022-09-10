package com.epicode.m5w2d5.runners;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.epicode.m5w2d5.dto.DeviceDto;
import com.epicode.m5w2d5.model.DeviceAvailability;
import com.epicode.m5w2d5.model.DeviceType;
import com.epicode.m5w2d5.services.DeviceService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Order(2)
@Slf4j
@AllArgsConstructor
public class DeviceRunner implements ApplicationRunner {
	private DeviceService deviceSrv;
	private ObjectProvider<DeviceDto> devicePrv;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		log.info("===== SECOND RUNNER =====");
		
		DeviceDto dvc1 = devicePrv.getObject();
		dvc1.setType(DeviceType.LAPTOP);
		dvc1.setAvailability(DeviceAvailability.AVAILABLE);
		deviceSrv.create(dvc1);
		
		DeviceDto dvc2 = devicePrv.getObject();
		dvc2.setType(DeviceType.SMARTPHONE);
		dvc2.setAvailability(DeviceAvailability.UNDER_MAINTENANCE);
		deviceSrv.create(dvc2);
		
		DeviceDto dvc3 = devicePrv.getObject();
		dvc3.setType(DeviceType.TABLET);
		dvc3.setAvailability(DeviceAvailability.DISUSED);
		deviceSrv.create(dvc3);
		
		DeviceDto dvc4 = devicePrv.getObject();
		dvc4.setType(DeviceType.TABLET);
		dvc4.setAvailability(DeviceAvailability.AVAILABLE);
		deviceSrv.create(dvc4);
		
		DeviceDto dvc5 = devicePrv.getObject();
		dvc5.setType(DeviceType.TABLET);
		dvc5.setAvailability(DeviceAvailability.AVAILABLE);
		deviceSrv.create(dvc5);
		
		DeviceDto dvc6 = devicePrv.getObject();
		dvc6.setType(DeviceType.LAPTOP);
		dvc6.setAvailability(DeviceAvailability.AVAILABLE);
		deviceSrv.create(dvc6);
		
		deviceSrv.assignDevice(1l, 1l);
		deviceSrv.assignDevice(2l, 2l);
		deviceSrv.assignDevice(3l, 1l);
		deviceSrv.assignDevice(4l, 2l);
		deviceSrv.assignDevice(5l, 1l);
		deviceSrv.assignDevice(6l, 2l);
	}

}
