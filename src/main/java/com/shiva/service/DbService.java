package com.shiva.service;

import com.shiva.data.DataBridge;
import com.shiva.model.DataDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@Slf4j
public class DbService {
	@Autowired
	DataBridge dataBridge;

	public void process() {
		Flux<DataDto> dataDtoFlux= dataBridge.getReplaySink().asFlux();
			dataDtoFlux.subscribe(a->{
				//add to list
				// if list size is some limit
				    // savetoDb & empty the list

				//Save ToDb
				log.info("DbService Received new message : {}", a);
			}
		) ;
//		dataDtoFlux.doOnComplete(()->{
//			log.info("Read Operation Completed");
//		});
	}
}
