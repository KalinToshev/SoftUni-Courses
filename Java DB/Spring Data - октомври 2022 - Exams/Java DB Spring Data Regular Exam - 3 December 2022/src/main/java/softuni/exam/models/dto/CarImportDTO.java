package softuni.exam.models.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import softuni.exam.models.entity.enums.CarType;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@XmlRootElement(name = "car")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarImportDTO {
    @XmlElement(name = "carMake")
    @NotNull
    @Size(min = 2, max = 30)
    private String carMake;

    @XmlElement(name = "carModel")
    @NotNull
    @Size(min = 2, max = 30)
    private String carModel;

    @XmlElement(name = "year")
    @NotNull
    @Positive
    private Integer year;

    @XmlElement(name = "plateNumber")
    @NotNull
    @Size(min = 2, max = 30)
    private String plateNumber;

    @XmlElement(name = "kilometers")
    @NotNull
    @Positive
    private Integer kilometers;

    @XmlElement(name = "engine")
    @NotNull
    @Min(1)
    private Double engine;

    @XmlElement(name = "carType")
    @NotNull
    private CarType carType;
}
