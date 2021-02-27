package sayant.springframeworkguru.sfgurubeerorderservice.service;

import org.springframework.data.domain.Pageable;
import sayant.springframeworkguru.brewery.model.CustomerPagedList;

/**
 * Created by sayantjm on 27/2/21
 */
public interface CustomerService {
    CustomerPagedList listCustomers(Pageable pageable);
}
