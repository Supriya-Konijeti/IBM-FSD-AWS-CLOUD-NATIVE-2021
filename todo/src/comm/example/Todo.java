package comm.example;

import java.util.Date;

public class Todo {
    private String todoId;
    private String desc;
    private Date targetDate;
    private boolean isDone;

    public Todo() {
    }

    public Todo(String todoId, String desc, Date targetDate, boolean isDone) {
        this.todoId = todoId;
        this.desc = desc;
        this.targetDate = targetDate;
        this.isDone = isDone;
    }

    public String getTodoId() {
        return todoId;
    }

    public void setTodoId(String todoId) {
        this.todoId = todoId;
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

    public void setDone(boolean done) {
        isDone = done;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "todoId='" + todoId + '\'' +
                ", desc='" + desc + '\'' +
                ", targetDate=" + targetDate +
                ", isDone=" + isDone +
                '}';
    }
}

