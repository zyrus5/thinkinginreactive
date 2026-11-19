/**
 * Copyright (c) 2025. Shanghai HEADING information Engineering Co., Ltd. All rights reserved.
 */
package pers.zyrus.tk.springwebflux.r2dbc.controller.order;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import pers.zyrus.tk.springwebflux.commons.mapstruct.BaseSingleMapper;
import pers.zyrus.tk.springwebflux.r2dbc.service.order.OrderDO;

/**
 * @author ZhengYu
 * @since 1.0
 */
@Mapper
public interface OrderVoMapper extends BaseSingleMapper<OrderDO, OrderVO> {
  OrderVoMapper INSTANCE = Mappers.getMapper(OrderVoMapper.class);
}