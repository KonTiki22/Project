package com.maker.housemaker.view;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.maker.housemaker.Main;

public class Hud {
    public  Stage stage;
    private Viewport viewport;
    private Label res1Label;
    private Label res2Label;
    private Label res1valLabel;
    private Label res2valLabel;
    private Game game;

    public Hud(SpriteBatch sb, final Game game) {
        this.game = game;
        viewport = new FitViewport(Main.V_WIDTH, Main.V_HEIGHT, new OrthographicCamera());
        stage = new Stage(this.viewport, sb);
        Table table = new Table();
        table.top();
        table.setFillParent(true);
        res1Label = new Label("Tree", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        res2Label = new Label("Rock", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        res1valLabel = new Label("5", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        res2valLabel = new Label("5", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        Skin myskin = new Skin(Gdx.files.internal("table/clean-crispy/skin/clean-crispy-ui.json"));


        Button buttonToBuild = new TextButton("ToBuild", myskin, "arcade");
        buttonToBuild.setSize(200, 100);
        buttonToBuild.setPosition(100, 60);
        buttonToBuild.addListener(new InputListener() {
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {

            }

            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                game.setScreen(new GameMapResourceScreen(game));
                return true;
            }
        });


        table.add(res1Label).expandX().padTop(30);
        table.add(res2Label).expandX().padTop(30);
        table.row();
        table.add(res1valLabel).expandX();
        table.add(res2valLabel).expandX();
        stage.addActor(table);
        stage.addActor(buttonToBuild);
        //Gdx.input.setInputProcessor(stage);
    }
}
