/**
 * Copyright (c) 2025. Shanghai HEADING information Engineering Co., Ltd. All rights reserved.
 */
package pers.zyrus.tk.springwebflux.r2dbc.dao;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

/**
 * @author ZhengYu
 * @since 1.0
 */
@Data
@Table(OrderLinePO.TABLE_NAME)
public class OrderLinePO {
  public static final String TABLE_NAME = "tir_order_line";

  public static final String COLUMN_ID = "id";
  public static final String COLUMN_ORDER_ID = "order_id";
  public static final String COLUMN_PRODUCT_ID = "product_id";
  public static final String COLUMN_PRODUCT_NAME = "product_name";
  public static final String COLUMN_PRODUCT_CODE = "product_code";
  public static final String COLUMN_PRODUCT_SPEC = "product_spec";
  public static final String COLUMN_PRODUCT_IMAGE = "product_image";
  public static final String COLUMN_QUANTITY = "quantity";
  public static final String COLUMN_UNIT_PRICE = "unit_price";
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
  @Column(COLUMN_ORDER_ID)
  private Long orderId;
  @Column(COLUMN_PRODUCT_ID)
  private Long productId;
  @Column(COLUMN_PRODUCT_NAME)
  private String productName;
  @Column(COLUMN_PRODUCT_CODE)
  private String productCode;
  @Column(COLUMN_PRODUCT_SPEC)
  private String productSpec;
  @Column(COLUMN_PRODUCT_IMAGE)
  private String productImage;
  @Column(COLUMN_QUANTITY)
  private Integer quantity;
  @Column(COLUMN_UNIT_PRICE)
  private BigDecimal unitPrice;
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
  @Column(COLUMN_F_VERSION)
  private Long fVersion;
  @Column(COLUMN_CREATE_AT)
  private OffsetDateTime createAt;
  @Column(COLUMN_UPDATE_AT)
  private OffsetDateTime updateAt;
}