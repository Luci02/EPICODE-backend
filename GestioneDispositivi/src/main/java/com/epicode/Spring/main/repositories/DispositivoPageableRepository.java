package com.epicode.Spring.main.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.epicode.Spring.main.models.Dispositivo;

public interface DispositivoPageableRepository extends PagingAndSortingRepository<Dispositivo, Long> { }
