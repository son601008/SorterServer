package com.hust.soict.son.client_server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket = new Socket("127.0.0.1", 9898);
		BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
		System.out.println(in.readLine());
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("Nhap vao 1 day so ngan cach nhau boi dau space:");
			String message = scanner.nextLine();
			if (message == null || message.isEmpty()) {
				break;
			} else {
				out.println(message);
				System.out.println(in.readLine());
			}
		}
		;
		socket.close();
		scanner.close();
	}
}
