package yngridy.Uninter.FinalProject.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yngridy.Uninter.FinalProject.Entity.Consulta;
import yngridy.Uninter.FinalProject.Repository.ConsultaRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;

    public List<Consulta> findAll() {
        return consultaRepository.findAll();
    }

    public Optional<Consulta> findById(Long id) {
        return consultaRepository.findById(id);
    }

    public Consulta save(Consulta consulta) {
        return consultaRepository.save(consulta);
    }

    public void deleteById(Long id) {
        consultaRepository.deleteById(id);
    }

    public List<Consulta> findByDataHoraBetween(Date startDate, Date endDate) {
        return consultaRepository.findByDataHoraBetween(startDate, endDate);
    }
}

