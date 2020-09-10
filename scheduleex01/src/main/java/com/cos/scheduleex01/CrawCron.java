package com.cos.scheduleex01;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CrawCron {

	// 초(0-59) 분(0-59) 시간(0-23) 일(1-31) 월(1-12) 요일(0-7)
	@Scheduled(cron = "10 * * * * *")
	public void cronJob() { // OS가 들고있는 crontap 명령어를 들고와서 씀
		System.out.println("매분 10초마다 자동 실행");
	}
}
