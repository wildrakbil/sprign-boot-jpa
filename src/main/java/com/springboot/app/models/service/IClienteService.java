package com.springboot.app.models.service;

import com.springboot.app.models.entity.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;


import java.util.List;

public interface IClienteService {

    public List<Cliente> finAll();
    public Page<Cliente> finAll(Pageable pageable);
    public void save(Cliente cliente);
    public Cliente findOne(Long id);
    public void delete(Long id);
}
