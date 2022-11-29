package softuni.exam.models.dto;

import softuni.exam.service.impl.AgentName;
import softuni.exam.service.impl.ApartmentIdDto;

import javax.validation.constraints.Positive;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

@XmlRootElement(name = "offer")
@XmlAccessorType(XmlAccessType.FIELD)
public class OfferImportDTO {
    @XmlElement(name = "price")
    @Positive
    private BigDecimal price;
    @XmlElement(name = "agent")
    private AgentName name;
    @XmlElement(name = "apartment")
    private ApartmentIdDto apartment;
    @XmlElement(name = "publishedOn")
    private String publishedOn;

    public OfferImportDTO() {
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public AgentName getName() {
        return name;
    }

    public void setName(AgentName name) {
        this.name = name;
    }

    public ApartmentIdDto getApartment() {
        return apartment;
    }

    public void setApartment(ApartmentIdDto apartment) {
        this.apartment = apartment;
    }

    public String getPublishedOn() {
        return publishedOn;
    }

    public void setPublishedOn(String publishedOn) {
        this.publishedOn = publishedOn;
    }
}
