package th.co.siamchamnankit.sck.motor.Customer;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CustomerController.class)
public class CustomerControllerMVCTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    CustomerService customerService;

    @Test
    public void get_customers_with_103_should_be_Atelier_graphique () throws Exception {
        int expectedCustomerNumber = 103;
        String expectedCustomerName = "Atelier graphique";

        given(this.customerService.getBy(expectedCustomerNumber))
                .willReturn(new CustomerResponse(expectedCustomerNumber, expectedCustomerName));

        MvcResult result = this.mvc.perform(get("/api/v1/customers/103"))
                .andExpect(status().isOk()).andReturn();

        ObjectMapper mapper = new ObjectMapper();
        CustomerResponse response = mapper.readValue(result.getResponse().getContentAsString(),CustomerResponse.class);

        assertEquals(expectedCustomerNumber, response.getCustomerNumber());
        assertEquals(expectedCustomerName, response.getCustomerName());
    }
}
