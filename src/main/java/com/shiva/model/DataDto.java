package com.shiva.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class DataDto {

	String name;

	LocalDateTime localDateTime = LocalDateTime.now();


}
