package com.machinecoding.splitwise.model;

import lombok.Getter;

import java.util.List;
import java.util.Map;

public class PercentExpense extends Expense{

    @Getter
    private List<User> oweUserList;
    @Getter
    private Map<User, Double> userToOwePercent;

    public PercentExpense(User lendUser, Double totalAmount, List<User> oweUserList, Map<User, Double> userToOwePercent) {
        super(lendUser, totalAmount);
        this.oweUserList = oweUserList;
        this.userToOwePercent = userToOwePercent;
    }

    @Override
    public ExpenseType getExpenseType() {
        return ExpenseType.PERCENT;
    }
}
