package com.codenfast.developersuniverse.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OpenGraph {
    private String url;
    private String siteName;
    private String title;
    private String type;
    private String image;
    private String description;

    private String twitterSite;
    private String twitterTitle;
    private String twitterImage;
    private String twitterDescription;
}
