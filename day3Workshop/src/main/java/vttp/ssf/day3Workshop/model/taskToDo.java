package vttp.ssf.day3Workshop.model;

import java.time.LocalDate;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class taskToDo {


    @NotEmpty(message = "Task cannot be empty")
    @Size(min =2, max=32, message ="Task must between 2 to 32 characters")
    private String task;

    private String priority;

    private LocalDate date =LocalDate.now();;

    public String getTask() {
        return task;
    }
    public void setTask(String task) {
        this.task = task;
    }
    public String getPriority() {
        return priority;
    }
    public void setPriority(String priority) {
        this.priority = priority;
    }
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        if(date != null){
            this.date = date;
        }
    }
    @Override
    public String toString() {
        return "Task [task=" + task + ", priority=" + priority + ", date=" + date + "]";
    }

}
