package com.maker.housemaker.view;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.maker.housemaker.Main;
import com.maker.housemaker.model.Island;

import java.util.ArrayList;
import java.util.HashMap;

public class GameMapResourceScreen implements Screen {

    private Hud hud;
    private SpriteBatch spriteBatch;
    private OrthographicCamera orthographicCamera;
    private Texture backgroundMap;
    private Texture islandTextureTree;
    private TextField res1Field;
    private Game game;
    private Island island;
    private FitViewport playerViewport;

    ArrayList<Island> islandsArr = new ArrayList();

    public GameMapResourceScreen(Game game) {
        this.game = game;
    }

    @Override
    public void show() {
        spriteBatch = new SpriteBatch();
        this.hud = new Hud(spriteBatch, game);

        orthographicCamera = new OrthographicCamera();
        playerViewport = new FitViewport(Main.V_WIDTH, Main.V_HEIGHT, orthographicCamera);

        backgroundMap = new Texture("backgroundMap.png");
        islandTextureTree = new Texture("islandTree.png");

        Main.resources  = new HashMap<>();
        Main.resources.put("tree", 0);
        Main.resources.put("rock", 0);

        islandsArr.add(new Island("islandTree.png", "tree",Main.V_WIDTH/2, Main.V_HEIGHT/4, Main.V_WIDTH/10, Main.V_WIDTH/10));
        islandsArr.add(new Island("islandRock.png", "rock",Main.V_WIDTH/2, Main.V_HEIGHT/2, Main.V_WIDTH/10, Main.V_WIDTH/10));


        islandTextureTree.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

    }



    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.1f,0.1f,0.7f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        orthographicCamera.update();

        spriteBatch.setProjectionMatrix(hud.stage.getCamera().combined);

        spriteBatch.begin();
        for(Island island: islandsArr) {
            island.draw(spriteBatch);
        }
        spriteBatch.end();
        hud.stage.draw();


        if(Gdx.input.isTouched()) {
            Vector3 touchPos = new Vector3();
            touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            orthographicCamera.unproject(touchPos);
            for(Island island: islandsArr) {
                if (touchPos.x >= island.x && touchPos.x <= island.x + island.width
                        && touchPos.y >= island.y && touchPos.y <= island.y + island.height) {
                    Main.resources.put(island.name, Main.resources.get(island.name) + 1);
                    System.out.println("+1" + island.name);
                }
            }
        }


    }

    @Override
    public void resize(int width, int height) {
        //float aspectRatio = (float) height / width;
        //playerViewport.update(width, height); //update our viewports
        //orthographicCamera = new OrthographicCamera(20f, 20f * aspectRatio);

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        backgroundMap.dispose();
        islandTextureTree.dispose();
        spriteBatch.dispose();
    }
}
