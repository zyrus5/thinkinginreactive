/**
 * Copyright (c) 2025. Shanghai HEADING information Engineering Co., Ltd. All rights reserved.
 */
package pers.zyrus.tk.springwebflux.r2dbc.service.order;

import lombok.Data;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;

/**
 * @author ZhengYu
 * @since 1.0
 */
@Data
public class OrderDO {
  public static final String PART_LINES = "lines";

  private Long id;
  private String flowNo;
  private String memberId;
  private BigDecimal totalAmount;
  private BigDecimal discountAmount;
  private BigDecimal realAmount;
  private String remark;
  private Short status;
  private Long fVersion;
  private OffsetDateTime createAt;
  private OffsetDateTime updateAt;

  private List<OrderLineDO> lines;
}