package com.wisesoft.frame.core.converter;

import java.text.ParseException;
import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;

public class DateConverter implements Converter<String, Date> {
	
	private Logger log = LoggerFactory.getLogger(DateConverter.class);

	@Override
	public Date convert(String source) {
		try {
			return DateUtils.parseDate(source, "yyyy-MM-dd", "yyyy-MM-dd hh:mm:ss");
		} catch (ParseException e) {
			log.error("时间转换失败 source:" + source, e);
			return null;
		}
	}
}
