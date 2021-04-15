package com.maker.housemaker.view;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.loader.G3dModelLoader;
import com.badlogic.gdx.graphics.g3d.loader.ObjLoader;
import com.badlogic.gdx.graphics.g3d.utils.CameraInputController;
import com.badlogic.gdx.utils.UBJsonReader;

public class GameBuildScreen implements Screen {

    private Hud hud;
    private Game game;
    private SpriteBatch spriteBatch;

    private Texture texture;
    private ModelBatch modelBatch;
    public PerspectiveCamera perspectiveCamera;

    private ModelInstance modelInstance;


    public GameBuildScreen(Game game) {
        this.game = game;
    }

    @Override
    public void show() {
        spriteBatch = new SpriteBatch();
        hud = new Hud(spriteBatch, game);
        modelBatch = new ModelBatch();
        perspectiveCamera = new PerspectiveCamera(67, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        perspectiveCamera.position.set(-8000, 7000,-9000);
        perspectiveCamera.lookAt(0,0,0);
        perspectiveCamera.far = 100000;
        perspectiveCamera.near = 0.001f;
        CameraInputController cameraController = new CameraInputController(perspectiveCamera);
        cameraController.autoUpdate = true;
        cameraController.scrollFactor = -10;
        //Gdx.input.setInputProcessor(cameraController);

        UBJsonReader jsonreader = new UBJsonReader();
        G3dModelLoader loader = new G3dModelLoader(jsonreader);

        modelInstance = new ModelInstance(loader.loadModel(Gdx.files.getFileHandle("build.g3db", Files.FileType.Internal)));
        modelInstance.transform.scale(0.3f, 0.3f, 0.3f);

    }

    @Override
    public void render(float delta) {
        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
        perspectiveCamera.update();
        spriteBatch.setProjectionMatrix(hud.stage.getCamera().combined);


        modelBatch.begin(perspectiveCamera);
        modelBatch.render(modelInstance);
        modelBatch.end();
        hud.stage.draw();

    }


    @Override
    public void resize(int width, int height) {

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

    }
}
