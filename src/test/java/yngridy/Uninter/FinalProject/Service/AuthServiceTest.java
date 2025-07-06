package yngridy.Uninter.FinalProject.Service;

import yngridy.Uninter.FinalProject.Entity.Role;
import yngridy.Uninter.FinalProject.Entity.Usuario;
import yngridy.Uninter.FinalProject.Repository.UsuarioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

// Classe de testes para o serviço de autenticação
@ExtendWith(MockitoExtension.class)
class AuthServiceTest {

    // Mocks das dependências necessárias para os testes
    @Mock
    private UsuarioRepository usuarioRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private JwtService jwtService;

    @Mock
    private AuthenticationManager authenticationManager;

    // Injeção do serviço que será testado
    @InjectMocks
    private AuthService authService;

    // Objeto de usuário que será usado nos testes
    private Usuario usuario;

    // Configuração inicial antes de cada teste
    @BeforeEach
    void setUp() {
        usuario = new Usuario();
        usuario.setId(1L);
        usuario.setNome("Teste Usuario");
        usuario.setEmail("teste@email.com");
        usuario.setSenha("senha123");
        usuario.setRole(Role.USER);
    }

    // Testa o processo de registro de um novo usuário
    @Test
    void register_ShouldSaveNewUser() {
        // Arrange - Prepara os mocks e dados necessários
        when(passwordEncoder.encode(any())).thenReturn("senhaCodificada");

        // Act - Executa o método que está sendo testado
        authService.register(usuario);

        // Assert - Verifica se o comportamento foi o esperado
        verify(usuarioRepository).save(any(Usuario.class));
        verify(passwordEncoder).encode(usuario.getSenha());
    }

    // Testa o processo de login e geração de token
    @Test
    void login_ShouldReturnToken() {
        // Arrange - Prepara os mocks e dados necessários
        when(usuarioRepository.findByEmail(usuario.getEmail())).thenReturn(Optional.of(usuario));
        when(jwtService.generateToken(any(Usuario.class))).thenReturn("jwt-token");

        // Act - Executa o método que está sendo testado
        String token = authService.login(usuario);

        // Assert - Verifica se o comportamento foi o esperado
        verify(authenticationManager).authenticate(any(UsernamePasswordAuthenticationToken.class));
        verify(usuarioRepository).findByEmail(usuario.getEmail());
        verify(jwtService).generateToken(usuario);
        assert token.equals("jwt-token");
    }
} 