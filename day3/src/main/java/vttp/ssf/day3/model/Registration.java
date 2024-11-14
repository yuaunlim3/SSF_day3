package vttp.ssf.day3.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Registration {


    @NotNull(message = "Name cannot be empty")
    @NotEmpty(message = "Name cannot be empty")
    @Size(min =2, max=32, message ="Name must between 2 to 32 characters")


    private String name;

    @NotNull(message = "Email cannot be empty")
    @NotEmpty(message = "Email cannot be empty")
    @Email(message ="Must be valid email")
    private String email;
    private String comment;
    

    //property name --> name
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    //property name --> email
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    //property name --> comment
    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }
    @Override
    public String toString() {
        return "registration [name=" + name + ", email=" + email + ", comment=" + comment + "]";
    }

    
}
