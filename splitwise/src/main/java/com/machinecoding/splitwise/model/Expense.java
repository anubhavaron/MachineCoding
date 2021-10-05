package com.machinecoding.splitwise.model;

import lombok.Getter;

public abstract class Expense {
    @Getter
    private User lendUser;
    @Getter
    private Double totalAmount;

    public Expense(User lendUser, Double totalAmount) {
        this.lendUser = lendUser;
        this.totalAmount = totalAmount;
    }

    public abstract ExpenseType getExpenseType();

}
