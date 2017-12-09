package app.model.dtos;

import javax.xml.bind.annotation.*;
@XmlRootElement(name = "accessories")
@XmlAccessorType(XmlAccessType.FIELD)
public class AccessoriesRootDto {
    @XmlElement(name = "accessory")
    private AccessoriesDto[] dtoList;

    public AccessoriesRootDto() {
    }

    public AccessoriesDto[] getDtoList() {
        return this.dtoList;
    }

    public void setDtoList(AccessoriesDto[] dtoList) {
        this.dtoList = dtoList;
    }
}
