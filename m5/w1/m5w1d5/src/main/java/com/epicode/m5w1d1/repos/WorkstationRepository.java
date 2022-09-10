package com.epicode.m5w1d1.repos;

import java.awt.print.Pageable;
import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.epicode.m5w1d1.model.Workstation;
import com.epicode.m5w1d1.model.WsType;

@Repository
public interface WorkstationRepository extends PagingAndSortingRepository<Workstation, Long> {
	public Page<Workstation> findById(Long id, Pageable pageable);

	public Page<Workstation> findBuildingByCityAndType(String city, WsType type, Pageable pageable);

	@Query("SELECT w FROM Workstation w WHERE w.building.city = :city AND w.type = :type AND w.id NOT IN (SELECT r.workstation FROM Reservation r WHERE r.date = :date)")
	public Page<Workstation> findAvailableByCity(String city, WsType type, LocalDate date, Pageable pageable);

}
