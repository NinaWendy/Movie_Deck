package com.moringaschool.movie_deck.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

//Model class which is used to map the JSON data into Java objects
public class Result implements Serializable {

    @SerializedName("genre_ids")
    @Expose
    private List<Integer> genreIds = null;
    @SerializedName("original_language")
    @Expose
    private String originalLanguage;
    @SerializedName("original_title")
    @Expose
    private String originalTitle;
    @SerializedName("poster_path")
    @Expose
    private String posterPath;
    @SerializedName("video")
    @Expose
    private Boolean video;
    @SerializedName("vote_average")
    @Expose
    private Double voteAverage;
    @SerializedName("overview")
    @Expose
    private String overview;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("vote_count")
    @Expose
    private Integer voteCount;
    @SerializedName("release_date")
    @Expose
    private String releaseDate;
    @SerializedName("adult")
    @Expose
    private Boolean adult;
    @SerializedName("backdrop_path")
    @Expose
    private String backdropPath;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("popularity")
    @Expose
    private Double popularity;
    @SerializedName("media_type")
    @Expose
    private String mediaType;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("original_name")
    @Expose
    private String originalName;
    @SerializedName("origin_country")
    @Expose
    private List<String> originCountry = null;
    @SerializedName("first_air_date")
    @Expose
    private String firstAirDate;

    public Result() {
    }


    public Result(List<Integer> genreIds, String originalLanguage, String originalTitle, String posterPath, Boolean video, Double voteAverage, String overview, Integer id, Integer voteCount, String releaseDate, Boolean adult, String backdropPath, String title, Double popularity, String mediaType, String name, String originalName, List<String> originCountry, String firstAirDate) {
        super();
        this.genreIds = genreIds;
        this.originalLanguage = originalLanguage;
        this.originalTitle = originalTitle;
        this.posterPath = posterPath;
        this.video = video;
        this.voteAverage = voteAverage;
        this.overview = overview;
        this.id = id;
        this.voteCount = voteCount;
        this.releaseDate = releaseDate;
        this.adult = adult;
        this.backdropPath = backdropPath;
        this.title = title;
        this.popularity = popularity;
        this.mediaType = mediaType;
        this.name = name;
        this.originalName = originalName;
        this.originCountry = originCountry;
        this.firstAirDate = firstAirDate;
    }

    public List<Integer> getGenreIds() {
        return genreIds;
    }

    public void setGenreIds(List<Integer> genreIds) {
        this.genreIds = genreIds;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public Boolean getVideo() {
        return video;
    }

    public void setVideo(Boolean video) {
        this.video = video;
    }

    public Double getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(Double voteAverage) {
        this.voteAverage = voteAverage;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(Integer voteCount) {
        this.voteCount = voteCount;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Boolean getAdult() {
        return adult;
    }

    public void setAdult(Boolean adult) {
        this.adult = adult;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPopularity() {
        return popularity;
    }

    public void setPopularity(Double popularity) {
        this.popularity = popularity;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOriginalName() {
        return originalName;
    }

    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }

    public List<String> getOriginCountry() {
        return originCountry;
    }

    public void setOriginCountry(List<String> originCountry) {
        this.originCountry = originCountry;
    }

    public String getFirstAirDate() {
        return firstAirDate;
    }

    public void setFirstAirDate(String firstAirDate) {
        this.firstAirDate = firstAirDate;
    }

}
