package com.ds.clients.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ds.clients.dto.ClientDTO;
import com.ds.clients.entities.Client;
import com.ds.clients.repositories.ClientRepository;
import com.ds.clients.services.exceptions.DatabaseException;
import com.ds.clients.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ClientService {

	@Autowired
	private ClientRepository repository;
	
	@Transactional(readOnly = true)
	public ClientDTO findById(Long id) {
		Client user = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado"));
		return new ClientDTO(user);
	}
	
	@Transactional(readOnly = true)
	public Page<ClientDTO> findAll(Pageable pageable) {
		Page<Client> result = repository.findAll(pageable);
		return result.map(x -> new ClientDTO(x));
	}
	
	@Transactional
	public ClientDTO insert(ClientDTO dto) {
		try {
			Client entity = new Client();
			copyDtoEntity(dto, entity);
			entity = repository.save(entity);
			return new ClientDTO(entity);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Cpf já cadastrado");
		}
	}
	
	@Transactional
	public ClientDTO update(Long id, ClientDTO dto) {
		try {
			Client entity = repository.getReferenceById(id);
			copyDtoEntity(dto, entity);
			entity = repository.save(entity);
			return new ClientDTO(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Recurso não encontrado");
		}	
	}
	
	@Transactional
	public void delete(Long id) {
		if (!repository.existsById(id)) {
			throw new ResourceNotFoundException("Recurso não encontrado");
		}
		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Falha de integridade referencial");
		}
	}

	private void copyDtoEntity(ClientDTO dto, Client entity) {
		entity.setName(dto.getName());
		entity.setCpf(dto.getCpf());
		entity.setIncome(dto.getIncome());
		entity.setBirthDate(dto.getBirthDate());
		entity.setChildren(dto.getChildren());
	}
	
}
