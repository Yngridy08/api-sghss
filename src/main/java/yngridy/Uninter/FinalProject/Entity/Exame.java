package yngridy.Uninter.FinalProject.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Exame {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "paciente_id")
    @JsonBackReference(value = "paciente-exames")
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "consulta_id")
    @JsonBackReference(value = "consulta-exames")
    private Consulta consulta;

    @ManyToOne
    @JoinColumn(name = "profissional_id")
    @JsonBackReference(value = "profissional-exames")
    private ProfissionalDeSaude profissional;
}
