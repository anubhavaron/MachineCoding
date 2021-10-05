package com.machinecoding.splitwise.validator;

import com.machinecoding.splitwise.model.Expense;

public interface ExpenseValidator<expense extends Expense> {
    boolean isExpenseValid(expense i);
}
