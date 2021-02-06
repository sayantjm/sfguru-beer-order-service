package sayant.springframeworkguru.sfgurubeerorderservice.service;

import sayant.springframeworkguru.sfgurubeerorderservice.domain.BeerOrder;

/**
 * Created by sayantjm on 6/2/21
 */
public interface BeerOrderManager {
    BeerOrder newBeerOrder(BeerOrder beerOrder);
}
