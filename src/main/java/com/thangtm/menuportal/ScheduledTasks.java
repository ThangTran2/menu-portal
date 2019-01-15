package com.thangtm.menuportal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thangtm.menuportal.entity.Meta;
import com.thangtm.menuportal.service.MetaService;

@Component
public class ScheduledTasks {
	
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat(
			"MM/dd/yyyy HH:mm:ss");
	
//	@Autowired
//	private static MetaService metaService;

//	@Scheduled(fixedRate = 10000)
//	public void performTask() {
//
//		System.out.println("Regular task performed at "
//				+ dateFormat.format(new Date()));
//		
//	}
//
//	@Scheduled(initialDelay = 1000, fixedRate = 10000)
//	public void performDelayedTask() {
//
//		System.out.println("Delayed Regular task performed at "
//				+ dateFormat.format(new Date()));
//
//	}
//
//	@Scheduled(cron = "*/5 * * * * *")
//	public void performTaskUsingCron() {
//
//		System.out.println("Regular task performed using Cron at "
//				+ dateFormat.format(new Date()));
//		
//
//	}
	
	
}
