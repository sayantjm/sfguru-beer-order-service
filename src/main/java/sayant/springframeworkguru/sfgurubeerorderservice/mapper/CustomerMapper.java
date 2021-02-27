package sayant.springframeworkguru.sfgurubeerorderservice.mapper;

import org.mapstruct.Mapper;
import sayant.springframeworkguru.brewery.model.CustomerDto;
import sayant.springframeworkguru.sfgurubeerorderservice.domain.Customer;

/**
 * Created by sayantjm on 27/2/21
 */
@Mapper(uses = {DateMapper.class})
public interface CustomerMapper {
    CustomerDto customerToDto(Customer customer);

    Customer dtoToCustomer(CustomerDto dto);
}
