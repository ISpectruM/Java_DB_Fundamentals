package app.service.impl;

import app.model.MappingUtil;
import app.model.ValidatorUtil;
import app.model.dtos.PhotographerDto;
import app.model.entities.BasicCamera;
import app.model.entities.Photographer;
import app.repositories.CameraRepository;
import app.repositories.PhotographerRepository;
import app.service.api.PhotographerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.awt.font.TextHitInfo;
import java.util.List;
import java.util.Random;

@Service
@Transactional
public class PhotographerServiceImpl implements PhotographerService {
    private PhotographerRepository photographerRepository;
    private CameraRepository cameraRepository;

    @Autowired
    public PhotographerServiceImpl(PhotographerRepository photographerRepository,
                                   CameraRepository cameraRepository) {
        this.photographerRepository = photographerRepository;
        this.cameraRepository = cameraRepository;
    }

    @Override
    public void create(Photographer photographer) {
        if (ValidatorUtil.validate(photographer)){
            this.photographerRepository.save(photographer);
            System.out.printf("Successfully imported %s %s %n",
                    photographer.getFirstName(),photographer.getLastName());
        } else {
            System.out.println("Error. Invalid data provided");
        }
    }

    @Override
    public void createMany(PhotographerDto[] dtos) {
        List<BasicCamera> all = this.cameraRepository.findAll();

        for (PhotographerDto dto : dtos) {
            Photographer photographer = MappingUtil
                    .convertFromDto(dto,Photographer.class);
            photographer.setPrimaryCamera(this.getRandomCamera(all));
            photographer.setSecondaryCamera(this.getRandomCamera(all));
            this.create(photographer);
        }
    }

    public BasicCamera getRandomCamera(List<BasicCamera> all){
        Random random = new Random();
        return all.get(random.nextInt(all.size()));
    }
}
