package org.openfact.testsuite.model;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.TimeZone;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JSR310Module;

public class Test {

    public static void main(String arg[]) throws ParseException, JsonProcessingException {

        /*ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
       
        String eventString1 = mapper.writeValueAsString(LocalDate.now());
        String eventString2 = mapper.writeValueAsString(LocalDateTime.now());
        String eventString3 = mapper.writeValueAsString(LocalTime.MIDNIGHT);
        
        System.out.println(eventString1);
        System.out.println(eventString2);
        System.out.println(eventString3);*/
        
       
    }

    static class Event implements Serializable {
        
        String name;
        LocalDate date;
        LocalDateTime dateTime;
        LocalTime time;

        public Event(String name, LocalDate date, LocalDateTime dateTime, LocalTime time) {
            this.name = name;
            this.date = date;
            this.dateTime = dateTime;
            this.time = time;
        }

    }
}
