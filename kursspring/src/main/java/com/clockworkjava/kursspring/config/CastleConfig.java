package com.clockworkjava.kursspring.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:knightRepository.properties")
@Import(MainConfig.class)
public class CastleConfig {

}
