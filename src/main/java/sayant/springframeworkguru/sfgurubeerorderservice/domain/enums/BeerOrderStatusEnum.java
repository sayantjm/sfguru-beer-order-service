package sayant.springframeworkguru.sfgurubeerorderservice.domain.enums;

/**
 * Created by sayantjm on 28/6/20
 */
public enum BeerOrderStatusEnum {
    NEW, VALIDATED, VALIDATION_EXCEPTION, ALLOCATED, ALLOCATION_EXCEPTION, PENDING_INVENTORY, PICKED_UP, DELIVERED, DELIVERY_EXCEPTION
}