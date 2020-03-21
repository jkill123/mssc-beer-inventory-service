package pinchuk.sfg.beer.inventory.service.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import pinchuk.sfg.beer.inventory.service.config.JmsConfig;
import pinchuk.sfg.beer.inventory.service.domain.BeerInventory;
import pinchuk.sfg.beer.inventory.service.repositories.BeerInventoryRepository;
import pinchuk.sfg.common.events.NewInventoryEvent;

/**
 * @author Pinchuk Yevhen
 * @created 21/03/2020 - 12:05
 */
@Slf4j
@RequiredArgsConstructor
@Component
public class NewInventoryListener {

    private final BeerInventoryRepository beerInventoryRepository;

    @JmsListener(destination = JmsConfig.NEW_INVENTORY_QUEUE)
    public void listen(NewInventoryEvent event){
        log.debug("Got inventory: " + event.toString());
        beerInventoryRepository.save(BeerInventory.builder()
                .beerId(event.getBeerDto().getId())
                .upc(event.getBeerDto().getUpc())
                .quantityOnHand(event.getBeerDto().getQuantityOnHand())
                .build());
    }
}
