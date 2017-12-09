package app.service.api;

import app.model.dtos.BasicCameraDto;
import app.model.entities.BasicCamera;

public interface CameraService {
    void create(BasicCamera camera);

    void createMany(BasicCameraDto[] dto);
}
