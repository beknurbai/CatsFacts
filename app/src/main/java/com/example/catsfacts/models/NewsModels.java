package com.example.catsfacts.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class NewsModels {

    @SerializedName("totalItems")
    @Expose
    private Integer totalItems;
    @SerializedName("endIndex")
    @Expose
    private Integer endIndex;
    @SerializedName("startIndex")
    @Expose
    private Integer startIndex;
    @SerializedName("itemsPerPage")
    @Expose
    private Integer itemsPerPage;
    @SerializedName("items")
    @Expose
    private List<Item> items = null;

    public Integer getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(Integer totalItems) {
        this.totalItems = totalItems;
    }

    public Integer getEndIndex() {
        return endIndex;
    }

    public void setEndIndex(Integer endIndex) {
        this.endIndex = endIndex;
    }

    public Integer getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(Integer startIndex) {
        this.startIndex = startIndex;
    }

    public Integer getItemsPerPage() {
        return itemsPerPage;
    }

    public void setItemsPerPage(Integer itemsPerPage) {
        this.itemsPerPage = itemsPerPage;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

}


 class Item {

    @SerializedName("essay")
    @Expose
    private List<String> essay = null;
    @SerializedName("place_of_publication")
    @Expose
    private String placeOfPublication;
    @SerializedName("start_year")
    @Expose
    private Integer startYear;
    @SerializedName("publisher")
    @Expose
    private String publisher;
    @SerializedName("county")
    @Expose
    private List<String> county = null;
    @SerializedName("edition")
    @Expose
    private Object edition;
    @SerializedName("frequency")
    @Expose
    private String frequency;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("subject")
    @Expose
    private List<String> subject = null;
    @SerializedName("city")
    @Expose
    private List<String> city = null;
    @SerializedName("language")
    @Expose
    private List<String> language = null;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("holding_type")
    @Expose
    private List<String> holdingType = null;
    @SerializedName("end_year")
    @Expose
    private Integer endYear;
    @SerializedName("alt_title")
    @Expose
    private List<String> altTitle = null;
    @SerializedName("note")
    @Expose
    private List<String> note = null;
    @SerializedName("lccn")
    @Expose
    private String lccn;
    @SerializedName("state")
    @Expose
    private List<String> state = null;
    @SerializedName("place")
    @Expose
    private List<String> place = null;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("title_normal")
    @Expose
    private String titleNormal;
    @SerializedName("oclc")
    @Expose
    private String oclc;

    public List<String> getEssay() {
        return essay;
    }

    public void setEssay(List<String> essay) {
        this.essay = essay;
    }

    public String getPlaceOfPublication() {
        return placeOfPublication;
    }

    public void setPlaceOfPublication(String placeOfPublication) {
        this.placeOfPublication = placeOfPublication;
    }

    public Integer getStartYear() {
        return startYear;
    }

    public void setStartYear(Integer startYear) {
        this.startYear = startYear;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public List<String> getCounty() {
        return county;
    }

    public void setCounty(List<String> county) {
        this.county = county;
    }

    public Object getEdition() {
        return edition;
    }

    public void setEdition(Object edition) {
        this.edition = edition;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getSubject() {
        return subject;
    }

    public void setSubject(List<String> subject) {
        this.subject = subject;
    }

    public List<String> getCity() {
        return city;
    }

    public void setCity(List<String> city) {
        this.city = city;
    }

    public List<String> getLanguage() {
        return language;
    }

    public void setLanguage(List<String> language) {
        this.language = language;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getHoldingType() {
        return holdingType;
    }

    public void setHoldingType(List<String> holdingType) {
        this.holdingType = holdingType;
    }

    public Integer getEndYear() {
        return endYear;
    }

    public void setEndYear(Integer endYear) {
        this.endYear = endYear;
    }

    public List<String> getAltTitle() {
        return altTitle;
    }

    public void setAltTitle(List<String> altTitle) {
        this.altTitle = altTitle;
    }

    public List<String> getNote() {
        return note;
    }

    public void setNote(List<String> note) {
        this.note = note;
    }

    public String getLccn() {
        return lccn;
    }

    public void setLccn(String lccn) {
        this.lccn = lccn;
    }

    public List<String> getState() {
        return state;
    }

    public void setState(List<String> state) {
        this.state = state;
    }

    public List<String> getPlace() {
        return place;
    }

    public void setPlace(List<String> place) {
        this.place = place;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitleNormal() {
        return titleNormal;
    }

    public void setTitleNormal(String titleNormal) {
        this.titleNormal = titleNormal;
    }

    public String getOclc() {
        return oclc;
    }

    public void setOclc(String oclc) {
        this.oclc = oclc;
    }

}

