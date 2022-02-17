package com.gytar.mybestyoutube.data;

public enum Categories {
    FILM(1, "Films & Animation"),
    VEHICLES(2, "Auto & Vehicles"),
    MUSIC(3, "Music"),
    ANIMALS(4, "Pets & Animals"),
    SPORTS(5, "Sports"),
    TRAVEL(6, "Travel & Events"),
    GAMING(7, "Gaming"),
    BLOGS(8, "People & Blog"),
    COMEDY(9, "Comedy"),
    ENTERTAINMENT(10, "Entertainment"),
    NEWS(11, "News & Politics"),
    LIFESTYLE(12, "Howto & Lifestyle"),
    EDUCATION(13, "Education"),
    SCIENCE(14, "Science & Technology"),
    NONPROFITS(15, "Nonprofits & Activism");

    private Integer id;
    private String label;

    Categories(Integer id, String label) {
        this.id = id;
        this.label = label;
    }

    public Integer getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }
}
