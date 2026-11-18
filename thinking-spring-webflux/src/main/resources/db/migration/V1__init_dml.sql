CREATE TABLE IF NOT EXISTS tir_order
(
    id              BIGINT         NOT NULL PRIMARY KEY,
    flow_no         VARCHAR(32)    NOT NULL,
    member_id       VARCHAR(255),
    total_amount    DECIMAL(20, 6) NOT NULL DEFAULT 0,
    discount_amount DECIMAL(20, 6) NOT NULL DEFAULT 0,
    real_amount     DECIMAL(20, 6) NOT NULL DEFAULT 0,
    remark          VARCHAR(500),
    status          SMALLINT       NOT NULL DEFAULT 1, -- 1正常 0禁用
    f_version       BIGINT         NOT NULL,
    create_at       TIMESTAMPTZ    NOT NULL DEFAULT NOW(),
    update_at       TIMESTAMPTZ    NOT NULL DEFAULT NOW(),
    CONSTRAINT uk_tir_order UNIQUE (flow_no)
);
COMMENT ON TABLE tir_order IS '订单表';
COMMENT ON COLUMN tir_order.id IS '主键ID';
COMMENT ON COLUMN tir_order.flow_no IS '订单流水号';
COMMENT ON COLUMN tir_order.member_id IS '会员ID';
COMMENT ON COLUMN tir_order.total_amount IS '订单总金额';
COMMENT ON COLUMN tir_order.discount_amount IS '订单优惠金额';
COMMENT ON COLUMN tir_order.real_amount IS '订单实付金额';
COMMENT ON COLUMN tir_order.remark IS '订单备注';
COMMENT ON COLUMN tir_order.status IS '状态：1正常 0禁用';
COMMENT ON COLUMN tir_order.f_version IS '乐观锁版本号';
COMMENT ON COLUMN tir_order.create_at IS '创建时间';
COMMENT ON COLUMN tir_order.update_at IS '更新时间';

CREATE TABLE IF NOT EXISTS tir_order_detail
(
    id              BIGINT         NOT NULL PRIMARY KEY,
    order_id        BIGINT         NOT NULL,
    product_id      BIGINT         NOT NULL,
    product_name    VARCHAR(255)   NOT NULL,
    product_code    VARCHAR(64),
    product_spec    VARCHAR(500),
    product_image   VARCHAR(500),
    quantity        INTEGER        NOT NULL DEFAULT 1,
    unit_price      DECIMAL(20, 6) NOT NULL DEFAULT 0,
    total_amount    DECIMAL(20, 6) NOT NULL DEFAULT 0,
    discount_amount DECIMAL(20, 6) NOT NULL DEFAULT 0,
    real_amount     DECIMAL(20, 6) NOT NULL DEFAULT 0,
    remark          VARCHAR(500),
    status          SMALLINT       NOT NULL DEFAULT 1, -- 1正常 0禁用
    f_version       BIGINT         NOT NULL,
    create_at       TIMESTAMPTZ    NOT NULL DEFAULT NOW(),
    update_at       TIMESTAMPTZ    NOT NULL DEFAULT NOW()
);
COMMENT ON TABLE tir_order_detail IS '订单明细表';
COMMENT ON COLUMN tir_order_detail.id IS '主键ID';
COMMENT ON COLUMN tir_order_detail.order_id IS '订单ID';
COMMENT ON COLUMN tir_order_detail.product_id IS '商品ID';
COMMENT ON COLUMN tir_order_detail.product_name IS '商品名称（快照）';
COMMENT ON COLUMN tir_order_detail.product_code IS '商品编码（快照）';
COMMENT ON COLUMN tir_order_detail.product_spec IS '商品规格（快照）';
COMMENT ON COLUMN tir_order_detail.product_image IS '商品图片（快照）';
COMMENT ON COLUMN tir_order_detail.quantity IS '购买数量';
COMMENT ON COLUMN tir_order_detail.unit_price IS '商品单价';
COMMENT ON COLUMN tir_order_detail.total_amount IS '明细总金额';
COMMENT ON COLUMN tir_order_detail.discount_amount IS '明细优惠金额';
COMMENT ON COLUMN tir_order_detail.real_amount IS '明细实付金额';
COMMENT ON COLUMN tir_order_detail.remark IS '明细备注';
COMMENT ON COLUMN tir_order_detail.status IS '状态：1正常 0禁用';
COMMENT ON COLUMN tir_order_detail.f_version IS '乐观锁版本号';
COMMENT ON COLUMN tir_order_detail.create_at IS '创建时间';
COMMENT ON COLUMN tir_order_detail.update_at IS '更新时间';
CREATE INDEX IF NOT EXISTS idx_tir_order_detail_order_id
    ON tir_order_detail (order_id);
CREATE INDEX IF NOT EXISTS idx_tir_order_detail_product_id
    ON tir_order_detail (product_id);