package com.issamelasri.moneymanager.ui.pojo;

import com.issamelasri.moneymanager.AddActivity;

public class PostModel {
    AddActivity addActivity = new AddActivity();
    private int userId;
    private int id;
    private String title;
    private String body;
    private int incomes, expenses;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getIncomes() {
        incomes = Integer.parseInt(addActivity.getTextAmount().toString());

        return incomes;
    }

    public int getExpenses() {
        expenses = Integer.parseInt(addActivity.getType());
        return expenses;
    }


}
