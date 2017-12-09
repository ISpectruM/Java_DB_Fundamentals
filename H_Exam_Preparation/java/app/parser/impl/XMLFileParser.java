package app.parser.impl;

import app.parser.api.Serializer;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.util.List;

/**
 * Created by User on 23.7.2017 г..
 */
@Component(value = "XMLParser")
public class XMLFileParser implements Serializer {
    private JAXBContext jaxbContext;

    @Override
    public <T> T deserialize(Class<T> className, String fileName) throws JAXBException {
        this.jaxbContext = JAXBContext.newInstance(className);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        File file = new File(fileName);
        return (T) unmarshaller.unmarshal(file);
    }


    @Override
    public <T> void serialize(T t, String fileName) throws JAXBException {
        this.jaxbContext = JAXBContext.newInstance(t.getClass());
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
        marshaller.marshal(t, new File(fileName));
    }

    @Override
    public <T> String serialize(T t) {
        //impl
        return null;
    }
}
