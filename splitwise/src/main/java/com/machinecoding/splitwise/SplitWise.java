package com.machinecoding.splitwise;

import com.machinecoding.splitwise.constant.SplitWiseConstants;
import com.machinecoding.splitwise.dao.SplitWiseDao;
import com.machinecoding.splitwise.model.*;
import com.machinecoding.splitwise.util.DebitBalancePrintUtility;
import com.machinecoding.splitwise.util.ExpenseAdditionUtility;
import com.machinecoding.splitwise.validator.ExpenseValidator;
import com.machinecoding.splitwise.validator.ExpenseValidatorResolver;
import lombok.Getter;

import java.util.List;
import java.util.Objects;

public class SplitWise {
    @Getter
    private SplitWiseDao dao ;

    public SplitWise(List<User> userList) {
        for(User user : userList) {
            dao.getUserDoubleMap().put(user, SplitWiseConstants.defaultAmount);
        }
    }

    public void showUserBalance(User user) {
        DebitBalancePrintUtility.showUserBalance(this.dao, user);
    }

    public void showAllUserBalance() {
        DebitBalancePrintUtility.showAllUserBalance(this.dao);
    }

    public void addExpense(Expense expense) {
        if(validExpense(expense)) {
            ExpenseType expenseType = expense.getExpenseType();
            addExpenseWithExpenseType(expense, expenseType);
        }
    }

    private void addExpenseWithExpenseType(Expense expense, ExpenseType expenseType) {
        switch (expenseType) {
            case EQUAL: ExpenseAdditionUtility.addEqualExpenseInDao(this.dao, (EqualExpense) expense);
                break;
            case EXACT: ExpenseAdditionUtility.addExactExpenseInDao(this.dao, (ExactExpense) expense);
                break;
            case PERCENT: ExpenseAdditionUtility.addPercentExpenseInDao(this.dao, (PercentExpense) expense);
        }
    }

    private boolean validExpense(Expense expense) {
        ExpenseValidator expenseValidator = ExpenseValidatorResolver.getExpenseValidator(expense.getExpenseType());
        if(Objects.nonNull(expenseValidator)) {
            return expenseValidator.isExpenseValid(expense);
        }
        return true;
    }
}
