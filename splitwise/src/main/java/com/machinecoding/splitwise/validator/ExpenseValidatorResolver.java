package com.machinecoding.splitwise.validator;

import com.machinecoding.splitwise.model.ExpenseType;

import java.util.HashMap;
import java.util.Map;

public class ExpenseValidatorResolver {

     private static Map<ExpenseType, ExpenseValidator> expenseTypeExpenseValidatorMap;

     static  {
         expenseTypeExpenseValidatorMap = new HashMap<>();
         expenseTypeExpenseValidatorMap.put(ExpenseType.EXACT, new ExactExpenseValidator());
         expenseTypeExpenseValidatorMap.put(ExpenseType.PERCENT, new PercentExpenseValidator());
     }

     public static ExpenseValidator getExpenseValidator(ExpenseType expenseType) {
         return expenseTypeExpenseValidatorMap.get(expenseType);
     }
}
