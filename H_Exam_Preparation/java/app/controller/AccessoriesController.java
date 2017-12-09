package app.controller;

import app.model.dtos.AccessoriesRootDto;
import app.parser.impl.XMLFileParser;
import app.service.api.AccessoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import javax.xml.bind.JAXBException;

@Component
@Controller
public class AccessoriesController {
    private final static String ACCESSORIES_PATH = "E:\\Softuni\\07. Java_DB\\DB Frameworks\\10.ExamPreparation\\16.DB-Advanced-Exam-Preparation-1-Skeleton\\src\\main\\resources\\files\\xml\\accessories.xml";
    private AccessoriesService accessoriesService;
    private XMLFileParser xmlFileParser;

    @Autowired
    public AccessoriesController(AccessoriesService accessoriesService, XMLFileParser xmlFileParser) {
        this.accessoriesService = accessoriesService;
        this.xmlFileParser = xmlFileParser;
    }

    public void importXml() throws JAXBException {
        AccessoriesRootDto rootDto = this.xmlFileParser
                .deserialize(AccessoriesRootDto.class,ACCESSORIES_PATH);
        this.accessoriesService.createMany(rootDto.getDtoList());
    }
}
