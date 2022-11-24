package com.shiva.service;

import com.shiva.data.DataBridge;
import com.shiva.model.DataDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@Slf4j
public class DataService {

    @Autowired
	DataBridge dataBridge;

    public Flux<DataDto> getData() {
		log.info("Processing Data in Db Service");
    	return dataBridge.getReplaySink().asFlux();
	}
}
