/**
 * Copyright (c) 2025. Shanghai HEADING information Engineering Co., Ltd. All rights reserved.
 */
package pers.zyrus.tk.springwebflux.commons;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author ZhengYu
 * @since 1.0
 */
@Getter
@Setter
public class Paging<T> {
  private long total;
  private List<T> records;
}