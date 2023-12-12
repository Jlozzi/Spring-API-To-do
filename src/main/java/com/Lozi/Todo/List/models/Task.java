package com.Lozi.Todo.List.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name = Task.TABLE_NAME)

public class Task {

    public static final String TABLE_NAME = "task";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false, updatable = false)
    private User User;

    @Column(name = "descripition", length = 255, nullable = false)
    @NotNull
    @NotEmpty
    @Size(min = 1, max = 255)
    private String descripition;

    public Task() {
    }

    public Task(Long id, User User, String descripition) {
        this.id = id;
        this.User = User;
        this.descripition = descripition;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return this.User;
    }

    public void setUser(User User) {
        this.User = User;
    }

    public String getDescripition() {
        return this.descripition;
    }

    public void setDescripition(String descripition) {
        this.descripition = descripition;
    }

    public Task id(Long id) {
        setId(id);
        return this;
    }

    public Task User(User User) {
        setUser(User);
        return this;
    }

    public Task descripition(String descripition) {
        setDescripition(descripition);
        return this;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Task other = (Task) obj;
        return Objects.equals(this.id, other.id) && Objects.equals(this.User, other.User) &&
                Objects.equals(this.descripition, other.descripition);

    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
        return result;
    }

}
