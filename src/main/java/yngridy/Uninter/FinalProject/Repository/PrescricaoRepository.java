package yngridy.Uninter.FinalProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import yngridy.Uninter.FinalProject.Entity.Prescricao;

@Repository
public interface PrescricaoRepository extends JpaRepository<Prescricao, Long> {
    
}
