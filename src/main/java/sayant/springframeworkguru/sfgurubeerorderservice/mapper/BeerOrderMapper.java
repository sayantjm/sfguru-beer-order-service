package sayant.springframeworkguru.sfgurubeerorderservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import sayant.springframeworkguru.sfgurubeerorderservice.domain.BeerOrder;
import sayant.springframeworkguru.brewery.model.BeerOrderDto;

/**
 * Created by sayantjm on 28/6/20
 */
@Mapper(uses = {DateMapper.class, BeerOrderLineMapper.class})
public interface BeerOrderMapper {

    @Mapping(target="customerId", source="customer.id")
    BeerOrderDto beerOrderToDto(BeerOrder beerOrder);

    BeerOrder dtoToBeerOrder(BeerOrderDto dto);
}
