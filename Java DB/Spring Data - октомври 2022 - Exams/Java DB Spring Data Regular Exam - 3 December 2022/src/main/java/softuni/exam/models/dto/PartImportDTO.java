package softuni.exam.models.dto;

import com.google.gson.annotations.Expose;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PartImportDTO {
    @Expose
    @Size(min = 2, max = 19)
    @NotNull
    private String partName;

    @Expose
    @Min(10)
    @Max(2000)
    @NotNull
    private Double price;

    @Expose
    @Positive
    @NotNull
    private Integer quantity;
}
