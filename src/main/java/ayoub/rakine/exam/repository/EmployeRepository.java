package ayoub.rakine.exam.repository;

import ayoub.rakine.exam.entities.Employe;
import ayoub.rakine.exam.entities.Servicee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeRepository extends JpaRepository<Employe, Long> {
    public List<Employe> findByService(Servicee service);
}

