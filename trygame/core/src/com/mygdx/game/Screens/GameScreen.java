package com.mygdx.game.Screens;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.CircleMapObject;
import com.badlogic.gdx.maps.objects.PolygonMapObject;
import com.badlogic.gdx.maps.objects.PolylineMapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthoCachedTiledMapRenderer;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.Tank;
import com.mygdx.game.TestGame;

import java.util.ArrayList;

public class GameScreen implements Screen {
    private TestGame game;
    public static final Color YELLOW = new Color(0xffff00ff);
    public static final Color SKY = new Color(0x87ceebff);
    public static final Color WHITE = new Color(1, 1, 1, 1);
    public static final Color LIGHT_GRAY = new Color(0xbfbfbfff);
    public static final Color GRAY = new Color(0x7f7f7fff);
    public static final Color DARK_GRAY = new Color(0x3f3f3fff);
    public static final Color BLACK = new Color(0, 0, 0, 1);
    private OrthographicCamera cam;
    private StretchViewport gameViewPort;
    private Viewport viewport;
    private Stage stage;
    private TmxMapLoader mapLoader;
    private TiledMap map;
    private OrthoCachedTiledMapRenderer renderer;
    private Table table;
    private Tank Tank1;
    private Tank Tank2;
    private Texture moon;

    private World world;
    private Box2DDebugRenderer b2dr;
    private ArrayList<Tank> All_Tanks;

    private SpriteBatch Tank_Ka_Batch;

    public TestGame getGame() {
        return game;
    }

    public void setGame(TestGame game) {
        this.game = game;
    }

    public OrthographicCamera getCam() {
        return cam;
    }

    public void setCam(OrthographicCamera cam) {
        this.cam = cam;
    }

    public StretchViewport getGameViewPort() {
        return gameViewPort;
    }

    public void setGameViewPort(StretchViewport gameViewPort) {
        this.gameViewPort = gameViewPort;
    }

    public Viewport getViewport() {
        return viewport;
    }

    public void setViewport(Viewport viewport) {
        this.viewport = viewport;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public TmxMapLoader getMapLoader() {
        return mapLoader;
    }

    public void setMapLoader(TmxMapLoader mapLoader) {
        this.mapLoader = mapLoader;
    }

    public TiledMap getMap() {
        return map;
    }

    public void setMap(TiledMap map) {
        this.map = map;
    }

    public OrthoCachedTiledMapRenderer getRenderer() {
        return renderer;
    }

    public void setRenderer(OrthoCachedTiledMapRenderer renderer) {
        this.renderer = renderer;
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    GameScreen(TestGame game , int Tank1_ka_Tank , int Tank2_ka_Tank){
        this.world = new World(new Vector2(0,-10),true);
        this.All_Tanks = new ArrayList<>();

        this.game=game;
        this.stage=new Stage();
        this.game=game;
        this.cam=new OrthographicCamera();
        viewport=new StretchViewport(TestGame.V_WIDTH,TestGame.V_HEIGHT,cam);

        this.All_Tanks.add(new Tank(new Texture("Tank"+(Tank1_ka_Tank+1)+".png"),100,80,100,0,this.world,300,300));
        this.All_Tanks.add(new Tank(new Texture("Tank"+(Tank2_ka_Tank+1)+".png"),100,80,100,0,this.world,900,398.5f));

        this.Tank1 = All_Tanks.get(0);
        this.Tank2 = All_Tanks.get(1);

        stage=new Stage(viewport);
        Gdx.input.setInputProcessor(stage);
        cam.setToOrtho(false,1600,1200);
        gameViewPort = new StretchViewport(Gdx.graphics.getWidth(),Gdx.graphics.getHeight(),cam);
        mapLoader=new TmxMapLoader();
        map=mapLoader.load("updatedtile.tmx");
        renderer=new OrthoCachedTiledMapRenderer(map);
        this.moon = new Texture("moon.png");
        this.b2dr = new Box2DDebugRenderer();
        this.Tank_Ka_Batch = new SpriteBatch();
        BodyDef bdef = new BodyDef();
        FixtureDef fdef = new FixtureDef();
        Body body;

//        this.Sample_Batch = new SpriteBatch();
        //rendering Object Layer of tiled App
        for(MapObject object : map.getLayers().get(2).getObjects()){
            Shape shape;
            if (object instanceof RectangleMapObject) {
                shape = getRectangle((RectangleMapObject)object);
            }
            else if (object instanceof PolygonMapObject) {
                shape = getPolygon((PolygonMapObject)object);
            }
            else if (object instanceof PolylineMapObject) {
                shape = getPolyline((PolylineMapObject)object);
            }
            else if (object instanceof CircleMapObject) {
                shape = getCircle((CircleMapObject)object);
            }
            else {
                continue;
            }
            bdef.type = BodyDef.BodyType.StaticBody;
            body = world.createBody(bdef);
            fdef.shape = shape;
            body.createFixture(fdef);
            shape.dispose();
        }

        for(MapObject object : map.getLayers().get(1).getObjects()){

            Shape shape;
            if (object instanceof RectangleMapObject) {
                shape = getRectangle((RectangleMapObject)object);
            }
            else if (object instanceof PolygonMapObject) {
                shape = getPolygon((PolygonMapObject)object);
            }
            else if (object instanceof PolylineMapObject) {
                shape = getPolyline((PolylineMapObject)object);
            }
            else if (object instanceof CircleMapObject) {
                shape = getCircle((CircleMapObject)object);
            }
            else {
                continue;
            }
            bdef.type = BodyDef.BodyType.StaticBody;
            body = world.createBody(bdef);
            fdef.shape = shape;
            body.createFixture(fdef);
            shape.dispose();
        }
    }
    @Override
    public void dispose() {
        // TODO Auto-generated method stub

    }

    @Override
    public void hide() {
        // TODO Auto-generated method stub

    }

    @Override
    public void pause() {
        // TODO Auto-generated method stub

    }

    public void handleInput(float dt){
        if(Gdx.input.isKeyJustPressed(Input.Keys.UP))
            Tank1.b2body.applyLinearImpulse(new Vector2(0,4f),new Vector2(Tank1.getX_Coordinates(),Tank1.getY_Coordinates()),true);
        if(Gdx.input.isKeyJustPressed(Input.Keys.RIGHT) && (Tank1.b2body.getLinearVelocity().x <= 2))
            Tank1.b2body.applyLinearImpulse(new Vector2(35f,0),new Vector2(Tank1.getX_Coordinates(),Tank1.getY_Coordinates()),true);
        if(Gdx.input.isKeyJustPressed(Input.Keys.LEFT) && Tank1.b2body.getLinearVelocity().x >= -2)
            Tank1.b2body.applyLinearImpulse(new Vector2(-35f,0),new Vector2(Tank1.getX_Coordinates(),Tank1.getY_Coordinates()),true);


        if(Gdx.input.isKeyJustPressed(Input.Keys.W))
            Tank2.b2body.applyLinearImpulse(new Vector2(0,4f),new Vector2(Tank2.getX_Coordinates(),Tank2.getY_Coordinates()),true);
        if(Gdx.input.isKeyJustPressed(Input.Keys.D) && (Tank2.b2body.getLinearVelocity().x <= 2))
            Tank2.b2body.applyLinearImpulse(new Vector2(35f,0),new Vector2(Tank2.getX_Coordinates(),Tank2.getY_Coordinates()),true);
        if(Gdx.input.isKeyJustPressed(Input.Keys.A) && Tank2.b2body.getLinearVelocity().x >= -2)
            Tank2.b2body.applyLinearImpulse(new Vector2(-35f,0),new Vector2(Tank2.getX_Coordinates(),Tank2.getY_Coordinates()),true);

        if(Gdx.input.isKeyJustPressed(Input.Keys.L))
            cam.position.x += 100*dt;
        if(Gdx.input.isKeyJustPressed(Input.Keys.J))
            cam.position.x -= 100*dt;

    }

    public void update(float dt){
        handleInput(dt);
        world.step(1/60f,6,2);
//        cam.position.x = Tank1.b2body.getPosition().x;
//        cam.update();
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(BLACK);
        update(delta);
        renderer.setView(cam);
        game.getBatch().begin();
        game.getBatch().draw(moon,0,0,viewport.getScreenWidth(),viewport.getScreenHeight());
        game.getBatch().end();

        Tank_Ka_Batch.begin();
        Tank_Ka_Batch.draw(Tank1.getTexture(),Tank1.b2body.getPosition().x,Tank1.b2body.getPosition().y,Tank1.getTank_Width(),Tank1.getTank_Height());
        Tank_Ka_Batch.draw(Tank2.getTexture(),Tank2.b2body.getPosition().x,Tank2.b2body.getPosition().y,Tank2.getTank_Width(),Tank2.getTank_Height());
        Tank_Ka_Batch.end();

        renderer.render();
        b2dr.render(world,cam.combined);
//        System.out.println(Tenk2.b2body.getPosition());
        // stage.act(Gdx.graphics.getDeltaTime());
//         game.getBatch().setProjectionMatrix(cam.combined);
        // stage.draw();


        // TODO Auto-generated method stub

    }

    @Override
    public void resize(int width, int height) {
        // TODO Auto-generated method stub

    }

    @Override
    public void resume() {
        // TODO Auto-generated method stub

    }

    @Override
    public void show() {
        // TODO Auto-generated method stub

    }

    private static PolygonShape getRectangle(RectangleMapObject rectangleObject) {
        Rectangle rectangle = rectangleObject.getRectangle();
        PolygonShape polygon = new PolygonShape();
        Vector2 size = new Vector2((rectangle.x + rectangle.width * 0.5f) / TestGame.PPM1,
                (rectangle.y + rectangle.height * 0.5f ) / TestGame.PPM1);
        polygon.setAsBox(rectangle.width * 0.5f /TestGame.PPM1,
                rectangle.height * 0.5f / TestGame.PPM1,
                size,
                0.0f);
        return polygon;
    }

    private static CircleShape getCircle(CircleMapObject circleObject) {
        Circle circle = circleObject.getCircle();
        CircleShape circleShape = new CircleShape();
        circleShape.setRadius(circle.radius / TestGame.PPM1);
        circleShape.setPosition(new Vector2(circle.x / TestGame.PPM1, circle.y / TestGame.PPM1));
        return circleShape;
    }

    private static PolygonShape getPolygon(PolygonMapObject polygonObject) {
        PolygonShape polygon = new PolygonShape();
        float[] vertices = polygonObject.getPolygon().getTransformedVertices();

        float[] worldVertices = new float[vertices.length];

        for (int i = 0; i < vertices.length; ++i) {
//            System.out.println(vertices[i]);
            worldVertices[i] = vertices[i] / TestGame.PPM1;
        }

        polygon.set(worldVertices);
        return polygon;
    }

    private static ChainShape getPolyline(PolylineMapObject polylineObject) {
        float[] vertices = polylineObject.getPolyline().getTransformedVertices();
        Vector2[] worldVertices = new Vector2[vertices.length / 2];

        for (int i = 0; i < vertices.length / 2; ++i) {
            worldVertices[i] = new Vector2();
            worldVertices[i].x = vertices[i * 2] / TestGame.PPM1;
            worldVertices[i].y = vertices[i * 2 + 1] / TestGame.PPM1;
        }

        ChainShape chain = new ChainShape();
        chain.createChain(worldVertices);
        return chain;

    }

}

