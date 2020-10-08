package com.ilkow.willey.tests.api;

import com.ilkow.willey.entities.Page;
import com.ilkow.willey.services.api.HttpBinRequestService;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HttpBinRequestTest {

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
        Assert.assertEquals(page.getTitle(), "test title");
    }

    @Test
    void testGetImageRequestHasProperFormat() {
        byte[] imageRequestResult = httpBinRequestService.getImageRequest();

        Assert.assertEquals(imageRequestResult[0], PNG_HEADER[0]);
        Assert.assertEquals(imageRequestResult[1], PNG_HEADER[1]);
        Assert.assertEquals(imageRequestResult[2], PNG_HEADER[2]);
    }


}
