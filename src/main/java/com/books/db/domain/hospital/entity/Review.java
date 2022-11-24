package com.books.db.domain.hospital.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "hospital_review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;
    private String userName;

    @ManyToOne
    @JoinColumn(name = "hospital_id")
    private Hospital hospital;

    public Review(Hospital hospital, String reviewTitle, String reviewAuthor, String reviewContent) {
        this.hospital = hospital;
        this.title = reviewTitle;
        this.userName = reviewAuthor;
        this.content = reviewContent;
    }
}
