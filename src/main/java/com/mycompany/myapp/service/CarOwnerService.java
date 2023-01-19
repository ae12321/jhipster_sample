package com.mycompany.myapp.service;

import com.mycompany.myapp.domain.Car;
import com.mycompany.myapp.domain.Owner;
import com.mycompany.myapp.repository.CarRepository;
import com.mycompany.myapp.repository.OwnerRepository;
import com.mycompany.myapp.web.rest.body.CarOwnerBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service class for managing users.
 */
@Service
@Transactional
public class CarOwnerService {

    private final Logger log = LoggerFactory.getLogger(CarOwnerService.class);

    private final CarRepository carRepository;
    private final OwnerRepository ownerRepository;

    public CarOwnerService(CarRepository carRepository, OwnerRepository ownerRepository) {
        this.carRepository = carRepository;
        this.ownerRepository = ownerRepository;
    }

    @Transactional
    public CarOwnerBody saveCarAndOwner(CarOwnerBody carOwnerBody) {
        CarOwnerBody cloned = CarOwnerBody.clone(carOwnerBody);

        Car car = new Car();
        car.setCarName(cloned.getCarName());
        car.setIs4Door(cloned.getCarIs4Door());
        Car savedCar = carRepository.save(car);

        Owner owner = new Owner();
        owner.setOwnerName(cloned.getOwnerName());
        owner.setAge(cloned.getOwnerAge());
        Owner savedOwner = ownerRepository.save(owner);

        cloned.setCarId(savedCar.getId());
        cloned.setOwnerId(savedOwner.getId());

        return cloned;
    }
}
