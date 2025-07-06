package yngridy.Uninter.FinalProject.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yngridy.Uninter.FinalProject.Entity.Exame;
import yngridy.Uninter.FinalProject.Repository.ExameRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ExameService {

    @Autowired
    private ExameRepository exameRepository;

    public List<Exame> findAll() {
        return exameRepository.findAll();
    }

    public Optional<Exame> findById(Long id) {
        return exameRepository.findById(id);
    }

    public Exame save(Exame exame) {
        return exameRepository.save(exame);
    }

    public void deleteById(Long id) {
        exameRepository.deleteById(id);
    }
}

