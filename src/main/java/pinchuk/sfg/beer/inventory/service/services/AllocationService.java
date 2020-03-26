package pinchuk.sfg.beer.inventory.service.services;

import pinchuk.sfg.brewery.model.BeerOrderDto;

/**
 * @author Pinchuk Yevhen
 * @created 26/03/2020 - 20:02
 */
public interface AllocationService {

    Boolean allocateOrder(BeerOrderDto beerOrderDto);

    void deallocateOrder(BeerOrderDto beerOrderDto);
}