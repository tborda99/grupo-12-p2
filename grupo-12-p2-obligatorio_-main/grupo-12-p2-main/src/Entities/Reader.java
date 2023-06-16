package Entities;

import Entities.HashTag;
import Entities.Tweet;
import Entities.Usuario;


import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;

public class Reader {
    public void readCSV(String file_path) {
        try (CSVParser parser = CSVParser.parse(new FileReader(file_path), CSVFormat.DEFAULT.withFirstRecordAsHeader())) {
            for (CSVRecord record : parser) {
                Usuario usuario_aux = new Usuario();
                Tweet tweet_axu = new Tweet();
                for (String header : parser.getHeaderMap().keySet()) {
                    if(header == null){
                        //Numero Usuario
                        long id = Long.parseLong(record.get(header));
                        usuario_aux.setId(id);
                    } else if (header == "user_name") {
                        usuario_aux.setName(record.get(header));
                    }
                    //String value = record.get(header);
                    //System.out.println(header + ": " + value);
                }
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}










