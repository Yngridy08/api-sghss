package yngridy.Uninter.FinalProject.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class ProfissionalDeSaude {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String especialidade;
    private String crm;
    private String telefone;

    @OneToMany(mappedBy = "profissional", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties({"profissional"})
    private List<Consulta> consultas;

    @OneToMany(mappedBy = "profissional", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference(value = "profissional-prescricoes")
    private List<Prescricao> prescricoes;

    @OneToMany(mappedBy = "profissional", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference(value = "profissional-exames")
    private List<Exame> exames;
}
