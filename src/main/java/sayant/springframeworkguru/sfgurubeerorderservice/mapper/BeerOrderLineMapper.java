package sayant.springframeworkguru.sfgurubeerorderservice.mapper;

import org.mapstruct.Mapper;
import sayant.springframeworkguru.sfgurubeerorderservice.domain.BeerOrderLine;
import sayant.springframeworkguru.sfgurubeerorderservice.model.BeerOrderLineDto;

/**
 * Created by sayantjm on 28/6/20
 */
@Mapper(uses = {DateMapper.class})
public interface BeerOrderLineMapper {
    BeerOrderLineDto beerOrderLineToDto(BeerOrderLine line);

    BeerOrderLine dtoToBeerOrderLine(BeerOrderLineDto dto);
}
