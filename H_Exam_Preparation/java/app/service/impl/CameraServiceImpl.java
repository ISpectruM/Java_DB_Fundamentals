package app.service.impl;

import app.model.MappingUtil;
import app.model.ValidatorUtil;
import app.model.dtos.BasicCameraDto;
import app.model.entities.BasicCamera;
import app.model.entities.DSLRCamera;
import app.model.entities.MirrorlessCamera;
import app.repositories.CameraRepository;
import app.service.api.CameraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.ValidationUtils;

import javax.transaction.Transactional;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;


@Service
@Transactional
public class CameraServiceImpl implements CameraService{
    private CameraRepository cameraRepository;

    @Autowired
    public CameraServiceImpl(CameraRepository cameraRepository) {
        this.cameraRepository = cameraRepository;
    }

    @Override
    public void create(BasicCamera camera){
        if (ValidatorUtil.validate(camera)){
            this.cameraRepository.save(camera);
            System.out.printf("Successfully imported %s %s %s%n",
                    camera.getType(),camera.getMake(),camera.getModel());
        } else {
            System.out.println("Error. Invalid data provided");
        }
    }

    @Override
    public void createMany(BasicCameraDto[] dtos){
        for (BasicCameraDto dto : dtos) {
            if (dto.getType()!= null && dto.getType().equals("DSLR")){
                DSLRCamera camera = MappingUtil
                        .convertFromDto(dto,DSLRCamera.class);
                this.create(camera);
            } else if (dto.getType()!= null && dto.getType().equals("Mirrorless")){
                MirrorlessCamera camera = MappingUtil
                        .convertFromDto(dto,MirrorlessCamera.class);
                this.create(camera);
            } else {
                System.out.println("Error. Invalid data provided");
            }
        }
    }


}
