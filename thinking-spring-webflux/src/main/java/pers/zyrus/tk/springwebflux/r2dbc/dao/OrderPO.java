/**
 * Copyright (c) 2025. Shanghai HEADING information Engineering Co., Ltd. All rights reserved.
 */
package pers.zyrus.tk.springwebflux.r2dbc.dao;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

/**
 * @author ZhengYu
 * @since 1.0
 */
@Data
@Table(OrderPO.TABLE_NAME)
public class OrderPO {
  public static final String TABLE_NAME = "tir_order";

  public static final String COLUMN_ID = "id";
  public static final String COLUMN_FLOW_NO = "flow_no";
  public static final String COLUMN_MEMBER_ID = "member_id";
  public static final String COLUMN_TOTAL_AMOUNT = "total_amount";
  public static final String COLUMN_DISCOUNT_AMOUNT = "discount_amount";
  public static final String COLUMN_REAL_AMOUNT = "real_amount";
  public static final String COLUMN_REMARK = "remark";
  public static final String COLUMN_STATUS = "status";
  public static final String COLUMN_F_VERSION = "f_version";
  public static final String COLUMN_CREATE_AT = "create_at";
  public static final String COLUMN_UPDATE_AT = "update_at";

  @Id
  @Column(COLUMN_ID)
  private Long id;
  @Column(COLUMN_FLOW_NO)
  private String flowNo;
  @Column(COLUMN_MEMBER_ID)
  private String memberId;
  @Column(COLUMN_TOTAL_AMOUNT)
  private BigDecimal totalAmount;
  @Column(COLUMN_DISCOUNT_AMOUNT)
  private BigDecimal discountAmount;
  @Column(COLUMN_REAL_AMOUNT)
  private BigDecimal realAmount;
  @Column(COLUMN_REMARK)
  private String remark;
  @Column(COLUMN_STATUS)
  private Short status;
  @Version
  @Column(COLUMN_F_VERSION)
  private Long fVersion;
  @Column(COLUMN_CREATE_AT)
  private OffsetDateTime createAt;
  @Column(COLUMN_UPDATE_AT)
  private OffsetDateTime updateAt;
}