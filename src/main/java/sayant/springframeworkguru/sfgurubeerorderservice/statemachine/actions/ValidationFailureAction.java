package sayant.springframeworkguru.sfgurubeerorderservice.statemachine.actions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.action.Action;
import org.springframework.stereotype.Component;
import sayant.springframeworkguru.sfgurubeerorderservice.domain.enums.BeerOrderEventEnum;
import sayant.springframeworkguru.sfgurubeerorderservice.domain.enums.BeerOrderStatusEnum;
import sayant.springframeworkguru.sfgurubeerorderservice.service.impl.BeerOrderManagerImpl;

/**
 * Created by sayantjm on 20/2/21
 */

@Slf4j
@Component
public class ValidationFailureAction implements Action<BeerOrderStatusEnum, BeerOrderEventEnum> {

    @Override
    public void execute(StateContext<BeerOrderStatusEnum, BeerOrderEventEnum> stateContext) {
        String beerOrderId = (String) stateContext.getMessage().getHeaders().get(BeerOrderManagerImpl.ORDER_ID_HEADER);

        log.error("Compesating transaction... Validation failed:{}", beerOrderId);
    }
}
