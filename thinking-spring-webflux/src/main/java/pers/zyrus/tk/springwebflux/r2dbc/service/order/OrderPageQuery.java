/**
 * Copyright (c) 2025. Shanghai HEADING information Engineering Co., Ltd. All rights reserved.
 */
package pers.zyrus.tk.springwebflux.r2dbc.service.order;

import lombok.Getter;
import lombok.Setter;
import pers.zyrus.tk.springwebflux.commons.BasePageQuery;

/**
 * @author ZhengYu
 * @since 1.0
 */
@Getter
@Setter
public class OrderPageQuery extends BasePageQuery {
  private String flowNoEq;
  private String memberIdEq;
}