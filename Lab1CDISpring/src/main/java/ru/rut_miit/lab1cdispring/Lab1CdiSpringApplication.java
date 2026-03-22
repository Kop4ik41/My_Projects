package ru.rut_miit.lab1cdispring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.rut_miit.lab1cdispring.Component.AppStart;

@SpringBootApplication
public class Lab1CdiSpringApplication {
    private static ConfigurableApplicationContext context;

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Lab1CdiSpringApplication.class);
        app.setBanner((environment, sourceClass, out) -> out.print("\n\n\timitmod\n\n".toUpperCase()));
        context = app.run(args);
        AppStart appStart = context.getBean(AppStart.class);
        appStart.initArray();
        appStart.start();
    }


}
