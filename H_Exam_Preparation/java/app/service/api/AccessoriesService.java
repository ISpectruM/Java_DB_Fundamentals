package app.service.api;

import app.model.dtos.AccessoriesDto;
import app.model.entities.Accessory;

public interface AccessoriesService {

    void create(Accessory accessory);

    void createMany(AccessoriesDto[] dtos);
}
