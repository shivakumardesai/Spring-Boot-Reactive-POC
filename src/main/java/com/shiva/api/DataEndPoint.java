package com.shiva.api;

import com.shiva.model.DataDto;
import com.shiva.service.DataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;


@Slf4j
@RestController
public class DataEndPoint {

	@Autowired
	DataService dataService;

	@GetMapping(value = "/data", produces = { MediaType.TEXT_EVENT_STREAM_VALUE })
	public Flux<DataDto> getData() {
		log.info("API: Called getData()");
		return dataService.getData();
	}
}
