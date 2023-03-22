package main;
import java.io.*;


public class ConsoleColor {
	public static final String red = "\u001B[31m";
	public static final String blue = "\u001B[34m";
	public static final String green = "\u001B[32m";
	public static final String yellow = "\u001B[33m";
	public static final String cyan = "\u001B[36m";
	public static final String exit = "\u001B[0m";
	
	public static void main(String[] args) {
		System.out.println(red+"Hi"+exit);
		System.out.println(blue+"Hi"+exit);
		System.out.println(green+"Hi"+exit);
		System.out.println(yellow+"Hi"+exit);
		System.out.println(cyan+"Hi"+exit);
		System.out.println("Hi");
	}

}
