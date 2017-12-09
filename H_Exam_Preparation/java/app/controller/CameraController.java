package app.controller;

import app.model.dtos.BasicCameraDto;
import app.parser.impl.JSONSerializer;
import app.service.impl.CameraServiceImpl;
import app.service.api.CameraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import java.io.IOException;

@Component
@Controller
public class CameraController {
    private final static String CAMERA_JSON_PATH = "E:\\Softuni\\07. Java_DB\\DB Frameworks\\10.ExamPreparation\\16.DB-Advanced-Exam-Preparation-1-Skeleton\\src\\main\\resources\\files\\json\\cameras.json";
    private CameraService cameraService;
    private JSONSerializer jsonSerializer;

    @Autowired
    public CameraController(CameraServiceImpl cameraService,JSONSerializer jsonSerializer) {
        this.cameraService = cameraService;
        this.jsonSerializer = jsonSerializer;
    }

    public void importCameras() throws IOException {
        BasicCameraDto[] deserialized = this.jsonSerializer
                .deserialize(BasicCameraDto[].class,CAMERA_JSON_PATH);
        this.cameraService.createMany(deserialized);
    }
}
