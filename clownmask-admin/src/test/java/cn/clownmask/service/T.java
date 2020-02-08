package cn.clownmask.service;

import java.util.Scanner;

public class T {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int lightX = in.nextInt(); // the X position of the light of power
        int lightY = in.nextInt(); // the Y position of the light of power
        int initialTx = in.nextInt(); // Thor's starting X position
        int initialTy = in.nextInt(); // Thor's starting Y position

        // game loop
        while (true) {
            int remainingTurns = in.nextInt(); // The remaining amount of turns Thor can move. Do not remove this line.
            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");
            int x = lightX - initialTx;
            int y = lightY - initialTy;
            String d = "";
            d = (initialTy>lightY) ? "N" : "S";
            d +=(initialTx>lightX) ? "W" : "E";

            // A single line providing the move to be made: N NE E SE S SW W or NW
            System.out.println(d);
        }
	}
}
