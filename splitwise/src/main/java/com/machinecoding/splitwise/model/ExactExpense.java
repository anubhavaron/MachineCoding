package com.machinecoding.splitwise.model;

import lombok.Getter;

import java.util.List;
import java.util.Map;

public class ExactExpense extends Expense{
    @Getter
    private List<User> oweUserList;
    @Getter
    private Map<User, Double> userToOweAmount;

    public ExactExpense(User lendUser, Double totalAmount, List<User> oweUserList, Map<User, Double> userToOweAmount) {
        super(lendUser, totalAmount);
        this.oweUserList = oweUserList;
        this.userToOweAmount = userToOweAmount;
    }

    @Override
    public ExpenseType getExpenseType() {
        return ExpenseType.EXACT;
    }
}
