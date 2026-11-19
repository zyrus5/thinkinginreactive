/**
 * Copyright (c) 2025. Shanghai HEADING information Engineering Co., Ltd. All rights reserved.
 */
package pers.zyrus.tk.springwebflux.commons.mapstruct;

import java.util.List;

/**
 * @author ZhengYu
 * @since 1.0
 */
public interface BaseBiMapper<S, T> extends BaseSingleMapper<S, T> {
  
  S toSource(T target);

  default List<S> toSourceList(List<T> targetList) {
    if (targetList == null) {
      return null;
    }
    return targetList.stream()//
        .map(this::toSource)//
        .toList();
  }
}