/**
 * Copyright (c) 2025. Shanghai HEADING information Engineering Co., Ltd. All rights reserved.
 */
package pers.zyrus.tk.springwebflux.r2dbc.controller.order;

import io.swagger.v3.oas.annotations.media.Schema;
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
@Schema(description = "订单信息")
public class OrderVO {
  @Schema(description = "订单ID", requiredMode = Schema.RequiredMode.REQUIRED)
  private Long id;
  @Schema(description = "订单流水号")
  private String flowNo;
  @Schema(description = "会员ID")
  private String memberId;
  @Schema(description = "订单总金额")
  private BigDecimal totalAmount;
  @Schema(description = "订单优惠金额")
  private BigDecimal discountAmount;
  @Schema(description = "订单实付金额")
  private BigDecimal realAmount;
  @Schema(description = "订单备注")
  private String remark;
  @Schema(description = "订单状态（1 正常，0 禁用）")
  private Short status;
  @Schema(description = "乐观锁版本号")
  private Long fVersion;
  @Schema(description = "创建时间")
  private OffsetDateTime createAt;
  @Schema(description = "更新时间")
  private OffsetDateTime updateAt;
}
