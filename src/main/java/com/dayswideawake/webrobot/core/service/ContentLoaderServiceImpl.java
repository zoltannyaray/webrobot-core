package com.dayswideawake.webrobot.core.service;

import java.io.IOException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Request;
import org.springframework.stereotype.Service;

import com.dayswideawake.webrobot.core.entity.Site;

@Service
public class ContentLoaderServiceImpl implements ContentLoaderService {

    public String loadContent(Site site) {
        String content = "";
        try {
            content = Request
                    .Get(site.getLocation().getUrl().toString())
                    .execute()
                    .returnContent()
                    .asString();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }

}
