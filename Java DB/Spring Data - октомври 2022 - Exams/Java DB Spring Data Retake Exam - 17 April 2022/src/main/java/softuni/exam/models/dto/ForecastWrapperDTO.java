package softuni.exam.models.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "forecasts")
@XmlAccessorType(XmlAccessType.FIELD)
public class ForecastWrapperDTO {
    @XmlElement(name = "forecast")
    private List<ForecastImportDTO> forecasts;

    public ForecastWrapperDTO() {
    }

    public List<ForecastImportDTO> getForecasts() {
        return forecasts;
    }

    public void setForecasts(List<ForecastImportDTO> forecasts) {
        this.forecasts = forecasts;
    }
}
