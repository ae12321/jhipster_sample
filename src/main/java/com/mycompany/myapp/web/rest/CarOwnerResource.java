package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.service.CarOwnerService;
import com.mycompany.myapp.web.rest.body.CarOwnerBody;
import java.net.URI;
import java.net.URISyntaxException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import tech.jhipster.web.util.HeaderUtil;

/**
 * REST controller for managing {@link com.mycompany.myapp.domain.Car}.
 */
@RestController
@RequestMapping("/api")
@Transactional
public class CarOwnerResource {

    private final Logger log = LoggerFactory.getLogger(CarOwnerResource.class);

    private static final String ENTITY_NAME = "car";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final CarOwnerService carOwnerService;

    public CarOwnerResource(CarOwnerService carOwnerService) {
        this.carOwnerService = carOwnerService;
    }

    @PostMapping("/custom")
    public ResponseEntity<CarOwnerBody> createCar(@RequestBody CarOwnerBody carOwnerBody) throws URISyntaxException {
        log.debug("REST request to save Car : {}", carOwnerBody);

        // validate
        // if (car.getId() != null) {
        //     throw new BadRequestAlertException("A new car cannot already have an ID", ENTITY_NAME, "idexists");
        // }

        CarOwnerBody result = carOwnerService.saveCarAndOwner(carOwnerBody);

        return ResponseEntity
            .created(new URI("/api/customcustom"))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, ""))
            .body(result);
    }
    // /**
    //  * {@code POST  /cars} : Create a new car.
    //  *
    //  * @param car the car to create.
    //  * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new car, or with status {@code 400 (Bad Request)} if the car has already an ID.
    //  * @throws URISyntaxException if the Location URI syntax is incorrect.
    //  */
    // @PostMapping("/cars")
    // public ResponseEntity<Car> createCar(@RequestBody Car car) throws URISyntaxException {
    //     log.debug("REST request to save Car : {}", car);
    //     if (car.getId() != null) {
    //         throw new BadRequestAlertException("A new car cannot already have an ID", ENTITY_NAME, "idexists");
    //     }
    //     Car result = carRepository.save(car);
    //     return ResponseEntity
    //         .created(new URI("/api/cars/" + result.getId()))
    //         .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
    //         .body(result);
    // }

    // /**
    //  * {@code PUT  /cars/:id} : Updates an existing car.
    //  *
    //  * @param id the id of the car to save.
    //  * @param car the car to update.
    //  * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated car,
    //  * or with status {@code 400 (Bad Request)} if the car is not valid,
    //  * or with status {@code 500 (Internal Server Error)} if the car couldn't be updated.
    //  * @throws URISyntaxException if the Location URI syntax is incorrect.
    //  */
    // @PutMapping("/cars/{id}")
    // public ResponseEntity<Car> updateCar(@PathVariable(value = "id", required = false) final Long id, @RequestBody Car car)
    //     throws URISyntaxException {
    //     log.debug("REST request to update Car : {}, {}", id, car);
    //     if (car.getId() == null) {
    //         throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
    //     }
    //     if (!Objects.equals(id, car.getId())) {
    //         throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
    //     }

    //     if (!carRepository.existsById(id)) {
    //         throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
    //     }

    //     Car result = carRepository.save(car);
    //     return ResponseEntity
    //         .ok()
    //         .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, car.getId().toString()))
    //         .body(result);
    // }

    // /**
    //  * {@code PATCH  /cars/:id} : Partial updates given fields of an existing car, field will ignore if it is null
    //  *
    //  * @param id the id of the car to save.
    //  * @param car the car to update.
    //  * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated car,
    //  * or with status {@code 400 (Bad Request)} if the car is not valid,
    //  * or with status {@code 404 (Not Found)} if the car is not found,
    //  * or with status {@code 500 (Internal Server Error)} if the car couldn't be updated.
    //  * @throws URISyntaxException if the Location URI syntax is incorrect.
    //  */
    // @PatchMapping(value = "/cars/{id}", consumes = { "application/json", "application/merge-patch+json" })
    // public ResponseEntity<Car> partialUpdateCar(@PathVariable(value = "id", required = false) final Long id, @RequestBody Car car)
    //     throws URISyntaxException {
    //     log.debug("REST request to partial update Car partially : {}, {}", id, car);
    //     if (car.getId() == null) {
    //         throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
    //     }
    //     if (!Objects.equals(id, car.getId())) {
    //         throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
    //     }

    //     if (!carRepository.existsById(id)) {
    //         throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
    //     }

    //     Optional<Car> result = carRepository
    //         .findById(car.getId())
    //         .map(existingCar -> {
    //             if (car.getCarName() != null) {
    //                 existingCar.setCarName(car.getCarName());
    //             }
    //             if (car.getIs4Door() != null) {
    //                 existingCar.setIs4Door(car.getIs4Door());
    //             }

    //             return existingCar;
    //         })
    //         .map(carRepository::save);

    //     return ResponseUtil.wrapOrNotFound(
    //         result,
    //         HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, car.getId().toString())
    //     );
    // }

    // /**
    //  * {@code GET  /cars} : get all the cars.
    //  *
    //  * @param pageable the pagination information.
    //  * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of cars in body.
    //  */
    // @GetMapping("/cars")
    // public ResponseEntity<List<Car>> getAllCars(@org.springdoc.api.annotations.ParameterObject Pageable pageable) {
    //     log.debug("REST request to get a page of Cars");
    //     Page<Car> page = carRepository.findAll(pageable);
    //     HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
    //     return ResponseEntity.ok().headers(headers).body(page.getContent());
    // }

    // /**
    //  * {@code GET  /cars/:id} : get the "id" car.
    //  *
    //  * @param id the id of the car to retrieve.
    //  * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the car, or with status {@code 404 (Not Found)}.
    //  */
    // @GetMapping("/cars/{id}")
    // public ResponseEntity<Car> getCar(@PathVariable Long id) {
    //     log.debug("REST request to get Car : {}", id);
    //     Optional<Car> car = carRepository.findById(id);
    //     return ResponseUtil.wrapOrNotFound(car);
    // }

    // /**
    //  * {@code DELETE  /cars/:id} : delete the "id" car.
    //  *
    //  * @param id the id of the car to delete.
    //  * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
    //  */
    // @DeleteMapping("/cars/{id}")
    // public ResponseEntity<Void> deleteCar(@PathVariable Long id) {
    //     log.debug("REST request to delete Car : {}", id);
    //     carRepository.deleteById(id);
    //     return ResponseEntity
    //         .noContent()
    //         .headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString()))
    //         .build();
    // }
}
