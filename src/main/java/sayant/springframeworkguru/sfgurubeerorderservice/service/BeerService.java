package sayant.springframeworkguru.sfgurubeerorderservice.service;

import sayant.springframeworkguru.brewery.model.BeerDto;

import java.util.Optional;
import java.util.UUID;

/**
 * Created by sayantjm on 28/11/20
 */
public interface BeerService {
    Optional<BeerDto> getBeerById(UUID uuid);

    Optional<BeerDto> getBeerByUpc(String upc);
}
