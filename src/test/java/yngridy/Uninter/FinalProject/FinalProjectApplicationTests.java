package yngridy.Uninter.FinalProject;

import yngridy.Uninter.FinalProject.Entity.Role;
import yngridy.Uninter.FinalProject.Entity.Usuario;
import yngridy.Uninter.FinalProject.Repository.UsuarioRepository;
import yngridy.Uninter.FinalProject.Service.AuthService;
import yngridy.Uninter.FinalProject.Service.JwtService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;

// Classe de testes principais da aplicação que verifica a integração dos componentes
@SpringBootTest
class FinalProjectApplicationTests {

	// Injeção das dependências necessárias para os testes
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private AuthService authService;

	@Autowired
	private JwtService jwtService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	// Testa se o contexto da aplicação Spring Boot está carregando corretamente
	@Test
	void contextLoads() {
		// Verifica se o contexto da aplicação carrega corretamente
		assertNotNull(usuarioRepository);
		assertNotNull(authService);
		assertNotNull(jwtService);
		assertNotNull(passwordEncoder);
	}

	// Testa a criação e configuração de um objeto Usuario
	@Test
	void testUsuarioCreation() {
		// Testa a criação de um usuário
		Usuario usuario = new Usuario();
		usuario.setNome("Teste Usuario");
		usuario.setEmail("teste@email.com");
		usuario.setSenha("senha123");
		usuario.setRole(Role.USER);

		assertNotNull(usuario);
		assertEquals("Teste Usuario", usuario.getNome());
		assertEquals("teste@email.com", usuario.getEmail());
		assertEquals(Role.USER, usuario.getRole());
	}

	// Testa o processo de codificação e validação de senhas
	@Test
	void testPasswordEncoding() {
		// Testa a codificação de senha
		String senhaOriginal = "senha123";
		String senhaCodificada = passwordEncoder.encode(senhaOriginal);

		assertNotNull(senhaCodificada);
		assertNotEquals(senhaOriginal, senhaCodificada);
		assertTrue(passwordEncoder.matches(senhaOriginal, senhaCodificada));
	}

	// Testa a geração e validação de tokens JWT
	@Test
	void testJwtTokenGeneration() {
		// Testa a geração de token JWT
		Usuario usuario = new Usuario();
		usuario.setEmail("teste@email.com");
		usuario.setRole(Role.USER);

		String token = jwtService.generateToken(usuario);

		assertNotNull(token);
		assertTrue(token.length() > 0);
		assertEquals(usuario.getEmail(), jwtService.extractUsername(token));
	}
}
