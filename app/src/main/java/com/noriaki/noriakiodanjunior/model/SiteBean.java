package com.noriaki.noriakiodanjunior.model;

/**
 * Created by Noriaki on 18/01/2015.
 */
public class SiteBean {
    private int logo;
    private String name;
    private String url;
    private String urlApp;

    public SiteBean(int logo, String name, String url, String urlApp) {
        this.logo = logo;
        this.name = name;
        this.url = url;
        this.urlApp = urlApp;
    }

    public int getLogo() {
        return logo;
    }

    public void setLogo(int logo) {
        this.logo = logo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String toString() {
        return name;
    }

    public String getUrlApp() {
        return urlApp;
    }

    public void setUrlApp(String urlApp) {
        this.urlApp = urlApp;
    }
}
