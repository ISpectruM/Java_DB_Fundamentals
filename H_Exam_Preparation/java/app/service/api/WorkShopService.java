package app.service.api;


import app.model.dtos.WorkshopDto;
import app.model.entities.Workshop;

public interface WorkShopService {
    void create(Workshop workshop);

    void createMany(WorkshopDto[] dtos);
}
