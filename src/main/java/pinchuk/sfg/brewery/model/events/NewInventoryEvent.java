package pinchuk.sfg.brewery.model.events;

import lombok.NoArgsConstructor;

/**
 * @author Pinchuk Yevhen
 * @created 20/03/2020 - 21:24
 */
@NoArgsConstructor
public class NewInventoryEvent extends BeerEvent {
    
    public NewInventoryEvent(BeerDto beerDto) {
        super(beerDto);
    }
}
