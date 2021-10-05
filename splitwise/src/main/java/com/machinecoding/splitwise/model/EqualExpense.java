package com.machinecoding.splitwise.model;

import lombok.Getter;

import java.util.List;
import java.util.Map;

public class EqualExpense extends Expense {
    @Getter
    private List<User> oweUserList;

    public EqualExpense(User lendUser, Double totalAmount, List<User> oweUserList) {
        super(lendUser, totalAmount);
        this.oweUserList = oweUserList;
    }

    @Override
    public ExpenseType getExpenseType() {
        return ExpenseType.EQUAL;
    }
}
