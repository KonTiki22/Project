package com.maker.housemaker;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.maker.housemaker.view.GameBuildScreen;
import com.maker.housemaker.view.GameMapResourceScreen;

import java.util.HashMap;

import javax.xml.soap.Text;

public class Main extends Game {
	
	private Screen gameScreen;

	public static final int V_WIDTH = 800;
	public static final int V_HEIGHT = 400;
	public Game game;
	public static HashMap<String, Integer> resources;

	@Override
	public void create (){
		game = this;
		//gameScreen = new GameBuildScreen();

		setScreen(new GameMapResourceScreen(game));
	}

}
