package app.dtos;

import java.util.List;

public class ManagerDto extends BasicDto {
    private List<EmployeeDto> servants;

    public List<EmployeeDto> getServants() {
        return this.servants;
    }

    public void setServants(List<EmployeeDto> servants) {
        this.servants = servants;
    }
}
