package yngridy.Uninter.FinalProject.Entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

// Entidade que representa um usuário do sistema, implementando UserDetails para autenticação
@Data
@Entity
@Table(name = "usuarios")
public class Usuario implements UserDetails {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(unique = true)
    private String email;
    private String senha;
    private String nome;
    
    @Enumerated(EnumType.STRING)
    private Role role;

    // Retorna as autoridades (roles) do usuário para controle de acesso
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    // Retorna a senha do usuário para autenticação
    @Override
    public String getPassword() {
        return senha;
    }

    // Retorna o email como nome de usuário para autenticação
    @Override
    public String getUsername() {
        return email;
    }

    // Verifica se a conta não está expirada
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    // Verifica se a conta não está bloqueada
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    // Verifica se as credenciais não estão expiradas
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    // Verifica se a conta está ativa
    @Override
    public boolean isEnabled() {
        return true;
    }
} 