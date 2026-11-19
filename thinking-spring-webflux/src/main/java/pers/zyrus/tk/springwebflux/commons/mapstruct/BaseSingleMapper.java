/**
 * Copyright (c) 2025. Shanghai HEADING information Engineering Co., Ltd. All rights reserved.
 */
package pers.zyrus.tk.springwebflux.commons.mapstruct;

import pers.zyrus.tk.springwebflux.commons.Paging;

import java.util.List;

/**
 * @author ZhengYu
 * @since 1.0
 */
public interface BaseSingleMapper<S, T> {
  
  T toTarget(S source);

  default List<T> toTargetList(List<S> sourceList) {
    if (sourceList == null) {
      return null;
    }
    return sourceList.stream()//
        .map(this::toTarget)//
        .toList();
  }

  default Paging<T> toTargetPage(Paging<S> sourcePage) {
    if (sourcePage == null) {
      return null;
    }
    Paging<T> targetPage = new Paging<>();
    targetPage.setRecords(toTargetList(sourcePage.getRecords()));
    targetPage.setTotal(sourcePage.getTotal());
    return targetPage;
  }
}