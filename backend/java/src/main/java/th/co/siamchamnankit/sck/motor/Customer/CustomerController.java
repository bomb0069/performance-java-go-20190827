package th.co.siamchamnankit.sck.motor.Customer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @GetMapping(path = "/api/v1/customers/{id}")
    public CustomerResponse get(@PathVariable int id) {
        return new CustomerResponse(103, "Atelier graphique");

    }
}
