package com.getgitman.gitman;
public class TestPlayer 
{
	public static void main(String[] args)
	{
		Player player = new Player();
		Thread input = new Thread(player);
		input.start();
		while(player.status != Player.State.PAUSED)
		{

			System.out.println(player.dir);
			System.out.print("x:"+player.getX()+" y:"+player.getY());
		}
		System.out.println("FIN");
		input.interrupt();
	}
}