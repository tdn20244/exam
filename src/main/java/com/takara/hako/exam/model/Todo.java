package com.takara.hako.exam.model;

/**
 * @author cyourin
 * @create 2019-02-27-14:14
 */

import io.swagger.annotations.ApiModel;

import javax.validation.constraints.Size;
import java.util.Date;

@ApiModel(description = "todo对象类")
public class Todo {
    private int id;

    private String user;

    @Size(min = 5, message = "请至少输入5个字符.")
    private String desc;

    private Date targetDate;
    private boolean isDone;

    public Todo() {
        super();
    }

    public Todo(int id, String user, String desc, Date targetDate,
                boolean isDone) {
        super();
        this.id = id;
        this.user = user;
        this.desc = desc;
        this.targetDate = targetDate;
        this.isDone = isDone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Date getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(Date targetDate) {
        this.targetDate = targetDate;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean isDone) {
        this.isDone = isDone;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (obj == null){
            return false;
        }
        if (getClass() != obj.getClass()){
            return false;
        }
        Todo other = (Todo) obj;
        return id == other.id;
    }

    @Override
    public String toString() {
        return String.format(
                "Todo [id=%s, user=%s, desc=%s, targetDate=%s, isDone=%s]", id,
                user, desc, targetDate, isDone);
    }

}
