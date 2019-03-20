package com.douzone.springcontainer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.douzone.springcontainer.soundsystem.CDPlayer;
import com.douzone.springcontainer.soundsystem.CompactDisc;
import com.douzone.springcontainer.user.User;
import com.douzone.springcontainer.videosystem.DVDPlayer;
import com.douzone.springcontainer.videosystem.DigitalVideoDisc;

import config.mixing.videosystem.DVDPlayerConfig;
import config.mixing.videosystem.VideoSystemConfig;
import config.user.AppConfig01;

public class JavaConfigTest {

	public static void main(String[] args) {
//		testJavaConfigTest01();
//		testJavaConfigTest02();
//		testJavaConfigTest03();
		
		//DVD
//		testJavaConfig04();
		
		//Mixing
		testJavaConfig05();
		testJavaConfig06();
	}

	// Java Config 01
	// 설정 자바 클래스가 있는 베이스 패키지를 지정하는 방법
	// 설정 자바 클래스에 @Configuration 필요 없음
	public static void testJavaConfigTest01() {
		ApplicationContext appCtx =
				// 클래스가 어디 있는지 직접 설정
				new AnnotationConfigApplicationContext(AppConfig01.class);

		User user = appCtx.getBean(User.class);
		System.out.println(user);
		((ConfigurableApplicationContext)appCtx).close();
		
	}

	// Java Config 02
	// 설정 자바 클래스가 있는 베이스 패키지를 지정하는 방법
	// config.user 패키지에 @Configuration 어노테이션을 찾는다.
	public static void testJavaConfigTest02() {
		ApplicationContext appCtx = 
				new AnnotationConfigApplicationContext("config.user");
		
		User user = appCtx.getBean(User.class);
		System.out.println(user);
	
		((ConfigurableApplicationContext)appCtx).close();
		
		
	}
	// Java Config 03 - 자동설정
	// Component Scanning ( @Component, @Autowird )
	public static void testJavaConfigTest03() {
		ApplicationContext appCtx = 
				new AnnotationConfigApplicationContext("config.soundsystem");
		
		CompactDisc cd = appCtx.getBean(CompactDisc.class);
		System.out.println( cd );
	
		cd = (CompactDisc)appCtx.getBean("blueBlood");
		System.out.println(cd);
		
		CDPlayer cdPlayer = appCtx.getBean(CDPlayer.class);
		cdPlayer.play();
		
		((ConfigurableApplicationContext)appCtx).close();
		
	}
	
	// Java Config 04 - 명시적 설정
	// ComponentScan을 사용하지 않음
	// Java Config Class의 메소드와 @Bean를 사용
	public static void testJavaConfig04() {
		ApplicationContext appCtx = 
				new AnnotationConfigApplicationContext("config.videosystem");
		
		
		DigitalVideoDisc dvd = appCtx.getBean(DigitalVideoDisc.class);
		System.out.println(dvd);
		
		DVDPlayer dvdPlayer = appCtx.getBean(DVDPlayer.class);
		dvdPlayer.play();
		
		
		// name("dvdPlayer2")를 사용
//		DVDPlayer dvdPlayer = (DVDPlayer) appCtx.getBean("dvdPlayer2");
//		dvdPlayer.play();
		
		((ConfigurableApplicationContext)appCtx).close();
		
	}
   
	/*
	 *  Mixing
	 */
	
	// Java Config 05 - mixing 01
	// Java Config <- Java Config
	// DVDPlayer   <- DVD
	public static void testJavaConfig05() {
		ApplicationContext appCtx = 
				new AnnotationConfigApplicationContext(DVDPlayerConfig.class);
		
		
		DVDPlayer dvdPlayer = appCtx.getBean(DVDPlayer.class);
		dvdPlayer.play();
		
		((ConfigurableApplicationContext)appCtx).close();
	}
	
	
	// Java Config 06 - mixing 02
	// Java Config <- Java Config + Java Config
	public static void testJavaConfig06() {
		ApplicationContext appCtx = 
				new AnnotationConfigApplicationContext(VideoSystemConfig.class);
		
		
		DVDPlayer dvdPlayer = appCtx.getBean(DVDPlayer.class);
		dvdPlayer.play();
		
		((ConfigurableApplicationContext)appCtx).close();
	}
	
	
	// Java Config 07 - mixing 03
	// Java Config <- Java Config + XML Config
	public static void testJavaConfig07() {
				
	}
	
	// Java Config 08 - mixing 04
	// Java Config <- XML Config
	public static void testJavaConfig08() {
			
	}
}
