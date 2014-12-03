package com.SinfulPixel.RogueLike.Scenes;

import com.SinfulPixel.RogueLike.Entity.Player;
import com.SinfulPixel.RogueLike.RogueLike;
import com.SinfulPixel.RogueLike.Scenes.Renderers.GameRenderer;
import com.SinfulPixel.RogueLike.Scenes.Renderers.GameWorld;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;

/**
 * Created by Min3 on 11/13/2014.
 */
public class GameScreen implements com.badlogic.gdx.Screen{
    private World world;
    private Box2DDebugRenderer debugRenderer;
    private SpriteBatch batch;
    private OrthographicCamera camera;
    private Player player;
    private float timeStep = 1/60f;
    private BitmapFont font;
    private GameWorld gworld;
    private GameRenderer renderer;
    public GameScreen(){
        gworld = new GameWorld();
        renderer = new GameRenderer(gworld);
    }
    @Override
    public void render(float v) {
        Gdx.app.log("GameScreen: FPS",(1/v)+"");
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.update();
        gworld.update(v);
        renderer.render();
        debugRenderer.render(world,camera.combined);
        batch.begin();
        if(RogueLike.showFPS==true){font.draw(batch, "FPS: "+Math.floor(1 / v), 0,RogueLike.height);}
        batch.end();
    }

    @Override
    public void resize(int i, int i2) {
        camera.viewportWidth = i;
        camera.viewportHeight =i2;
    }

    @Override
    public void show() {
        Gdx.app.log("GameScreen: ","Attached");
        FileHandle fontFile = Gdx.files.internal("alagard.ttf");
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(fontFile);
        font = generator.generateFont(20);
        debugRenderer = new Box2DDebugRenderer();
        world = new World(new Vector2(), true);
        batch = new SpriteBatch();
        camera = new OrthographicCamera();
        player = new Player(world,0,0,25,45);
    }

    @Override
    public void hide() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {
        world.dispose();
        debugRenderer.dispose();
        batch.dispose();
    }
}
