package com.live.conferencereview.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;


@Entity(name = "reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long review_id;

    @NotNull(message = "testing")
    @Enumerated(EnumType.STRING)
    private  ReviewType review_type;

    @NotNull
    private Long review_reference;
    private Integer review_grade;
    @NotBlank
    private String review_title;
    private String review_description;
    private String review_username;
    private Date review_date;

    public Review() {

    }

    public Long getReview_id() {
        return review_id;
    }

    public void setReview_id(Long review_id) {
        this.review_id = review_id;
    }

    public ReviewType getReview_type() {
        return review_type;
    }

    public void setReview_type(ReviewType review_type) {
        this.review_type = review_type;
    }

    public Long getReview_reference() {
        return review_reference;
    }

    public void setReview_reference(Long review_reference) {
        this.review_reference = review_reference;
    }

    public Integer getReview_grade() {
        return review_grade;
    }

    public void setReview_grade(Integer review_grade) {
        this.review_grade = review_grade;
    }

    public String getReview_title() {
        return review_title;
    }

    public void setReview_title(String review_title) {
        this.review_title = review_title;
    }

    public String getReview_description() {
        return review_description;
    }

    public void setReview_description(String review_description) {
        this.review_description = review_description;
    }

    public String getReview_username() {
        return review_username;
    }

    public void setReview_username(String review_username) {
        this.review_username = review_username;
    }

    public Date getReview_date() {
        return review_date;
    }

    public void setReview_date(Date review_date) {
        this.review_date = review_date;
    }
}
