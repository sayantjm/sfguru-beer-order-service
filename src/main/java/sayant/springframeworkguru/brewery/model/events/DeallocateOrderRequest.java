package sayant.springframeworkguru.brewery.model.events;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import sayant.springframeworkguru.brewery.model.BeerOrderDto;

/**
 * Created by sayantjm on 20/2/21
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeallocateOrderRequest {
    private BeerOrderDto beerOrderDto;
}
