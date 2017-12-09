package app.service.impl;

import app.model.MappingUtil;
import app.model.dtos.AccessoriesDto;
import app.model.entities.Accessory;
import app.model.entities.Photographer;
import app.repositories.AccessoryRepository;
import app.repositories.PhotographerRepository;
import app.service.api.AccessoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Random;

@Service
@Transactional
public class AccessoriesServiceImpl implements AccessoriesService {
    private AccessoryRepository accessoryRepository;
    private PhotographerRepository photographerRepository;

    @Autowired
    public AccessoriesServiceImpl(AccessoryRepository accessoryRepository, PhotographerRepository photographerRepository) {
        this.accessoryRepository = accessoryRepository;
        this.photographerRepository = photographerRepository;
    }

    @Override
    public void create(Accessory accessory) {

        System.out.printf("Successfully imported %s%n", accessory.getName());
        this.accessoryRepository.save(accessory);
    }

    @Override
    public void createMany(AccessoriesDto[] dtos){
        List<Photographer> photographers = this.photographerRepository.findAll();
        for (AccessoriesDto dto : dtos) {
            Accessory accessory = MappingUtil
                    .convertFromDto(dto,Accessory.class);
            accessory.setOwner(this.getRandomPhotographer(photographers));
            this.create(accessory);
        }

    }

    public Photographer getRandomPhotographer(List<Photographer> all){
        Random random = new Random();
        return all.get(random.nextInt(all.size()));
    }


}
