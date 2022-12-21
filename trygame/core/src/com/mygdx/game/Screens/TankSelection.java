package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.*;

import java.util.ArrayList;

public class TankSelection implements Screen {
    private int i;
    private ArrayList<Texture> AllTanks;
    private TestGame game;
    private Texture Bground;
    private Texture BgText;

    private Texture Left;
    private Texture Right;
    private OrthographicCamera GameCam;
    private Viewport GamePort;

    private Texture TankTexture1;
    private Texture TankTexture2;
    private Texture TankTexture3;
    private Texture Player1Text;
    private Texture Player2Text;
    private int j;
    private Texture AttBar;
    private BitmapFont font;
    private Texture vs;

    private Texture red;
    private Texture blue;
    private Texture play;

    private Stage stage;

    public Texture getPlay() {
        return play;
    }

    public void setPlay(Texture play) {
        this.play = play;
    }

    public Texture getRed() {
        return red;
    }

    public void setRed(Texture red) {
        this.red = red;
    }

    public Texture getBlue() {
        return blue;
    }

    public void setBlue(Texture blue) {
        this.blue = blue;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public Texture getAttBar() {
        return AttBar;
    }

    public void setAttBar(Texture attBar) {
        AttBar = attBar;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }

    public Texture getPlayer1Text() {
        return Player1Text;
    }

    public void setPlayer1Text(Texture player1Text) {
        Player1Text = player1Text;
    }

    public Texture getPlayer2Text() {
        return Player2Text;
    }

    public void setPlayer2Text(Texture player2Text) {
        Player2Text = player2Text;
    }

    public Texture getVs() {
        return vs;
    }

    public void setVs(Texture vs) {
        this.vs = vs;
    }

    public BitmapFont getFont() {
        return font;
    }

    public void setFont(BitmapFont font) {
        this.font = font;
    }

    public Texture getBgText() {
        return BgText;
    }

    public void setBgText(Texture bgText) {
        BgText = bgText;
    }

    public TestGame getGame() {
        return game;
    }

    public void setGame(TestGame game) {
        this.game = game;
    }

    public Texture getBground() {
        return Bground;
    }

    public void setBground(Texture bground) {
        Bground = bground;
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

    public Texture getLeft() {
        return Left;
    }

    public void setLeft(Texture left) {
        Left = left;
    }

    public Texture getRight() {
        return Right;
    }

    public void setRight(Texture right) {
        Right = right;
    }

    public ArrayList<Texture> getAllTanks(){
        return AllTanks;
    }
    public void setAllTanks(ArrayList<Texture> allTanks) {
        AllTanks = allTanks;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public TankSelection(TestGame game){
        this.game = game;
        this.GameCam = new OrthographicCamera();
        this.Bground = new Texture("selectionbg.png");
        this.BgText = new Texture("select_your_tank.png");
        this.TankTexture1 = new Texture("Tank1.png");
        this.TankTexture2 = new Texture("Tank2.png");
        this.TankTexture3 = new Texture("Tank3.png");
        this.red =  new Texture("red.png");
        this.blue = new Texture("blue.png");
        this.Left = new Texture("shade/raw/left.png");
        this.Right = new Texture("shade/raw/right.png");
        this.vs = new Texture("vs.png");
        this.AttBar = new Texture("attbar.png");
        this.Player1Text = new Texture("player1.png");
        this.Player2Text = new Texture("player2.png");
        this.play = new Texture("play.png");
        this.GameCam.setToOrtho(false,TestGame.V_WIDTH,TestGame.V_HEIGHT);
        this.GamePort = new StretchViewport(TestGame.V_WIDTH,TestGame.V_HEIGHT,this.GameCam);
        this.AllTanks = new ArrayList<Texture>();
        this.font = new BitmapFont();
        this.j = 1;
        this.i = 0;
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);


        Skin mySkin = new Skin(Gdx.files.internal("shade/skin/uiskin.json"));
        Skin mySkin1 = new Skin(Gdx.files.internal("shade/skin/uiskin.json"));
        Skin mySkin2 = new Skin(Gdx.files.internal("shade/skin/uiskin.json"));
        Skin mySkin3 = new Skin(Gdx.files.internal("shade/skin/uiskin.json"));
        Skin mySkin4 = new Skin(Gdx.files.internal("shade/skin/uiskin.json"));
        Skin mySkin5 = new Skin(Gdx.files.internal("shade/skin/uiskin.json"));


        ImageButton button3 = new ImageButton(mySkin);
        button3.setSize(48.5f,48.5f);
        button3.getStyle().imageUp = new TextureRegionDrawable(new TextureRegion(Left));
        button3.getStyle().imageDown = new TextureRegionDrawable(new TextureRegion(Left));
        button3.setPosition(30,getGameCam().viewportHeight/2 - Left.getHeight()/4);
        button3.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                i++;
                if(i >= 3){
                    i = 0;
                }

            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        stage.addActor(button3);


        ImageButton button2 = new ImageButton(mySkin1);
        button2.setSize(48.5f,48.5f);
        button2.getStyle().imageUp = new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("shade/raw/left.png"))));
        button2.getStyle().imageDown = new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("shade/raw/left2.png"))));
        button2.setPosition(570,getGameCam().viewportHeight/2 - Left.getHeight()/4);
        button2.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                j++;
                if (j == 3) {
                    j = 0;
                }
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        stage.addActor(button2);

        ImageButton button1 = new ImageButton(mySkin3);
        button1.setSize(48.5f,48.5f);
        button1.getStyle().imageUp = new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("shade/raw/right.png"))));
        button1.getStyle().imageDown = new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("shade/raw/right2.png"))));
        button1.setPosition(890,getGameCam().viewportHeight/2 - Left.getHeight()/4);
        button1.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                j--;
                if (j == -1) {
                    j = 2;
                }
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        stage.addActor(button1);

        ImageButton button0 = new ImageButton(mySkin4);
        button0.setSize(48.5f,48.5f);
        button0.getStyle().imageUp = new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("shade/raw/right.png"))));
        button0.getStyle().imageDown = new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("shade/raw/right2.png"))));
        button0.setPosition(350,getGameCam().viewportHeight/2 - Left.getHeight()/4);
        button0.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                i--;
                if(i == -1){
                    i = 2;
                }

            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        stage.addActor(button0);

        ImageButton button4 = new ImageButton(mySkin2);
        button4.setSize(play.getWidth(), play.getHeight());
        button4.getStyle().imageUp = new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("play1.png"))));
        button4.getStyle().imageDown = new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("play2.png"))));
        button4.setPosition(370,60);
        button4.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
            GameScreen g1 = new GameScreen(getGame(),i,j);
            getGame().setScreen(g1);
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        stage.addActor(button4);

        ImageButton button5 = new ImageButton(mySkin5);
        button5.setSize(40, 40);
        button5.getStyle().imageUp = new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("back.png"))));
        button5.getStyle().imageDown = new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("back2.png"))));
        button5.setPosition(10,getGameCam().viewportHeight - 50);
        button5.addListener(new InputListener(){
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
        stage.addActor(button5);

        getAllTanks().add(TankTexture1);
        getAllTanks().add(TankTexture2);
        getAllTanks().add(TankTexture3);

    }


    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.getBatch().setProjectionMatrix(this.getGameCam().combined);

        game.getBatch().begin();
        game.getBatch().draw(Bground,0,0,getGameCam().viewportWidth,getGameCam().viewportHeight);
        game.getBatch().draw(BgText,62.5f,225,832.5f,468.75f);
        game.getBatch().draw(vs,(getGameCam().viewportWidth/2 - vs.getWidth()/4)-10,getGameCam().viewportHeight/2 - vs.getHeight()/3,156,156);

        game.getBatch().draw(Player1Text, 90,325,249.5f,53.5f); // player 1
        game.getBatch().draw(AttBar,130,110,200,30); //player 1
        game.getBatch().draw(AttBar,130,60,200,30);//player 1

        if(i == 0) {
            game.getBatch().draw(red, 132, 112, 196f, 28);//player 1 damage
            game.getBatch().draw(blue, 132, 62, 156.8f, 28);//player 1 health
            game.getBatch().draw(getAllTanks().get(i),90,100,250,250); //player1 tank
        }
        else if(i == 1){
            game.getBatch().draw(red, 132, 112, 176.4f, 28);//player 1 damage
            game.getBatch().draw(blue, 132, 62, 176.4f, 28);//player 1 health
            game.getBatch().draw(getAllTanks().get(i),90,100,250,250); //player1 tank
        }
        else if(i == 2){
            game.getBatch().draw(red, 132, 112, 156.8f, 28);//player 1 damage
            game.getBatch().draw(blue, 132, 62, 196f, 28);//player 1 health
            game.getBatch().draw(getAllTanks().get(i),90,100,250,250); //player1 tank
        }

        this.getFont().draw(game.getBatch(), "Damage", 70, 130); //player 1
        this.getFont().draw(game.getBatch(), "Health", 70, 80); //player 1

        game.getBatch().draw(Player2Text,630,325,249.5f,53.5f);//player 2
        game.getBatch().draw(AttBar,672,110,200,30); //player 2
        game.getBatch().draw(AttBar,672,60,200,30);//player 2

        if(j == 0) {
            game.getBatch().draw(red, 674, 112, 196, 28);//player 2 damage
            game.getBatch().draw(blue, 674, 62, 156.8f, 28);//player 2 health
            game.getBatch().draw(getAllTanks().get(j),630,100,250,250);//player 2 tank
        }

        else if(j == 1) {
            game.getBatch().draw(red, 674, 112, 176.4f, 28);//player 2 damage
            game.getBatch().draw(blue, 674, 62, 176.4f, 28);//player 2 health
            game.getBatch().draw(getAllTanks().get(j),630,100,250,250);//player 2 tank
        }

        else if(j == 2) {
            game.getBatch().draw(red, 674, 112, 156.8f, 28);//player 2 damage
            game.getBatch().draw(blue, 674, 62, 196, 28);//player 2 health
            game.getBatch().draw(getAllTanks().get(j),630,100,250,250);//player 2 tank
        }

        this.getFont().draw(game.getBatch(), "Damage", 612, 130);
        this.getFont().draw(game.getBatch(), "Health", 612, 80);

        game.getBatch().end();


            stage.act();
            stage.draw();
            //when play button will be functional then we can simply add 'GameScreen'  for the functionality of it
        }


    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
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
