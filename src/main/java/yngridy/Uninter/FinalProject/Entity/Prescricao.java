package yngridy.Uninter.FinalProject.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Prescricao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String medicamento;
    private String dosagem;
    private String orientacao;

    @ManyToOne
    @JoinColumn(name = "profissional_id")
    @JsonBackReference(value = "profissional-prescricoes")
    private ProfissionalDeSaude profissional;

    @ManyToOne
    @JoinColumn(name = "paciente_id")
    @JsonBackReference(value = "paciente-prescricoes")
    private Paciente paciente;
}
