package app.controller;

import app.model.dtos.BasicCameraDto;
import app.model.dtos.PhotographerDto;
import app.parser.impl.JSONSerializer;
import app.service.api.PhotographerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.io.IOException;

@Component
@Controller
public class PhotographerController {
    private final static String PHOTOGRAPHER_JSON_PATH = "E:\\Softuni\\07. Java_DB\\DB Frameworks\\10.ExamPreparation\\16.DB-Advanced-Exam-Preparation-1-Skeleton\\src\\main\\resources\\files\\json\\photographers.json";
    private PhotographerService photographerService;
    private JSONSerializer jsonSerializer;

    @Autowired
    public PhotographerController(PhotographerService photographerService,JSONSerializer jsonSerializer) {
        this.photographerService = photographerService;
        this.jsonSerializer = jsonSerializer;
    }

    public void importPhotographers() throws IOException {
        PhotographerDto[] deserialized = this.jsonSerializer
                .deserialize(PhotographerDto[].class,PHOTOGRAPHER_JSON_PATH);
        this.photographerService.createMany(deserialized);
    }


}
