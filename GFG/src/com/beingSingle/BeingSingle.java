package com.beingSingle;

import java.util.Scanner;

public class BeingSingle {
	public static void main(String[] args) {
		BeingSingle bs = new BeingSingle();
		
		new Thread() {
			public void run() {
				try {
					bs.world();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}.start();
		
		new Thread() {
			public void run() {
				bs.reply();
			}
		}.start();
	}
	
	
	
	
	
	
	
	public synchronized void world() throws InterruptedException {
		wait();
		System.out.println("World : I have a boyfriend!");
	}
	public synchronized void reply() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Abhishek : ");
		String in = sc.nextLine();
		notify();
	}
}
