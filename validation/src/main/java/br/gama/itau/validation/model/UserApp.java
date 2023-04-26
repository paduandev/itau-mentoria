package br.gama.itau.validation.model;

import br.gama.itau.validation.dto.UserAppDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class UserApp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    @NotBlank(message = "O nome é obrigatório")
    private String name;
    
    @NotBlank(message = "O e-mail é obrigatório")
    @Email(message = "O e-mail deve ser válido")
    private String email;

    private String password;

    public UserApp(UserAppDTO userAppDTO) {
        this.name = userAppDTO.getName();
        this.email = userAppDTO.getEmail();
        this.password = userAppDTO.getPassword();
    }

}
