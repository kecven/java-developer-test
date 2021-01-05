package fr.travelfactory.test.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Utils {

    @Autowired
    protected ObjectMapper mapper;

    public String toJson(Object object) throws JsonProcessingException {
        return mapper.writeValueAsString(object);
    }
}
