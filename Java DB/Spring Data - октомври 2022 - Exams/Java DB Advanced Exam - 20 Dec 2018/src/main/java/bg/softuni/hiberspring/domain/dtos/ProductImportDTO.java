package bg.softuni.hiberspring.domain.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "product")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductImportDTO {
    @XmlAttribute
    @NotNull
    private String name;

    @XmlAttribute
    @NotNull
    private Integer clients;

    @XmlElement
    @NotNull
    private String branch;
}
