package ayoub.rakine.exam.services;

import java.util.List;

import ayoub.rakine.exam.dao.IDao;
import ayoub.rakine.exam.entities.Servicee;
import ayoub.rakine.exam.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;



@Service
public class ServiceService implements IDao<Servicee> {
    @Autowired
    private ServiceRepository serviceRepository;



    @Override
    public Servicee create(Servicee o) {
        return serviceRepository.save(o);
    }

    @Override
    public boolean delete(Servicee o) {
        try {
            serviceRepository.delete(o);
            return true;
        }
        catch(Exception ex) {
            return false;
        }
    }

    @Override
    public Servicee update(Long id, Servicee o) {
        Servicee existingService = serviceRepository.findById(id).orElse(null);

        if (existingService != null) {
            try {
                existingService.setNom(o.getNom());
                return serviceRepository.save(existingService);
            } catch (DataAccessException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<Servicee> findAll() {

        return serviceRepository.findAll();
    }

    @Override
    public Servicee findById(Long id) {
        return serviceRepository.findById(id).orElse(null);
    }
}