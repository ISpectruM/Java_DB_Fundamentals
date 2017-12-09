package app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Terminal implements CommandLineRunner {
    private CameraController cameraController;
    private PhotographerController photographerController;
    private AccessoriesController accessoriesController;
    private WorkshopController workshopController;

    @Autowired
    public Terminal(CameraController cameraController, PhotographerController photographerController, AccessoriesController accessoriesController, WorkshopController workshopController) {
        this.cameraController = cameraController;
        this.photographerController = photographerController;
        this.accessoriesController = accessoriesController;
        this.workshopController = workshopController;
    }

    @Override
    public void run(String... args) throws Exception {
//        BasicCamera camera = new DSLRCamera();
//        camera.setMake("asd");
//        camera.setModel("asdasd");
//        camera.setMinIso(120);
//        Photographer photographer = new Photographer();
//        photographer.setFirstName("MyName");
//        photographer.setLastName("SecName");
//        photographer.setPhone("+359/88888888");
//        photographer.setPrimaryCamera(camera);
//        photographer.setSecondaryCamera(camera);
//        this.photographerRepository.save(photographer);
        this.cameraController.importCameras();
        this.photographerController.importPhotographers();
        this.accessoriesController.importXml();
        this.workshopController.importXml();
    }
}
