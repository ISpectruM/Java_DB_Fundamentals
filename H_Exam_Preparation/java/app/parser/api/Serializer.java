package app.parser.api;

import javax.xml.bind.JAXBException;
import java.io.IOException;

/**
 * Created by User on 23.7.2017 г..
 */
public interface Serializer {

    <T> T deserialize(Class<T> className, String fileName) throws IOException, JAXBException;

    <T> void serialize(T t, String fileNameW) throws JAXBException;

    <T> String serialize(T t);
}
