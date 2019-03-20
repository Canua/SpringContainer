package config.videosystem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.douzone.springcontainer.videosystem.Avengers;
import com.douzone.springcontainer.videosystem.DVDPlayer;
import com.douzone.springcontainer.videosystem.DigitalVideoDisc;

@Configuration
public class VideoSystemConfig {
	
	@Bean
	public Avengers avengers() {
		return new Avengers();
	}
	
//	@Bean 
	// 메소드가 두개 생기는 좋지 않은 방법
	public DVDPlayer dvdPlayer() {
		return new DVDPlayer(avengers());
	}
	
//	@Bean
//  DVDPlayer 추천 방법
//	public DVDPlayer dvdPlayer(DigitalVideoDisc dvd) {
//		return new DVDPlayer( dvd );
//	}
	
	// 같은 메소드를 실행 시켰을 때에는 어벤져스가 두개 생기기 떄문에 싱긑톤에 위배된다. -> Error!
	// 싱글톤을 지키기 위해 name을 준다.
//	@Bean(name="dvdPlayer1")
//	public DVDPlayer dvdPlayer1() {
//		return new DVDPlayer(avengers());
//	}
//	@Bean(name="dvdPlayer2")
//	public DVDPlayer anotherdvdPlayer1() {
//		return new DVDPlayer(avengers());
//	}
	
	
	
//	@Bean
	public DVDPlayer dvdPlayer1() {
		return new DVDPlayer(avengers());
	}
	
	@Bean
	public DVDPlayer dvdPlayer(DigitalVideoDisc dvd) {
		DVDPlayer dvdPlayer = new DVDPlayer();
		dvdPlayer.setDigitalVideoDisc(dvd);
		return dvdPlayer;
	}
}
