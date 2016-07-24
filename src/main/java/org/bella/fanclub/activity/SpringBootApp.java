package org.bella.fanclub.activity;

import org.bella.fanclub.activity.controllers.FileUploadController;
import org.bella.fanclub.activity.services.FileService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.util.FileSystemUtils;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by kindai on 22/07/16.
 */
@SpringBootApplication
@ImportResource("classpath:appContext-DAO.xml")
public class SpringBootApp {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(SpringBootApp.class, args);
    }

    @Bean
    CommandLineRunner init() {
        return (args) -> {
            FileSystemUtils.deleteRecursively(new File(FileService.ROOT));

            Files.createDirectory(Paths.get(FileService.ROOT));
        };
    }
}
