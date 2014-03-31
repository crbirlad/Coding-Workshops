package com.oracle.workshop.model.showbiz;

import com.oracle.workshop.model.visitor.ItemVisitor;

/**
 * Created with IntelliJ IDEA for the Oracle Coding Workshops.
 * User: crbirlad
 */
public interface Item {
    public void accept(ItemVisitor visitor);
}
