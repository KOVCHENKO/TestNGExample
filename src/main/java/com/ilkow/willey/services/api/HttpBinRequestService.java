package com.ilkow.willey.services.api;

import com.ilkow.willey.entities.Page;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

public class HttpBinRequestService extends CommonRequestService {
    private static final Logger LOG = LoggerFactory.getLogger(SearchRequestService.class);
    private static final String URL = "https://httpbin.org";

    public Page postDelayedRequest() {
        JSONObject requestParams = new JSONObject();
        requestParams.put("title", "test title"); // Cast

        RequestSpecification request = RestAssured.given(getRequestSpecification(URL));
        request.body(requestParams.toString());

        LOG.debug("Requesting HttpBin results and verify that request execution time is less than 12s");
        String data = request
                .post("delay/10")
                .then()
                .statusCode(200)
                .and()
                .time(lessThan(12000L))
                .extract()
                .path("data");

        JSONObject jsonData = new JSONObject(data);

        String title = jsonData.get("title").toString();
        Page page = new Page();
        page.setTitle(title);

        return page;
    }

    public byte[] getImageRequest() {
        return given(getRequestSpecification(URL))
                .get("image/png")
                .then()
                .statusCode(200)
                .extract()
                .body()
                .asByteArray();
    }

}
