package com.springboot.app.models.service;

import com.springboot.app.models.dao.IClienteDao;
import com.springboot.app.models.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class IClienteServiceImpl implements IClienteService {

    @Autowired
    private IClienteDao iClienteDao;

    @Override
    @Transactional (readOnly = true)
    public List<Cliente> finAll() {
        return (List<Cliente>) iClienteDao.findAll();
    }

    @Override
    @Transactional (readOnly = true)
    public Page<Cliente> finAll(Pageable pageable) {
        return iClienteDao.findAll(pageable);
    }

    @Override
    public void save(Cliente cliente) {
        iClienteDao.save(cliente);
    }

    @Override
    public Cliente findOne(Long id) {
        return iClienteDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        iClienteDao.deleteById(id);
    }
}
