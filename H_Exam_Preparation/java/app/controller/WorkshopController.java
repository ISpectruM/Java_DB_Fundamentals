package app.controller;

import app.model.dtos.AccessoriesRootDto;
import app.model.dtos.WorkshopRootDto;
import app.parser.impl.XMLFileParser;
import app.service.api.WorkShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.xml.bind.JAXBException;

@Controller
public class WorkshopController {
    private final static String WORKSHOPS_PATH = "E:\\Softuni\\07. Java_DB\\DB Frameworks\\10.ExamPreparation\\16.DB-Advanced-Exam-Preparation-1-Skeleton\\src\\main\\resources\\files\\xml\\workshops.xml";

    private WorkShopService workShopService;
    private XMLFileParser fileParser;

    @Autowired
    public WorkshopController(WorkShopService workShopService, XMLFileParser fileParser) {
        this.workShopService = workShopService;
        this.fileParser = fileParser;
    }

    public void importXml() throws JAXBException {
        WorkshopRootDto rootDto = this.fileParser
                .deserialize(WorkshopRootDto.class,WORKSHOPS_PATH);
        this.workShopService.createMany(rootDto.getWorkshops());
    }

}
