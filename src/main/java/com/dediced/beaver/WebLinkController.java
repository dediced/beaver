package com.dediced.beaver;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by cvhu on 7/28/15.
 */

@RestController
public class WebLinkController {

    @RequestMapping("/link")
    public WebLink getTestLink(@RequestParam("url") String url) {
        return new WebLink(1234l, url, "content");
    }

}
