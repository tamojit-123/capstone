package com.codeusingjava;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.codeusingjava.service.FilesStoreService;

@SpringBootApplication
public class SpringBootFileUploadingApplication implements CommandLineRunner {
  @Resource
  FilesStoreService storageService;

  public static void main(String[] args) {
    SpringApplication.run(SpringBootFileUploadingApplication.class, args);
  }


  @Override
  public void run(String... arg) throws Exception {
    storageService.deleteAll();
    storageService.init();
  }
}
