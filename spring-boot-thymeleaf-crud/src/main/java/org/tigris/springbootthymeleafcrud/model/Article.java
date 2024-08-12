package org.tigris.springbootthymeleafcrud.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "article")
@Data
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "title",length = 128)
    private String title;
    @Column(name = "description",length = 1024)
    private String description;
    @Column(name = "published")
    private boolean published;
    @Column(name = "created_at")
    private LocalDate createdAt;

}
