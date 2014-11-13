package com.sh1nj1.android.exercise;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;


public class AssertReaderActivity extends ActionBarActivity {

    private static final String TAG = AssertReaderActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assertreader);
        try {
            String fileName = "a.xml";
            String data = readAsset(fileName);
            Document doc = getDocument(data);
            Log.d(TAG, "doc="+doc);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }


    String readAsset(String fileName) throws IOException, ParserConfigurationException, SAXException {
        InputStream in = getAssets().open(fileName);
        byte[] data = new byte[in.available()];

        DataInputStream dIn = new DataInputStream(in);
        dIn.readFully(data);
        dIn.close();
        in.close();

        return new String(data);
    }

    Document getDocument(String xmlString) throws ParserConfigurationException, IOException, SAXException {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        ByteArrayInputStream in = new ByteArrayInputStream(xmlString.getBytes());

        Document doc = builder.parse(in);
        return doc;
    }

}
