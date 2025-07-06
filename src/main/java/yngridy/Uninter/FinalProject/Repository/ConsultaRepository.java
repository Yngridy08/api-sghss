package yngridy.Uninter.FinalProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import yngridy.Uninter.FinalProject.Entity.Consulta;

import java.util.Date;
import java.util.List;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
    List<Consulta> findByDataHoraBetween(Date startDate, Date endDate);  
}

