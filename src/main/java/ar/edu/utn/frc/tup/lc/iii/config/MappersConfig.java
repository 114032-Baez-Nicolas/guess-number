package ar.edu.utn.frc.tup.lc.iii.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MappersConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public ModelMapper mergenMapper() {
        ModelMapper lMapper = new ModelMapper();

        lMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
        return lMapper;
    }

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper lObjectMapper = new ObjectMapper();
        lObjectMapper.registerModule(new JavaTimeModule());
        return lObjectMapper;
    }
}