/**
 * Copyright (c) 2025. Shanghai HEADING information Engineering Co., Ltd. All rights reserved.
 */
package pers.zyrus.tk.springwebflux.r2dbc.dao;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

/**
 * @author ZhengYu
 * @since 1.0
 */
public interface OrderRepository extends ReactiveCrudRepository<OrderPO, Long> {
}