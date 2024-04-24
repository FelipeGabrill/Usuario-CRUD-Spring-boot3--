package com.ds.clients.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ds.clients.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{

}
