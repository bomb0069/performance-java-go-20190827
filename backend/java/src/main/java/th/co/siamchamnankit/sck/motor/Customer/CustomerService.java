package th.co.siamchamnankit.sck.motor.Customer;

import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    public CustomerResponse getBy(int customerNumber) {
        return new CustomerResponse(customerNumber, "Atelier graphique");
    }
}
