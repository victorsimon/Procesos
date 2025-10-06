package com.example.procesos.infrastructure.data.config;

import com.example.procesos.application.util.validator.ProcessAlwaysValidValidator;
import com.example.procesos.domain.port.out.ProcessRepository;
import com.example.procesos.domain.validation.ProcessValidator;
import com.example.procesos.infrastructure.data.ProcessSQLRepository;
import com.example.procesos.infrastructure.data.jpa.entity.ProcessJpaRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataConfig {
    @Bean
    public ProcessRepository processRepository(ProcessJpaRepository processJpaRepository) {
        return new ProcessSQLRepository(processJpaRepository);
    }

    @Bean
    public ProcessValidator processValidator() {
        return new ProcessAlwaysValidValidator();
    }
}
