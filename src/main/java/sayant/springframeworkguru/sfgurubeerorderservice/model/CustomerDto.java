package sayant.springframeworkguru.sfgurubeerorderservice.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.UUID;

/**
 * Created by sayantjm on 28/6/20
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class CustomerDto extends BaseItemDto {

    @Builder
    public CustomerDto(UUID id, Integer version, OffsetDateTime createdDate, OffsetDateTime lastUpdateDate, String name) {
        super(id, version, createdDate, lastUpdateDate);
        this.name = name;
    }

    private String name;

}
