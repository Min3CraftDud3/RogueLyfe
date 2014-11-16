package com.SinfulPixel.RogueLike.Scenes;


import com.SinfulPixel.RogueLike.RogueLike;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

/**
 * Created by Min3 on 11/13/2014.
 */
public class GameScreen implements com.badlogic.gdx.Screen{
    private TiledMap map;
    private OrthogonalTiledMapRenderer renderer;
    private OrthographicCamera camera;
    private static final int FRAME_COLS = 3;
    private static final int FRAME_ROWS = 1;
    private static Texture WalkN;
    private static Texture WalkE;
    private static Texture WalkS;
    private static Texture WalkW;
    private static Animation walkNAnim;
    private static Animation walkEAnim;
    private static Animation walkSAnim;
    private static Animation walkWAnim;
    private static TextureRegion[] walkNFrames;
    private static TextureRegion[] walkEFrames;
    private static TextureRegion[] walkSFrames;
    private static TextureRegion[] walkWFrames;
    private static TextureRegion curFrame;
    private static float stateTime;
    private static int dir = 0;
    SpriteBatch batch;
    @Override
    public void render(float v) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        renderer.setView(camera);
        renderer.render();
        camera.update();
        stateTime = v;
        if(dir == 0) {
            curFrame = walkSAnim.getKeyFrame(v, true);
        }else if(dir == 1){
            curFrame = walkWAnim.getKeyFrame(v, true);
        }else if(dir == 2){
            curFrame = walkNAnim.getKeyFrame(v, true);
        }else if(dir == 3){
            curFrame = walkEAnim.getKeyFrame(v, true);
        }
        batch.begin();
        batch.draw(curFrame,(Gdx.graphics.getWidth()/2-curFrame.getRegionWidth()),(Gdx.graphics.getHeight()-Gdx.graphics.getHeight())/2);
        System.out.println("Screen: "+ Gdx.graphics.getWidth()/2+","+Gdx.graphics.getHeight()/2);
        System.out.println("Size: "+(Gdx.graphics.getWidth()/2-curFrame.getRegionWidth())+","+(Gdx.graphics.getHeight() - Gdx.graphics.getHeight())/2);
        if(Gdx.input.isKeyPressed(Input.Keys.A)){
            dir = 1;
            curFrame = walkWAnim.getKeyFrame(stateTime,true);
            batch.draw(curFrame,300,300);
            camera.position.x -=2;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.D)){
            dir = 3;
            curFrame = walkEAnim.getKeyFrame(stateTime,true);
            batch.draw(curFrame,300,300);
            camera.position.x +=2;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.W)){
            dir = 2;
            curFrame = walkNAnim.getKeyFrame(stateTime,true);
            batch.draw(curFrame,300,300);
            camera.position.y +=2;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.S)){
            dir = 0;
            curFrame = walkSAnim.getKeyFrame(stateTime,true);
            batch.draw(curFrame,300,300);
            camera.position.y -=2;
        }
        batch.end();

    }

    @Override
    public void resize(int i, int i2) {
        camera.viewportHeight = i2;
        camera.viewportWidth = i;
        camera.update();
    }

    @Override
    public void show() {
        //North
        WalkN = new Texture(Gdx.files.internal("Character/Anim/Walk/WalkN.png"));
        TextureRegion[][] Ntmp = TextureRegion.split(WalkN,WalkN.getWidth()/FRAME_COLS,WalkN.getHeight()/FRAME_ROWS);
        walkNFrames = new TextureRegion[FRAME_COLS*FRAME_ROWS];
        int indexN = 0;
        for(int i=0;i<FRAME_ROWS;i++){
            for(int j=0;j<FRAME_COLS;j++){
                walkNFrames[indexN++] = Ntmp[i][j];
            }
        }
        walkNAnim = new Animation(1f,walkNFrames);
        //East
        WalkE = new Texture(Gdx.files.internal("Character/Anim/Walk/WalkE.png"));
        TextureRegion[][] Etmp = TextureRegion.split(WalkE,WalkE.getWidth()/FRAME_COLS,WalkE.getHeight()/FRAME_ROWS);
        walkEFrames = new TextureRegion[FRAME_COLS*FRAME_ROWS];
        int indexE = 0;
        for(int i=0;i<FRAME_ROWS;i++){
            for(int j=0;j<FRAME_COLS;j++){
                walkEFrames[indexE++] = Etmp[i][j];
            }
        }
        walkEAnim = new Animation(1f,walkEFrames);
        //South
        WalkS = new Texture(Gdx.files.internal("Character/Anim/Walk/WalkS.png"));
        TextureRegion[][] Stmp = TextureRegion.split(WalkS,WalkS.getWidth()/FRAME_COLS,WalkS.getHeight()/FRAME_ROWS);
        walkSFrames = new TextureRegion[FRAME_COLS*FRAME_ROWS];
        int indexS = 0;
        for(int i=0;i<FRAME_ROWS;i++){
            for(int j=0;j<FRAME_COLS;j++){
                walkSFrames[indexS++] = Stmp[i][j];
            }
        }
        walkSAnim = new Animation(1f,walkSFrames);
        //West
        WalkW = new Texture(Gdx.files.internal("Character/Anim/Walk/WalkW.png"));
        TextureRegion[][] Wtmp = TextureRegion.split(WalkW,WalkW.getWidth()/FRAME_COLS,WalkW.getHeight()/FRAME_ROWS);
        walkWFrames = new TextureRegion[FRAME_COLS*FRAME_ROWS];
        int indexW = 0;
        for(int i=0;i<FRAME_ROWS;i++){
            for(int j=0;j<FRAME_COLS;j++){
                walkWFrames[indexW++] = Wtmp[i][j];
            }
        }
        walkWAnim = new Animation(1f,walkWFrames);
        batch = new SpriteBatch();
        stateTime = 0f;
        map = new TmxMapLoader().load("maps/map.tmx");
        renderer = new OrthogonalTiledMapRenderer(map);
        camera = new OrthographicCamera();
        camera.setToOrtho(false,RogueLike.width,RogueLike.height);
    }

    @Override
    public void hide() {
        dispose();
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {
        try{batch.dispose();}catch(Exception i){}
        WalkN.dispose();
        WalkE.dispose();
        WalkS.dispose();
        WalkW.dispose();
        map.dispose();
        try{renderer.dispose();}catch(Exception i){}
    }
}
