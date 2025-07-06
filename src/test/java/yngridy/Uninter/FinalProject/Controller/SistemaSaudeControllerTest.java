package yngridy.Uninter.FinalProject.Controller;

import yngridy.Uninter.FinalProject.Entity.*;
import yngridy.Uninter.FinalProject.Service.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SistemaSaudeControllerTest {

    @Mock
    private PacienteService pacienteService;

    @Mock
    private PrescricaoService prescricaoService;

    @Mock
    private ConsultaService consultaService;

    @Mock
    private ExameService exameService;

    @Mock
    private ProfissionalDeSaudeService profissionalDeSaudeService;

    @InjectMocks
    private SistemaSaudeController controller;

    private Paciente paciente;
    private Prescricao prescricao;
    private Consulta consulta;
    private Exame exame;
    private ProfissionalDeSaude profissional;

    @BeforeEach
    void setUp() {
        // Inicializa objetos de teste
        paciente = new Paciente();
        paciente.setId(1L);
        paciente.setNome("Paciente Teste");

        prescricao = new Prescricao();
        prescricao.setId(1L);

        consulta = new Consulta();
        consulta.setId(1L);

        exame = new Exame();
        exame.setId(1L);

        profissional = new ProfissionalDeSaude();
        profissional.setId(1L);
        profissional.setNome("Profissional Teste");
    }

    @Test
    void listarPacientes_ShouldReturnList() {
        // Arrange
        when(pacienteService.findAll()).thenReturn(Arrays.asList(paciente));

        // Act
        List<Paciente> result = controller.listarPacientes();

        // Assert
        assertNotNull(result);
        assertEquals(1, result.size());
        verify(pacienteService).findAll();
    }

    @Test
    void criarPaciente_ShouldSaveAndReturnPaciente() {
        // Arrange
        when(pacienteService.save(any(Paciente.class))).thenReturn(paciente);

        // Act
        Paciente result = controller.criarPaciente(paciente);

        // Assert
        assertNotNull(result);
        assertEquals(paciente.getId(), result.getId());
        verify(pacienteService).save(paciente);
    }

    @Test
    void obterPaciente_ShouldReturnPaciente() {
        // Arrange
        when(pacienteService.findById(1L)).thenReturn(Optional.of(paciente));

        // Act
        Paciente result = controller.obterPaciente(1L);

        // Assert
        assertNotNull(result);
        assertEquals(paciente.getId(), result.getId());
        verify(pacienteService).findById(1L);
    }

    @Test
    void deletarPaciente_ShouldCallService() {
        // Act
        controller.deletarPaciente(1L);

        // Assert
        verify(pacienteService).deleteById(1L);
    }

    @Test
    void atualizarPaciente_ShouldUpdateAndReturnPaciente() {
        // Arrange
        when(pacienteService.save(any(Paciente.class))).thenReturn(paciente);

        // Act
        Paciente result = controller.atualizarPaciente(1L, paciente);

        // Assert
        assertNotNull(result);
        assertEquals(paciente.getId(), result.getId());
        verify(pacienteService).save(paciente);
    }
} 