package com.ilkow.willey.tests.api;

import com.ilkow.willey.entities.Page;
import com.ilkow.willey.services.api.HttpBinRequestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HttpBinRequestTest {

    private static final Logger LOG = LoggerFactory.getLogger(HttpBinRequestTest.class);
    HttpBinRequestService httpBinRequestService;

    byte[] PNG_HEADER = new byte[] {
            (byte) 0x89,
            'P', 'N', 'G',
            (byte) 0x0D, (byte) 0x0A, (byte) 0x1A, (byte) 0x0A};

    public HttpBinRequestTest() {
        this.httpBinRequestService = new HttpBinRequestService();
    }

    @Test
    void testPostDelayWorksProperly() {
        Page page = httpBinRequestService.postDelayedRequest();

        LOG.debug("Verify that post delay works properly");
        Assert.assertEquals(page.getTitle(), "test title");
    }

    @Test
    void testGetImageRequestHasProperFormat() {
        byte[] imageRequestResult = httpBinRequestService.getImageRequest();

        LOG.debug("Verify that png image has the proper signature");
        Assert.assertEquals(imageRequestResult[0], PNG_HEADER[0]);
        Assert.assertEquals(imageRequestResult[1], PNG_HEADER[1]);
        Assert.assertEquals(imageRequestResult[2], PNG_HEADER[2]);
    }


}
