# 常用注解

| 注解                | 含义                         | 备注                         |
|---------------------|------------------------------|------------------------------|
| @Table              | 指定数据库表名               |                              |
| @Id                 | 标记主键字段                 |                              |
| @Column             | 指定数据库字段名             |                              |
| @Transient          | 字段不参与数据库映射         |                              |
| @Version            | 版本控制                     | 乐观锁                       |
| @ReadOnlyProperty   | 只读属性                     | 无论insert还是update都不可写 |
| @Embedded           | 将嵌套对象属性映射到同一张表 |                              |
| @PersistenceCreator | 指定数据库读取时使用的构造器 |                              |

* @Embedded

```sql
CREATE TABLE orders
(
    id               BIGINT PRIMARY KEY,
    order_no         VARCHAR(64),
    receiver_name    VARCHAR(100),
    receiver_phone   VARCHAR(20),
    receiver_city    VARCHAR(100),
    receiver_address VARCHAR(500)
);
```

```java
@Data
public class ReceiverInfo {
  private String name;
  private String phone;
  private String city;
  private String address;
}

@Data
@Table("orders")
public class OrderPO {
  @Id
  private Long id;
  private String orderNo;
  @Embedded(onEmpty = Embedded.OnEmpty.USE_NULL, prefix = "receiver_")
  private ReceiverInfo receiver;
}
```