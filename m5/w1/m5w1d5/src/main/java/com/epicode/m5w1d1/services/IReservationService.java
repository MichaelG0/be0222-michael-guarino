package com.epicode.m5w1d1.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.epicode.m5w1d1.model.Reservation;

public interface IReservationService {
	public Page<Reservation> findAll(Pageable pageable);
	
	public Reservation findById(Long id);
	
	public void create(Reservation res);
	
	public void update(Reservation res);
	
	public void delete(Long id);
	
}
