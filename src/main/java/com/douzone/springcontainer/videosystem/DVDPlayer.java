package com.douzone.springcontainer.videosystem;

public class DVDPlayer {
	private DigitalVideoDisc dvd;

	// 생성자 생성
	public DVDPlayer() {
	}

	public DVDPlayer(DigitalVideoDisc dvd) {
		this.dvd = dvd;
	}

	public void play() {
		dvd.play();
	}

	public void setDigitalVideoDisc(DigitalVideoDisc dvd) {
		this.dvd = dvd;
	}
}
