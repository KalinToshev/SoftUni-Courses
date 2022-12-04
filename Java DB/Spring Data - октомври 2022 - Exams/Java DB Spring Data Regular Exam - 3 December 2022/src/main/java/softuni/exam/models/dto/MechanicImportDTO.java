package softuni.exam.models.dto;

import com.google.gson.annotations.Expose;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MechanicImportDTO {
    @Expose
    @Email
    @NotNull
    private String email;

    @Expose
    @Size(min = 2)
    @NotNull
    private String firstName;

    @Expose
    @Size(min = 2)
    @NotNull
    private String lastName;

    @Expose
    @Size(min = 2)
    private String phone;
}
