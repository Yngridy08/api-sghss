package yngridy.Uninter.FinalProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import yngridy.Uninter.FinalProject.Entity.Exame;

@Repository
public interface ExameRepository extends JpaRepository<Exame, Long> {
    
}
