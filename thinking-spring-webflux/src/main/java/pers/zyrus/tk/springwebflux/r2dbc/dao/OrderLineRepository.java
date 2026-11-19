/**
 * Copyright (c) 2025. Shanghai HEADING information Engineering Co., Ltd. All rights reserved.
 */
package pers.zyrus.tk.springwebflux.r2dbc.dao;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

/**
 * @author ZhengYu
 * @since 1.0
 */
public interface OrderLineRepository extends ReactiveCrudRepository<OrderLinePO, Long> {
  Flux<OrderLinePO> findByOrderId(Long orderId);
}
