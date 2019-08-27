package th.co.siamchamnankit.sck.motor.Customer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CustomerControllerSpringBootTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void get_customers_with_103_should_be_Atelier_graphique () {
        CustomerResponse actualResponse = restTemplate.getForObject("/api/v1/customers/103",CustomerResponse.class);

        assertEquals(103, actualResponse.getCustomerNumber());
        assertEquals("Atelier graphique", actualResponse.getCustomerName());
    }
}
