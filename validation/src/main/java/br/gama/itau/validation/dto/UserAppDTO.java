package br.gama.itau.validation.dto;

import br.gama.itau.validation.model.UserApp;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserAppDTO {
    private long id;

    @NotBlank(message = "O nome é obrigatório")
    private String name;
    
    @NotBlank(message = "O e-mail é obrigatório")
    @Email(message = "O e-mail deve ser válido")
    private String email;

    @NotBlank
    @Size(min = 8, message = "A seha deve ter pelo menos 8 caracteres")
    private String password;

    public UserAppDTO(UserApp userApp) {
        this.id = userApp.getId();
        this.name =userApp.getName();
        this.email = userApp.getEmail();
    }

}
