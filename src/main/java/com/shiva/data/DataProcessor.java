package com.shiva.data;

import com.shiva.model.DataDto;
import com.shiva.service.DbService;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

import java.util.List;
import java.util.function.Consumer;

@Component
@Slf4j
@Getter
public class DataProcessor {

	@Autowired
	DataBridge dataBridge;

	public void publishData(DataDto dataDto) {
		log.info("Publish Data");
	 	dataBridge.fireEvent(dataDto);
	}
//	public void closeStream() {
//		dataBridge.emitComplete();
//	}

}
