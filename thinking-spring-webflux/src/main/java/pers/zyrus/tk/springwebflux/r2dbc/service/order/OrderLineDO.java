/**
 * Copyright (c) 2025. Shanghai HEADING information Engineering Co., Ltd. All rights reserved.
 */
package pers.zyrus.tk.springwebflux.r2dbc.service.order;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

/**
 * @author ZhengYu
 * @since 1.0
 */
@Getter
@Setter
public class OrderLineDO {
  private Long id;
  private Long orderId;
  private Long productId;
  private String productName;
  private String productCode;
  private String productSpec;
  private String productImage;
  private Integer quantity;
  private BigDecimal unitPrice;
  private BigDecimal totalAmount;
  private BigDecimal discountAmount;
  private BigDecimal realAmount;
  private String remark;
  private Short status;
  private Long fVersion;
  private OffsetDateTime createAt;
  private OffsetDateTime updateAt;
}