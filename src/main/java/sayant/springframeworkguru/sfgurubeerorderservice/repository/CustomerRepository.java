package sayant.springframeworkguru.sfgurubeerorderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sayant.springframeworkguru.sfgurubeerorderservice.domain.Customer;

import java.util.List;
import java.util.UUID;

/**
 * Created by sayantjm on 28/6/20
 */
public interface CustomerRepository extends JpaRepository<Customer, UUID> {
    List<Customer> findAllByCustomerNameLike(String customerName);
}
