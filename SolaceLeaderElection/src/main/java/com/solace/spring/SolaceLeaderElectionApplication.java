package com.solace.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import community.solace.spring.integration.leader.aspect.LeaderAware;

@SpringBootApplication
@EnableScheduling
public class SolaceLeaderElectionApplication {

	@Autowired
	StreamBridge sb;
	
	public static void main(String[] args) {
		SpringApplication.run(SolaceLeaderElectionApplication.class, args);
	}
	
    @Scheduled(fixedRate = 3000)
    @LeaderAware("leaderGroupName")
    void leaderTesting() {
        System.out.println("I am the leader and print it every 3 seconds");
        //Send a message to "wherever" topic with "whatever payload 
        sb.send("wherever", "whatever");
    }
    
}
