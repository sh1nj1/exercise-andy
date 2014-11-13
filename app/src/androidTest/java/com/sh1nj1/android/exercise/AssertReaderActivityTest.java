package com.sh1nj1.android.exercise;

import android.test.ActivityInstrumentationTestCase2;

import junit.framework.Assert;

import org.junit.Test;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

/**
 * Created by soonoh on 11/13/14.
 */
public class AssertReaderActivityTest extends ActivityInstrumentationTestCase2<AssertReaderActivity> {

    public AssertReaderActivityTest() {
        super(AssertReaderActivity.class);
    }

    public AssertReaderActivityTest(Class<AssertReaderActivity> activityClass) {
        super(activityClass);
    }

    @Test
    public void test_main() throws ParserConfigurationException, SAXException, IOException {

        String fileName = "a.xml";
        String data = getActivity().readAsset(fileName);

        Assert.assertEquals("<root></root>", data.trim());

        Document doc = getActivity().getDocument(data);

        Assert.assertNotNull(doc);
    }
}
