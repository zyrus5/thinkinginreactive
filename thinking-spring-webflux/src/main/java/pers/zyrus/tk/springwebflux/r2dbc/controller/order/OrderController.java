/**
 * Copyright (c) 2025. Shanghai HEADING information Engineering Co., Ltd. All rights reserved.
 */
package pers.zyrus.tk.springwebflux.r2dbc.controller.order;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.zyrus.tk.springwebflux.r2dbc.service.order.OrderDO;
import pers.zyrus.tk.springwebflux.r2dbc.service.order.OrderService;
import reactor.core.publisher.Mono;

/**
 * @author ZhengYu
 * @since 1.0
 */
@Tag(name = "订单接口")
@RestController
@RequestMapping("orders")
@AllArgsConstructor
public class OrderController {
  private final OrderService orderService;

  @Operation(summary = "根据id获取订单", description = "返回订单行")
  @GetMapping("{id}")
  public Mono<OrderVO> get(@Parameter(name = "id", description = "订单id", required = true,
      in = ParameterIn.PATH) @PathVariable("id") Long id) {
    return orderService.get(id, OrderDO.PART_LINES)//
        .map(OrderVoMapper.INSTANCE::toTarget);
  }
}