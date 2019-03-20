package com.douzone.springcontainer.soundsystem;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CDPlayer {

	// 와이어링 1
	// 1. 직접 변수에다가 하는 방법
	// @Autowired
	private CompactDisc cd;

	// 와이어링 2
	// 2. 생성자를 만들어서 사용하는 방법
	@Autowired
	public CDPlayer(CompactDisc cd) {
		this.cd = cd;
	}

	// 2, 3번을 같이 사용하기 위해서는 기본 생성자를 생성해 주어야 한다.
	public CDPlayer() {
	}

	// 와이어링 3
	// 3. 메소드를 호출해서 사용하는 방법
//	@Autowired
	public void setCompactDisc(CompactDisc cd) {
		this.cd = cd;
	}

	// 와이어링 4
	// @Autowired
	@Inject
	public void k(CompactDisc cd) {
		this.cd = cd;
	}

	public void play() {
		cd.play();
	}
}
