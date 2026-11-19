/**
 * Copyright (c) 2025. Shanghai HEADING information Engineering Co., Ltd. All rights reserved.
 */
package pers.zyrus.tk.springwebflux.r2dbc.service.order;

import jakarta.validation.constraints.NotNull;
import pers.zyrus.tk.springwebflux.commons.Paging;
import reactor.core.publisher.Mono;

/**
 * @author ZhengYu
 * @since 1.0
 */
public interface OrderService {

  Mono<Paging<OrderDO>> query(OrderPageQuery query);

  Mono<OrderDO> get(@NotNull Long id, String... fetchParts);

  Mono<OrderDO> getByFlowNo(@NotNull String flowNo, String... fetchParts);
}