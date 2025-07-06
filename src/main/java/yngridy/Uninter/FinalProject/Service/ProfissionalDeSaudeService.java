package yngridy.Uninter.FinalProject.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yngridy.Uninter.FinalProject.Entity.ProfissionalDeSaude;
import yngridy.Uninter.FinalProject.Repository.ProfissionalDeSaudeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProfissionalDeSaudeService {

    @Autowired
    private ProfissionalDeSaudeRepository profissionalDeSaudeRepository;

    public List<ProfissionalDeSaude> findAll() {
        return profissionalDeSaudeRepository.findAll();
    }

    public Optional<ProfissionalDeSaude> findById(Long id) {
        return profissionalDeSaudeRepository.findById(id);
    }

    public ProfissionalDeSaude save(ProfissionalDeSaude profissional) {
        return profissionalDeSaudeRepository.save(profissional);
    }

    public void deleteById(Long id) {
        profissionalDeSaudeRepository.deleteById(id);
    }
}
