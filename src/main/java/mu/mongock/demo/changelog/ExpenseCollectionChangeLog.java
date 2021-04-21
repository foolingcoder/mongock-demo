package mu.mongock.demo.changelog;

import static mu.mongock.demo.model.ExpenseCategory.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;

import mu.mongock.demo.model.ExpenseCategory;
import mu.mongock.demo.model.ExpenseCollection;
import mu.mongock.demo.repository.ExpenseRepository;

@ChangeLog
public class ExpenseCollectionChangeLog {

    @ChangeSet(order = "001", id = "expenseCollection_cs1", author = "Priteela")
    public void createAndSeedExpenseCollection(ExpenseRepository expenseRepository) {
        List<ExpenseCollection> expenseList = new ArrayList<>();
        expenseList.add(createNewExpense("Movie Tickets", ENTERTAINMENT, BigDecimal.valueOf(40)));
        expenseList.add(createNewExpense("Dinner", RESTAURANT, BigDecimal.valueOf(60)));
        expenseList.add(createNewExpense("Netflix", ENTERTAINMENT, BigDecimal.valueOf(10)));
        expenseList.add(createNewExpense("Gym", MISC, BigDecimal.valueOf(20)));
        expenseList.add(createNewExpense("Internet", UTILITIES, BigDecimal.valueOf(30)));
        expenseList.add(createNewExpense("Dinner", UTILITIES, BigDecimal.valueOf(30)));
        expenseRepository.insert(expenseList);
    }

    @ChangeSet(order = "002", id = "cs2", author = "Priteela")
    public void addNew(ExpenseRepository expenseRepository) {
        List<ExpenseCollection> expenseList = new ArrayList<>();
        expenseList.add(createNewExpense("TEST", TEST, BigDecimal.valueOf(10)));
        expenseRepository.insert(expenseList);
    }

    private ExpenseCollection createNewExpense(String expenseName, ExpenseCategory expenseCategory, BigDecimal amount) {
        ExpenseCollection expense = new ExpenseCollection();
        expense.setExpenseName(expenseName);
        expense.setExpenseAmount(amount);
        expense.setExpenseCategory(expenseCategory);
        return expense;
    }

}