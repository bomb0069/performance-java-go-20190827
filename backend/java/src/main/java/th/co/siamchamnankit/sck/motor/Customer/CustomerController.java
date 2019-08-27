package th.co.siamchamnankit.sck.motor.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping(path = "/api/v1/customers/{customerNumber}")
    public CustomerResponse get(@PathVariable int customerNumber) {
        return customerService.getBy(customerNumber);

    }
}
