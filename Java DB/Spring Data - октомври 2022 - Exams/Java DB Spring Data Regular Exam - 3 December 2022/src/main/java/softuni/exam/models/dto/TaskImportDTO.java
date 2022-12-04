package softuni.exam.models.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@XmlRootElement(name = "task")
@XmlAccessorType(XmlAccessType.FIELD)
public class TaskImportDTO {
    @XmlElement(name = "date")
    @NotNull
    private String date;

    @XmlElement(name = "price")
    @NotNull
    @Positive
    private Double price;

    @XmlElement(name = "car")
    @NotNull
    private CarIdDTO carId;

    @XmlElement(name = "mechanic")
    @NotNull
    private MechanicNameDTO name;

    @XmlElement(name = "part")
    @NotNull
    private PartIdDTO partId;
}
