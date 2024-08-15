package com.example.IT.support.App.Service;

import com.example.IT.support.App.Exceptions.TechnicienNotFoundException;
import com.example.IT.support.App.Model.TechnicienIT;
import com.example.IT.support.App.Repository.TechnicienITRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TechnicienITService {

    @Autowired
    private TechnicienITRepository technicienITRepository;

    public TechnicienIT registerTechnicien(TechnicienIT technicienIT) {
        return technicienITRepository.save(technicienIT);
    }

    public List<TechnicienIT> getAllTechniciens() {
        return technicienITRepository.findAll();
    }

    public TechnicienIT showTechnicienById(Long id) {
        return technicienITRepository.findById(id)
                .orElseThrow(TechnicienNotFoundException::new);
    }

    public TechnicienIT updateTechnicien(Long idTech, TechnicienIT updatedTechnicien) {
        TechnicienIT technicien =showTechnicienById(idTech);
            technicien.setUsername(updatedTechnicien.getUsername());
            technicien.setEmail(updatedTechnicien.getEmail());
            technicien.setPassword(updatedTechnicien.getPassword());
            return technicienITRepository.save(technicien);

    }

    public void deleteTechnicien(Long id) {
        technicienITRepository.deleteById(id);
    }
}