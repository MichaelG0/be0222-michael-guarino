package com.epicode.m5w1d1.repos;

import java.awt.print.Pageable;
import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.epicode.m5w1d1.model.Reservation;
import com.epicode.m5w1d1.model.User;

public interface ReservationRepository extends PagingAndSortingRepository<Reservation, Long> {
	public Page<Reservation> findByUserAndDate(User user, LocalDate date, Pageable pageable);

}
