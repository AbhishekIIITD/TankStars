package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.TestGame;

public class ResumeScreen implements Screen {
    private TestGame game;
    private Texture BgroundText; //texture 1

    private OrthographicCamera GameCam;
    private Viewport GamePort;

    private Texture Bground; // texture 2

    private BitmapFont font;

    private Texture Games1;
    private Texture Games2;
    private Texture Games3;
    private Texture Games4;

    private Stage stage;

    public TestGame getGame() {
        return game;
    }

    public void setGame(TestGame game) {
        this.game = game;
    }

    public Texture getTexture() {
        return BgroundText;
    }

    public void setTexture(Texture texture) {
        this.BgroundText = texture;
    }

    public OrthographicCamera getGameCam() {
        return GameCam;
    }

    public void setGameCam(OrthographicCamera gameCam) {
        GameCam = gameCam;
    }

    public Viewport getGamePort() {
        return GamePort;
    }

    public void setGamePort(Viewport gamePort) {
        GamePort = gamePort;
    }

    public Texture getBground() {
        return Bground;
    }

    public void setBground(Texture bground) {
        Bground = bground;
    }

    public BitmapFont getFont() {
        return font;
    }

    public void setFont(BitmapFont font) {
        this.font = font;
    }

    public ResumeScreen(TestGame game) {
        this.game = game;
        this.BgroundText = new Texture("resumebg_text.png");
        this.Bground = new Texture("resumebg.png");
        this.font = new BitmapFont();
        this.GameCam = new OrthographicCamera();
        this.GameCam.setToOrtho(false,TestGame.V_WIDTH,TestGame.V_HEIGHT);
        this.GamePort = new StretchViewport(TestGame.V_WIDTH,TestGame.V_HEIGHT,this.GameCam);
        this.getFont().getData().scale(1.25f);
        this.Games1 = new Texture("resumebg1.png");
        this.Games2 = new Texture("resumebg2.png");
        this.Games3 = new Texture("resumebg3.png");
        this.Games4 = new Texture("resumebg4.png");
        stage=new Stage(GamePort);
        Gdx.input.setInputProcessor(stage);
        Skin mySkin = new Skin(Gdx.files.internal("shade/skin/uiskin.json"));
        ImageButton button2 = new ImageButton(mySkin);
        button2.setSize(30,30);
        button2.getStyle().imageUp = new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("back.png"))));
        button2.getStyle().imageDown = new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("back2.png"))));
        button2.setPosition(10,getGameCam().viewportHeight - 50);
        button2.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                mainMenuScreen m1 = new mainMenuScreen(getGame(),new PlayScreen(getGame()));
                getGame().setScreen(m1);
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        stage.addActor(button2);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        //tell our game batch where our Camera is in game

        game.getBatch().setProjectionMatrix(this.getGameCam().combined);
        game.getBatch().begin();
        game.getBatch().draw(Bground,0,0,getGameCam().viewportWidth,getGameCam().viewportHeight);
        game.getBatch().draw(BgroundText,62.5f,250,832.5f,468.75f);
        game.getBatch().draw(Games1,-90,155);
        game.getBatch().draw(Games2,375,149);
        game.getBatch().draw(Games3,-86,-75);
        game.getBatch().draw(Games4,370,-68);
        game.getBatch().end();

        stage.act();
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        GamePort.update(width,height);
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
        stage.dispose();
    }
}
