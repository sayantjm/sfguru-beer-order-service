package sayant.springframeworkguru.sfgurubeerorderservice.mapper;

import org.mapstruct.Mapper;
import sayant.springframeworkguru.sfgurubeerorderservice.domain.BeerOrder;
import sayant.springframeworkguru.sfgurubeerorderservice.model.BeerOrderDto;

/**
 * Created by sayantjm on 28/6/20
 */
@Mapper(uses = {DateMapper.class, BeerOrderLineMapper.class})
public interface BeerOrderMapper {

    BeerOrderDto beerOrderToDto(BeerOrder beerOrder);

    BeerOrder dtoToBeerOrder(BeerOrderDto dto);
}
