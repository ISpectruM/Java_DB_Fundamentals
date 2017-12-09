package app.service.api;

import app.model.dtos.PhotographerDto;
import app.model.entities.Photographer;

public interface PhotographerService {
    void create(Photographer photographer);

    void createMany(PhotographerDto[] dto);
}
