package yngridy.Uninter.FinalProject.Controller;

import yngridy.Uninter.FinalProject.Entity.*;
import yngridy.Uninter.FinalProject.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SistemaSaudeController {

    @Autowired
    private PacienteService pacienteService;

    @Autowired
    private PrescricaoService prescricaoService;

    @Autowired
    private ConsultaService consultaService;

    @Autowired
    private ExameService exameService;

    @Autowired
    private ProfissionalDeSaudeService profissionalDeSaudeService;

    // ====================== Paciente ======================

    @GetMapping("/pacientes")
    public List<Paciente> listarPacientes() {
        return pacienteService.findAll();
    }

    @PostMapping("/pacientes")
    public Paciente criarPaciente(@RequestBody Paciente paciente) {
        return pacienteService.save(paciente);
    }

    @GetMapping("/pacientes/{id}")
    public Paciente obterPaciente(@PathVariable Long id) {
        return pacienteService.findById(id).orElse(null);
    }

    @DeleteMapping("/pacientes/{id}")
    public void deletarPaciente(@PathVariable Long id) {
        pacienteService.deleteById(id);
    }

    @PutMapping("/pacientes/{id}")
    public Paciente atualizarPaciente(@PathVariable Long id, @RequestBody Paciente pacienteAtualizado) {
        pacienteAtualizado.setId(id);
        return pacienteService.save(pacienteAtualizado);
    }

    // ====================== Prescrição ======================

    @GetMapping("/prescricoes")
    public List<Prescricao> listarPrescricoes() {
        return prescricaoService.findAll();
    }

    @PostMapping("/prescricoes")
    public Prescricao criarPrescricao(@RequestBody Prescricao prescricao) {
        return prescricaoService.save(prescricao);
    }

    @GetMapping("/prescricoes/{id}")
    public Prescricao obterPrescricao(@PathVariable Long id) {
        return prescricaoService.findById(id).orElse(null);
    }

    @DeleteMapping("/prescricoes/{id}")
    public void deletarPrescricao(@PathVariable Long id) {
        prescricaoService.deleteById(id);
    }

    @PutMapping("/prescricoes/{id}")
    public Prescricao atualizarPrescricao(@PathVariable Long id, @RequestBody Prescricao prescricaoAtualizada) {
        prescricaoAtualizada.setId(id);
        return prescricaoService.save(prescricaoAtualizada);
    }

    // ====================== Consulta ======================

    @GetMapping("/consultas")
    public List<Consulta> listarConsultas() {
        return consultaService.findAll();
    }

    @PostMapping("/consultas")
    public Consulta criarConsulta(@RequestBody Consulta consulta) {
        return consultaService.save(consulta);
    }

    @GetMapping("/consultas/{id}")
    public Consulta obterConsulta(@PathVariable Long id) {
        return consultaService.findById(id).orElse(null);
    }

    @DeleteMapping("/consultas/{id}")
    public void deletarConsulta(@PathVariable Long id) {
        consultaService.deleteById(id);
    }

    @PutMapping("/consultas/{id}")
    public Consulta atualizarConsulta(@PathVariable Long id, @RequestBody Consulta consultaAtualizada) {
        consultaAtualizada.setId(id);
        return consultaService.save(consultaAtualizada);
    }

    // ====================== Exame ======================

    @GetMapping("/exames")
    public List<Exame> listarExames() {
        return exameService.findAll();
    }

    @PostMapping("/exames")
    public Exame criarExame(@RequestBody Exame exame) {
        return exameService.save(exame);
    }

    @GetMapping("/exames/{id}")
    public Exame obterExame(@PathVariable Long id) {
        return exameService.findById(id).orElse(null);
    }

    @DeleteMapping("/exames/{id}")
    public void deletarExame(@PathVariable Long id) {
        exameService.deleteById(id);
    }

    @PutMapping("/exames/{id}")
    public Exame atualizarExame(@PathVariable Long id, @RequestBody Exame exameAtualizado) {
        exameAtualizado.setId(id);
        return exameService.save(exameAtualizado);
    }

    // ====================== Profissional de Saúde ======================

    @GetMapping("/profissionais")
    public List<ProfissionalDeSaude> listarProfissionais() {
        return profissionalDeSaudeService.findAll();
    }

    @PostMapping("/profissionais")
    public ProfissionalDeSaude criarProfissional(@RequestBody ProfissionalDeSaude profissional) {
        return profissionalDeSaudeService.save(profissional);
    }

    @GetMapping("/profissionais/{id}")
    public ProfissionalDeSaude obterProfissional(@PathVariable Long id) {
        return profissionalDeSaudeService.findById(id).orElse(null);
    }

    @DeleteMapping("/profissionais/{id}")
    public void deletarProfissional(@PathVariable Long id) {
        profissionalDeSaudeService.deleteById(id);
    }

    @PutMapping("/profissionais/{id}")
    public ProfissionalDeSaude atualizarProfissional(@PathVariable Long id, @RequestBody ProfissionalDeSaude profissionalAtualizado) {
        profissionalAtualizado.setId(id);
        return profissionalDeSaudeService.save(profissionalAtualizado);
    }
}
