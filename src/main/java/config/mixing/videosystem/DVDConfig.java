package config.mixing.videosystem;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.douzone.springcontainer.videosystem.Avengers;
import com.douzone.springcontainer.videosystem.BlankDisk;

@Configuration
public class DVDConfig {
	@Bean
	public Avengers avengers() {
		return new Avengers();
	}
	
	@Bean(name="avengersInfinityWar")
	public BlankDisk blankDisc() {
		BlankDisk blankDisc = new BlankDisk();
		// 프로퍼티 설정, set 사용
		blankDisc.setTitle("Avengers Infinity War");
		blankDisc.setStudio("MARVEL");
		blankDisc.setActors( Arrays.asList("Robert Downey Jr.","Josh Brolin","Chris Hemsworth"));
		return blankDisc;
	}
}
