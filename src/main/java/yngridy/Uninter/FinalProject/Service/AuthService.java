package yngridy.Uninter.FinalProject.Service;

import yngridy.Uninter.FinalProject.Entity.Role;
import yngridy.Uninter.FinalProject.Entity.Usuario;
import yngridy.Uninter.FinalProject.Repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

// Serviço responsável por gerenciar a autenticação e registro de usuários
@Service
@RequiredArgsConstructor
public class AuthService {
    
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    // Registra um novo usuário no sistema, codificando a senha e definindo a role padrão
    public void register(Usuario request) {
        var usuario = new Usuario();
        usuario.setNome(request.getNome());
        usuario.setEmail(request.getEmail());
        usuario.setSenha(passwordEncoder.encode(request.getSenha()));
        usuario.setRole(Role.USER);
        
        usuarioRepository.save(usuario);
    }

    // Realiza o login do usuário, autenticando as credenciais e gerando um token JWT
    public String login(Usuario request) {
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                request.getEmail(),
                request.getSenha()
            )
        );
        
        var usuario = usuarioRepository.findByEmail(request.getEmail())
            .orElseThrow();
            
        return jwtService.generateToken(usuario);
    }
} 