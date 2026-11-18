CREATE SEQUENCE IF NOT EXISTS seq_tir_order_id
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 100;

CREATE SEQUENCE IF NOT EXISTS seq_tir_order_detail_id
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 100;

CREATE OR REPLACE PROCEDURE sp_generate_order_data(
    IN p_count INTEGER
)
    LANGUAGE plpgsql
AS $$
DECLARE
    v_i             INTEGER;
    v_j             INTEGER;
    v_detail_count  INTEGER;

    v_order_id      BIGINT;
    v_order_no      VARCHAR(32);
    v_member_id     VARCHAR(255);

    v_product_id    BIGINT;
    v_quantity      INTEGER;
    v_unit_price    DECIMAL(20, 6);
    v_total_amount DECIMAL(20, 6);
    v_discount      DECIMAL(20, 6);
    v_real_amount   DECIMAL(20, 6);

    v_order_total   DECIMAL(20, 6);
    v_order_discount DECIMAL(20, 6);
    v_order_real    DECIMAL(20, 6);
BEGIN
    IF p_count IS NULL OR p_count <= 0 THEN
        RAISE EXCEPTION '生成订单数量必须大于0';
    END IF;

    FOR v_i IN 1..p_count LOOP

            -- 生成订单ID
            v_order_id := nextval('seq_tir_order_id');

            -- 生成唯一订单流水号
            v_order_no := 'ORD' || TO_CHAR(CLOCK_TIMESTAMP(), 'YYYYMMDDHH24MISS')
                || LPAD(v_order_id::TEXT, 12, '0');

            -- 生成会员ID
            v_member_id := (1 + FLOOR(RANDOM() * 10000))::BIGINT::TEXT;

            -- 每个订单随机生成1~5条明细
            v_detail_count := 1 + FLOOR(RANDOM() * 5)::INTEGER;

            v_order_total := 0;
            v_order_discount := 0;
            v_order_real := 0;

            -- 先生成订单ID，再生成明细
            v_order_id := v_order_id;

            FOR v_j IN 1..v_detail_count LOOP

                    -- 商品ID：1~1000
                    v_product_id := 1 + FLOOR(RANDOM() * 1000)::BIGINT;

                    -- 商品数量：1~5
                    v_quantity := 1 + FLOOR(RANDOM() * 5)::INTEGER;

                    -- 商品单价：10~1000
                    v_unit_price := ROUND(
                            (10 + RANDOM() * 990)::NUMERIC,
                            6
                                    );

                    -- 明细总金额
                    v_total_amount := ROUND(
                            v_quantity * v_unit_price,
                            6
                                      );

                    -- 随机优惠比例：0%~10%
                    v_discount := ROUND(
                            v_total_amount * (RANDOM() * 0.1)::NUMERIC,
                            6
                                  );

                    -- 明细实付金额
                    v_real_amount := v_total_amount - v_discount;

                    -- 累加订单金额
                    v_order_total := v_order_total + v_total_amount;
                    v_order_discount := v_order_discount + v_discount;
                    v_order_real := v_order_real + v_real_amount;

                    -- 暂存明细，稍后统一插入
                    INSERT INTO tir_order_detail (
                        id,
                        order_id,
                        product_id,
                        product_name,
                        product_code,
                        product_spec,
                        product_image,
                        quantity,
                        unit_price,
                        total_amount,
                        discount_amount,
                        real_amount,
                        remark,
                        status,
                        f_version
                    )
                    VALUES (
                               nextval('seq_tir_order_detail_id'),
                               v_order_id,
                               v_product_id,
                               '测试商品' || v_product_id,
                               'P' || LPAD(v_product_id::TEXT, 6, '0'),
                               '默认规格',
                               NULL,
                               v_quantity,
                               v_unit_price,
                               v_total_amount,
                               v_discount,
                               v_real_amount,
                               NULL,
                               1,
                               1
                           );

                END LOOP;

            -- 插入订单主表
            INSERT INTO tir_order (
                id,
                flow_no,
                member_id,
                total_amount,
                discount_amount,
                real_amount,
                remark,
                status,
                f_version
            )
            VALUES (
                       v_order_id,
                       v_order_no,
                       v_member_id,
                       v_order_total,
                       v_order_discount,
                       v_order_real,
                       '测试订单',
                       1,
                       1
                   );

        END LOOP;

END;
$$;