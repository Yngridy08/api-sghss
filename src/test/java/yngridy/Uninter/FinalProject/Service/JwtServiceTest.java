package yngridy.Uninter.FinalProject.Service;

import yngridy.Uninter.FinalProject.Entity.Role;
import yngridy.Uninter.FinalProject.Entity.Usuario;
import io.jsonwebtoken.Claims;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.core.userdetails.UserDetails;

import static org.junit.jupiter.api.Assertions.*;

// Classe de testes para o serviço de geração e validação de tokens JWT
class JwtServiceTest {

    // Instância do serviço JWT que será testado
    private JwtService jwtService;
    
    // Objeto de usuário que será usado nos testes
    private Usuario usuario;

    // Configuração inicial antes de cada teste
    @BeforeEach
    void setUp() {
        jwtService = new JwtService();
        usuario = new Usuario();
        usuario.setId(1L);
        usuario.setEmail("teste@email.com");
        usuario.setRole(Role.USER);
    }

    // Testa se o token JWT é gerado corretamente
    @Test
    void generateToken_ShouldCreateValidToken() {
        // Act - Gera o token
        String token = jwtService.generateToken(usuario);

        // Assert - Verifica se o token foi gerado corretamente
        assertNotNull(token);
        assertTrue(token.length() > 0);
    }

    // Testa se o email do usuário é extraído corretamente do token
    @Test
    void extractUsername_ShouldReturnEmail() {
        // Arrange - Gera um token para o usuário
        String token = jwtService.generateToken(usuario);

        // Act - Extrai o username do token
        String username = jwtService.extractUsername(token);

        // Assert - Verifica se o email extraído corresponde ao do usuário
        assertEquals(usuario.getEmail(), username);
    }

    // Testa se um token válido é reconhecido como válido
    @Test
    void isTokenValid_ShouldReturnTrueForValidToken() {
        // Arrange - Gera um token válido
        String token = jwtService.generateToken(usuario);

        // Act - Verifica a validade do token
        boolean isValid = jwtService.isTokenValid(token, usuario);

        // Assert - Verifica se o token é reconhecido como válido
        assertTrue(isValid);
    }

    // Testa se um token é reconhecido como inválido para um usuário diferente
    @Test
    void isTokenValid_ShouldReturnFalseForInvalidUser() {
        // Arrange - Gera um token e cria um usuário diferente
        String token = jwtService.generateToken(usuario);
        Usuario differentUser = new Usuario();
        differentUser.setEmail("outro@email.com");

        // Act - Verifica a validade do token para o usuário diferente
        boolean isValid = jwtService.isTokenValid(token, differentUser);

        // Assert - Verifica se o token é reconhecido como inválido
        assertFalse(isValid);
    }
} 