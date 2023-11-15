package ayoub.rakine.exam.services;

import java.util.List;

import ayoub.rakine.exam.dao.IDao;
import ayoub.rakine.exam.entities.Employe;
import ayoub.rakine.exam.entities.Servicee;
import ayoub.rakine.exam.repository.EmployeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;



@Service
public class EmployeService implements IDao<Employe> {
    @Autowired
    private EmployeRepository employeRepository;



    @Override
    public Employe create(Employe o) {
        return employeRepository.save(o);
    }

    @Override
    public boolean delete(Employe o) {
        try {
            employeRepository.delete(o);
            return true;
        }
        catch(Exception ex) {
            return false;
        }
    }

    @Override
    public Employe update(Long id, Employe o) {
        Employe existingEmploye = employeRepository.findById(id).orElse(null);

        if (existingEmploye != null) {
            try {
                existingEmploye.setNom(o.getNom());
                existingEmploye.setPrenom(o.getPrenom());
                existingEmploye.setDateNaissance(o.getDateNaissance());
                existingEmploye.setPhoto(o.getPhoto());
                existingEmploye.setChef(existingEmploye.getChef());;
                existingEmploye.setService(existingEmploye.getService());
                return employeRepository.save(existingEmploye);
            } catch (DataAccessException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<Employe> findAll() {

        return employeRepository.findAll();
    }

    @Override
    public Employe findById(Long id) {
        return employeRepository.findById(id).orElse(null);
    }


    public List<Employe> FindEmployeesByService(Servicee service){
        return employeRepository.findByService(service);
    }
}
