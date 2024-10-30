package org.example.springBootMainFolder.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="books")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="book_title", nullable = false, length = 100)
    private String title;

    @Column(name="book_author", nullable = false, length = 100)
    private String author;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Category category;
}