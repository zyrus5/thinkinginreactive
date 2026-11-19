/**
 * Copyright (c) 2025. Shanghai HEADING information Engineering Co., Ltd. All rights reserved.
 */
package pers.zyrus.tk.springwebflux.r2dbc.serviceimpl.order;

import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import pers.zyrus.tk.springwebflux.commons.Paging;
import pers.zyrus.tk.springwebflux.r2dbc.dao.OrderLineRepository;
import pers.zyrus.tk.springwebflux.r2dbc.dao.OrderRepository;
import pers.zyrus.tk.springwebflux.r2dbc.service.order.OrderDO;
import pers.zyrus.tk.springwebflux.r2dbc.service.order.OrderLineDO;
import pers.zyrus.tk.springwebflux.r2dbc.service.order.OrderPageQuery;
import pers.zyrus.tk.springwebflux.r2dbc.service.order.OrderService;
import reactor.core.publisher.Mono;

import java.util.Arrays;

/**
 * @author ZhengYu
 * @since 1.0
 */
@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {
  private final OrderRepository orderRepository;
  private final OrderLineRepository orderLineRepository;

  @Override
  public Mono<Paging<OrderDO>> query(OrderPageQuery query) {
    return null;
  }

  @Override
  public Mono<OrderDO> get(Long id, String... fetchParts) {
    boolean fetchLines = fetchParts != null && Arrays.asList(fetchParts)
        .contains(OrderDO.PART_LINES);
    Mono<OrderDO> order = orderRepository.findById(id).map(source -> {
      OrderDO target = new OrderDO();
      BeanUtils.copyProperties(source, target);
      return target;
    });
    if (!fetchLines) {
      return order;
    }

    return order.flatMap(target -> orderLineRepository.findByOrderId(target.getId()).map(source -> {
      OrderLineDO line = new OrderLineDO();
      BeanUtils.copyProperties(source, line);
      return line;
    }).collectList().map(lines -> {
      target.setLines(lines);
      return target;
    }));
  }

  @Override
  public Mono<OrderDO> getByFlowNo(String flowNo, String... fetchParts) {
    return null;
  }
}
