package app.web;

import app.model.Business;
import app.services.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/business")
public class BusinessController {
    private BusinessService businessService;

    @Autowired
    public BusinessController(BusinessService businessService) {
        this.businessService = businessService;
    }

    // returns a response entity with a business object by calling the findBusinessById() method from businessService using given id
    @GetMapping("/{id}")
    public ResponseEntity<Business> getBusiness(@PathVariable() Long id) {
        Business business = businessService.findBusinessById(id);

        return new ResponseEntity<>(business, HttpStatus.OK);
    }

    @GetMapping("/all/{id}")
    public ResponseEntity<Iterable<Business>> getAllBusinesses() {
        Iterable<Business> businesses = businessService.findAllBusinesses();

        return new ResponseEntity<>(businesses, HttpStatus.OK);
    }

    // calls the createBusiness() method from businessService and returns a response entity with the created business
    @PostMapping()
    public ResponseEntity<Business> addBusiness(@RequestBody() @Valid Business business) {
        Business addBusiness = businessService.createBusiness(business);

        return new ResponseEntity<>(addBusiness, HttpStatus.ACCEPTED);
    }
}
