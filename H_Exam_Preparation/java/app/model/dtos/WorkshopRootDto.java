package app.model.dtos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "workshops")
@XmlAccessorType(XmlAccessType.FIELD)
public class WorkshopRootDto {
    @XmlElement(name = "workshop")
    private WorkshopDto[] workshops;

    public WorkshopRootDto() {
    }

    public WorkshopDto[] getWorkshops() {
        return this.workshops;
    }

    public void setWorkshops(WorkshopDto[] workshops) {
        this.workshops = workshops;
    }
}
