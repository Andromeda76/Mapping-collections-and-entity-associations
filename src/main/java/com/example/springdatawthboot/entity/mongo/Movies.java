package com.example.springdatawthboot.entity.mongo;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document(collection = "movies")
public class Movies {
    @Id
    private String id;

    private String accomplishment;

    private String director;

    private String title;

    private Object watched;

    private Integer year;

    private Object comments;

    private String watchedAmerican;

    private Integer commentsAge;

    private String watchedIndian;

    private String commentsEmail;

    private String commentsName;

    private Integer commentsVote;

    private String completeTitle;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccomplishment() {
        return accomplishment;
    }

    public void setAccomplishment(String accomplishment) {
        this.accomplishment = accomplishment;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Object getWatched() {
        return watched;
    }

    public void setWatched(Object watched) {
        this.watched = watched;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Object getComments() {
        return comments;
    }

    public void setComments(Object comments) {
        this.comments = comments;
    }

    public String getWatchedAmerican() {
        return watchedAmerican;
    }

    public void setWatchedAmerican(String watchedAmerican) {
        this.watchedAmerican = watchedAmerican;
    }

    public Integer getCommentsAge() {
        return commentsAge;
    }

    public void setCommentsAge(Integer commentsAge) {
        this.commentsAge = commentsAge;
    }

    public String getWatchedIndian() {
        return watchedIndian;
    }

    public void setWatchedIndian(String watchedIndian) {
        this.watchedIndian = watchedIndian;
    }

    public String getCommentsEmail() {
        return commentsEmail;
    }

    public void setCommentsEmail(String commentsEmail) {
        this.commentsEmail = commentsEmail;
    }

    public String getCommentsName() {
        return commentsName;
    }

    public void setCommentsName(String commentsName) {
        this.commentsName = commentsName;
    }

    public Integer getCommentsVote() {
        return commentsVote;
    }

    public void setCommentsVote(Integer commentsVote) {
        this.commentsVote = commentsVote;
    }

    public String getCompleteTitle() {
        return completeTitle;
    }

    public void setCompleteTitle(String completeTitle) {
        this.completeTitle = completeTitle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movies movies = (Movies) o;
        return Objects.equals(id, movies.id) && Objects.equals(accomplishment, movies.accomplishment) && Objects.equals(director, movies.director) && Objects.equals(title, movies.title) && Objects.equals(watched, movies.watched) && Objects.equals(year, movies.year) && Objects.equals(comments, movies.comments) && Objects.equals(watchedAmerican, movies.watchedAmerican) && Objects.equals(commentsAge, movies.commentsAge) && Objects.equals(watchedIndian, movies.watchedIndian) && Objects.equals(commentsEmail, movies.commentsEmail) && Objects.equals(commentsName, movies.commentsName) && Objects.equals(commentsVote, movies.commentsVote) && Objects.equals(completeTitle, movies.completeTitle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, accomplishment, director, title, watched, year, comments, watchedAmerican, commentsAge, watchedIndian, commentsEmail, commentsName, commentsVote, completeTitle);
    }
}
