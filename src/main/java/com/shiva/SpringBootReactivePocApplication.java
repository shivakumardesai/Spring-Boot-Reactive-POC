package com.shiva;

import com.shiva.reader.DataReader;

import com.shiva.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class SpringBootReactivePocApplication implements CommandLineRunner {


	@Autowired
	DataReader dataReader;

	@Autowired
	DbService dbService;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootReactivePocApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		dataReader.readData();

		dbService.process();
	}

}
