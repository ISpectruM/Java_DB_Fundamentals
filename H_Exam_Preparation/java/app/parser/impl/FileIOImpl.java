package app.parser.impl;

import app.parser.api.FileIO;
import org.springframework.stereotype.Component;

import java.io.*;

/**
 * Created by User on 23.7.2017 г..
 */
@Component
public class FileIOImpl implements FileIO {

    @Override
    public String read(String fileName) throws IOException {
        InputStream inputStream = new FileInputStream(fileName);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder sb = new StringBuilder();
        String line="";
        while ((line = reader.readLine()) != null){
            sb.append(line);
        }
        return sb.toString();
    }

    @Override
    public void write(String fileName, String content) throws IOException {

    }
}
