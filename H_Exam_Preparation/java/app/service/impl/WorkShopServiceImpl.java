package app.service.impl;

import app.model.MappingUtil;
import app.model.ValidatorUtil;
import app.model.dtos.PhotographerDto;
import app.model.dtos.WorkshopDto;
import app.model.entities.Photographer;
import app.model.entities.Workshop;
import app.repositories.PhotographerRepository;
import app.repositories.WorkshopRepository;
import app.service.api.WorkShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

@Service
@Transactional
public class WorkShopServiceImpl implements WorkShopService {
    private WorkshopRepository workshopRepository;
    private PhotographerRepository photographerRepository;

    @Autowired
    public WorkShopServiceImpl(WorkshopRepository workshopRepository, PhotographerRepository photographerRepository) {
        this.workshopRepository = workshopRepository;
        this.photographerRepository = photographerRepository;
    }

    @Override
    public void create(Workshop workshop) {
        if (ValidatorUtil.validate(workshop)){
            this.workshopRepository.save(workshop);
            System.out.printf("Successfully imported %s%n",
                    workshop.getName());
        } else {
            System.out.println("Error. Invalid data provided");
        }
    }

    @Override
    public void createMany(WorkshopDto[] dtos){
        for (WorkshopDto dto : dtos) {
            Workshop workshop = MappingUtil
                    .convertFromDto(dto,Workshop.class);
            String trainerName = dto.getTrainer();
            if (trainerName != null){
                String[] trainerNames = dto.getTrainer().split(" ");
                Photographer trainer = this.photographerRepository
                        .findByFirstNameAndLastName(trainerNames[0], trainerNames[1]);
                workshop.setTrainer(trainer);
            }

            if (dto.getParticipants() != null) {
                workshop.setParticipants(this.fillParticipants(dto.getParticipants()));
            }
            this.create(workshop);
        }
    }

    private Set<Photographer> fillParticipants(Set<PhotographerDto> participantsDto) {
        Set<Photographer> participants = new HashSet<>();

        for (PhotographerDto participantDto : participantsDto) {

            Photographer participant = this.photographerRepository
                    .findByFirstNameAndLastName(
                            participantDto.getFirstName(), participantDto.getLastName());
            participants.add(participant);
        }
        return participants;
    }
}
