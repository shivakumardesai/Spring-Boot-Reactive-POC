package com.shiva.data;

import com.shiva.model.DataDto;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Sinks;

@Component
@Getter
@Setter
@Slf4j
public class DataBridge {

	//FIXME : may result in OutOfMemory
	public Sinks.Many<DataDto> replaySink= Sinks.many().replay().limit(500);

//	//1
//	public void init() {
//		replaySink = Sinks.many().replay().limit(500);
//	}


	//2 ....n-1
	public void fireEvent(DataDto dataDto) {

		log.info("FireEvent {}",dataDto);
		replaySink.emitNext(dataDto, Sinks.EmitFailureHandler.FAIL_FAST);
	}


//	//n
//	public void emitComplete() {
//		replaySink.tryEmitComplete();
//	}

}
