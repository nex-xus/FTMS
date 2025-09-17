package com.ftms.Config;

import org.mapstruct.MapperConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperConfig(componentModel = "com.ftms.Mapper")
public class AppConfig {
}