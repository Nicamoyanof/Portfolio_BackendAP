package com.portfolio.portfolio_backendap.services;

import com.portfolio.portfolio_backendap.models.Educaciones;
import com.portfolio.portfolio_backendap.repository.EducacionesRepository;
import com.portfolio.portfolio_backendap.services.IEducaciopnesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducacionesService implements IEducaciopnesService {

    @Autowired
    private EducacionesRepository educacionesRepository;

    @Override
    public List<Educaciones> getEducaciones() {
        return educacionesRepository.findAll();
    }

    @Override
    public Educaciones getEducacion(Integer id) {
        return educacionesRepository.findById(id).orElse(null);
    }

    @Override
    public void agregarEducacion(Educaciones educaciones) {
        educacionesRepository.save(educaciones);
    }

    @Override
    public void eliminarEducacion(Integer id) {
        educacionesRepository.deleteById(id);
    }
}
