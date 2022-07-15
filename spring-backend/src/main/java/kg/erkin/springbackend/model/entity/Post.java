package kg.erkin.springbackend.model.entity;

import kg.erkin.springbackend.model.entity.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.Instant;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "post")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Post implements BaseEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long postId;

    @NotBlank(message = "Post Name cannot be empty or Null")
    @Column(name = "post_name")
    private String postName;

    @Nullable
    @Column(name = "url")
    private String url;

    @Nullable
    @Lob
    @Column(name = "description")
    private String description;

    @Column(name = "vote_count")
    private Integer voteCount = 0;

    @ManyToOne(targetEntity = User.class, fetch = LAZY)
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    private User user;

    @Column(name = "created_date")
    private Instant createdDate;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "id", referencedColumnName = "id")
    private Subreddit subreddit;
}
