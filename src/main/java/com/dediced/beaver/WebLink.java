package com.dediced.beaver;

/**
 * Created by cvhu on 7/28/15.
 */
public class WebLink {

    private final long linkId;
    private final String url;
    private final String content;

    public WebLink(long linkId, String url, String content) {
        this.linkId = linkId;
        this.url = url;
        this.content = content;
    }

    public long getLinkId() {
        return linkId;
    }

    public String getUrl() {
        return url;
    }

    public String getContent() {
        return content;
    }


}
