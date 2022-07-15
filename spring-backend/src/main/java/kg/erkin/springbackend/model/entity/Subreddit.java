package kg.erkin.springbackend.model.entity;

import kg.erkin.springbackend.model.entity.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.Instant;
import java.util.List;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "subreddit")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Subreddit implements BaseEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @NotBlank(message = "Community name is required")
    @Column(name = "name")
    private String name;

    @NotBlank(message = "Description is required")
    @Column(name = "description")
    private String description;

    @OneToMany(fetch = LAZY, mappedBy = "subreddit")
    private List<Post> posts;

    @Column(name = "created_date")
    private Instant createdDate;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    private User user;
}
