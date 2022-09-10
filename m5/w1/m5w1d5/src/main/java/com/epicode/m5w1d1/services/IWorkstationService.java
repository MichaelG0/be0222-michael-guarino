package com.epicode.m5w1d1.services;

import java.util.List;

import com.epicode.m5w1d1.model.Workstation;

public interface IWorkstationService {
	public List<Workstation> findByWorkstationTypeAndCity();
	
}
