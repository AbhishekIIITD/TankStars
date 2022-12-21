package com.mygdx.game.Screens;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.TestGame;


public class mainMenuScreen implements Screen {

    public static final Color YELLOW = new Color(0xffff00ff);
    public static final Color SKY = new Color(0x87ceebff);
    private TestGame game;
    private Animation<TextureRegion> animation;
    private float elapsed;

    private Stage stage;
    private Table table;
    private com.badlogic.gdx.scenes.scene2d.ui.Image tankImg;
    private OrthographicCamera cam;
    private Label title;
    private StretchViewport gameViewPort;
    private TextButton newGameBtn;


    private Texture TankPic;
    private TextButton ResumeGameBtn;
    private TextButton ExitGameBtn;
    private Skin skin;
    private BitmapFont black;
    private BitmapFont white;
    private TextureAtlas atlas;
    private Viewport viewport;
    private PlayScreen p1;

    public TestGame getGame() {
        return game;
    }

    public void setGame(TestGame game) {
        this.game = game;
    }

    public Animation<TextureRegion> getAnimation() {
        return animation;
    }

    public void setAnimation(Animation<TextureRegion> animation) {
        this.animation = animation;
    }

    public float getElapsed() {
        return elapsed;
    }

    public void setElapsed(float elapsed) {
        this.elapsed = elapsed;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public Image getTankImg() {
        return tankImg;
    }

    public void setTankImg(Image tankImg) {
        this.tankImg = tankImg;
    }

    public OrthographicCamera getCam() {
        return cam;
    }

    public void setCam(OrthographicCamera cam) {
        this.cam = cam;
    }

    public Label getTitle() {
        return title;
    }

    public void setTitle(Label title) {
        this.title = title;
    }

    public StretchViewport getGameViewPort() {
        return gameViewPort;
    }

    public void setGameViewPort(StretchViewport gameViewPort) {
        this.gameViewPort = gameViewPort;
    }

    public TextButton getNewGameBtn() {
        return newGameBtn;
    }

    public void setNewGameBtn(TextButton newGameBtn) {
        this.newGameBtn = newGameBtn;
    }

    public Texture getTankPic() {
        return TankPic;
    }

    public void setTankPic(Texture tankPic) {
        TankPic = tankPic;
    }

    public TextButton getResumeGameBtn() {
        return ResumeGameBtn;
    }

    public void setResumeGameBtn(TextButton resumeGameBtn) {
        ResumeGameBtn = resumeGameBtn;
    }

    public TextButton getExitGameBtn() {
        return ExitGameBtn;
    }

    public void setExitGameBtn(TextButton exitGameBtn) {
        ExitGameBtn = exitGameBtn;
    }

    public Skin getSkin() {
        return skin;
    }

    public void setSkin(Skin skin) {
        this.skin = skin;
    }

    public BitmapFont getBlack() {
        return black;
    }

    public void setBlack(BitmapFont black) {
        this.black = black;
    }

    public BitmapFont getWhite() {
        return white;
    }

    public void setWhite(BitmapFont white) {
        this.white = white;
    }

    public TextureAtlas getAtlas() {
        return atlas;
    }

    public void setAtlas(TextureAtlas atlas) {
        this.atlas = atlas;
    }

    public Viewport getViewport() {
        return viewport;
    }

    public void setViewport(Viewport viewport) {
        this.viewport = viewport;
    }

    public PlayScreen getP1() {
        return p1;
    }

    public void setP1(PlayScreen p1) {
        this.p1 = p1;
    }

    public mainMenuScreen(final TestGame game, final PlayScreen p1) {
        this.game=game;
        this.p1 = p1;
        this.cam=new OrthographicCamera();
        viewport=new StretchViewport(TestGame.V_WIDTH,TestGame.V_HEIGHT,cam);

        stage=new Stage(viewport);
        Gdx.input.setInputProcessor(stage);
        cam.setToOrtho(false,TestGame.V_WIDTH,TestGame.V_HEIGHT);
        gameViewPort=new StretchViewport(TestGame.V_WIDTH,TestGame.V_HEIGHT,cam);

        animation = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("tank2.gif").read());

        black = new BitmapFont(Gdx.files.internal("font/black.fnt"));
        white = new BitmapFont(Gdx.files.internal("font/gradient.fnt"));

        skin = new Skin(Gdx.files.internal("uiskin.json"));

        TankPic=new Texture("menubg.png");
        tankImg=new com.badlogic.gdx.scenes.scene2d.ui.Image(TankPic);
        tankImg.setHeight(cam.viewportHeight); // tank pic background image
        tankImg.setWidth(cam.viewportWidth);
        //btn config
        newGameBtn=new TextButton("NEW GAME",skin,"default-black");
        ResumeGameBtn=new TextButton("Resume",skin,"default-black");
        ExitGameBtn=new TextButton("EXIT",skin,"default-black" );
        //table config
        table =new Table();
        table.padTop(5);
        table.setSize(TestGame.V_WIDTH/2,TestGame.V_HEIGHT);
        table.add(newGameBtn).height(100).width(300).spaceTop(30).expandX().row();

        table.add(ResumeGameBtn).height(100).width(300).spaceTop(30).expandX().row();
        table.add(ExitGameBtn).height(100).width(300).spaceTop(30).expandX().row();
        table.setPosition(TestGame.V_WIDTH/2, 0);
        stage.addActor(tankImg);
        stage.addActor(table);

        newGameBtn.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                TankSelection g1 = new TankSelection(p1.getGame());
                game.setScreen(g1);
                dispose();
                //Add click handler here!
            }
        });
        ResumeGameBtn.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                ResumeScreen r1 = new ResumeScreen(p1.getGame());
                game.setScreen(r1);
                dispose();
            }
        });
        ExitGameBtn.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.app.exit();
                dispose();
                //Add click handler here!
            }
        });

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        elapsed += Gdx.graphics.getDeltaTime();
        ScreenUtils.clear(SKY);
        stage.act(Gdx.graphics.getDeltaTime());
        game.getBatch().setProjectionMatrix(cam.combined);
        stage.draw();


        game.getBatch().begin();
        game.getBatch().draw(animation.getKeyFrame(elapsed), -300.0f, 0.0f,1092.5f,473.75f);
        game.getBatch().end();
    }

    @Override
    public void resize(int width, int height) {
        gameViewPort.update(width,height);
        stage.getViewport().update(width, height, true);
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