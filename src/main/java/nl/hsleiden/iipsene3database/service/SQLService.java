package nl.hsleiden.iipsene3database.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Service that gets sql queries from resources.
 * @author Vincent Severin
 */
@Service
public class SQLService {
    Logger logger = LoggerFactory.getLogger(SQLService.class);

    public String getSQLQuery(String filename) {
        try {
            return Files.readString(Paths.get("src/main/resources/sql/" + filename + ".sql"));
        } catch (IOException e) {
            logger.error("SQL Query could not be found", e);
        }
        return "";
    }
}
