package sayant.springframeworkguru.sfgurubeerorderservice.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import sayant.springframeworkguru.sfgurubeerorderservice.domain.BeerOrderLine;

import java.util.UUID;

/**
 * Created by sayantjm on 28/6/20
 */
public interface BeerOrderLineRepository extends PagingAndSortingRepository<BeerOrderLine, UUID> {
}
