package com.epicode.m5w1d1.services;

import javax.persistence.EntityNotFoundException;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.epicode.m5w1d1.model.Reservation;
import com.epicode.m5w1d1.repos.ReservationRepository;

@Service
public class ReservationService implements IReservationService {
	private ReservationRepository resRepo;

	@Override
	public Page<Reservation> findAll(Pageable pageable) {
		return resRepo.findAll(pageable);
	}

	@Override
	public Reservation findById(Long id) {
		if(!resRepo.existsById(id)) {
			throw new EntityNotFoundException("Libro non trovato");
		}
		return resRepo.findById(id).get();
	}

	@Override
	public void create(Reservation res) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Reservation res) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub

	}

}
