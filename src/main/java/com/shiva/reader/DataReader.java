package com.shiva.reader;

import com.shiva.data.DataProcessor;
import com.shiva.model.DataDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Slf4j
public class DataReader {

	@Autowired
	DataProcessor dataProcessor;

	@Async
	public void readData() {
		for(int i=0;i<10;i++) {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			dataProcessor.publishData(DataDto.builder().localDateTime(LocalDateTime.now()).name("Data ").build());
		}
	}
}
