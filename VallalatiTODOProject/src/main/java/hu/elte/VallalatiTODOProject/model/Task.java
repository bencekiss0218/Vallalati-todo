package hu.elte.VallalatiTODOProject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String description;

    @Column
    @CreationTimestamp
    private LocalDateTime duedate;

    @Column
    @NotNull
    private String name;

    @Column
    @NotNull
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column
    @NotNull
    @Enumerated(EnumType.STRING)
    private Priority priority;

    public enum Status {
        NEW, IN_WORK, ON_HOLD , DONE
    }

    public enum Priority {
        LOW, MEDIUM, HIGH
    }

    @Column
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column
    @UpdateTimestamp
    private LocalDateTime modifiedAt;

    @OneToMany(mappedBy = "task")
    private List<Comment> comments;

    @ManyToOne
    @JsonIgnore
    private User user;

    @ManyToMany
    private List<Label> labels;
}
