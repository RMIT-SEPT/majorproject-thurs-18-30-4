package test.services;

import app.exception.BusinessException;
import app.model.Business;
import app.services.BusinessService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class BusinessServiceTest {
    @Autowired
    private BusinessService businessService;

    @Test
    public void createBusiness_throwsException_ifBusinessHasId() {
        Business business = new Business();
        business.setId(new Long(100));

        assertThrows(BusinessException.class,
                ()->businessService.createBusiness(business),
                "BusinessException has been thrown as business parameter has an id");

    }

    @Test
    public void findBusinessById_foundBusinessIsEqualToOriginal_ifBothHaveSameName() {
        Business business = new Business();
        business.setName("test");
        businessService.createBusiness(business);

        Business temp = businessService.findBusinessById(business.getId());

        assertThat(temp.getName()).isEqualTo(business.getName());
    }
}
