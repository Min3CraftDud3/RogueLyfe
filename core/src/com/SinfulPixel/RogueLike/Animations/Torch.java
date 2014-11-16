package com.SinfulPixel.RogueLike.Animations;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by Min3 on 10/27/2014.
 */
public class Torch implements ApplicationListener {
    private static final int FRAME_COLS = 2;
    private static final int FRAME_ROWS = 2;
    Animation torchAnim;
    Texture torchSheet;
    TextureRegion[] torchFrames;
    SpriteBatch spriteBatch;
    TextureRegion currentFrame;
    float stateTime;
    @Override
    public void create() {
        torchSheet = new Texture(Gdx.files.internal("TorchSheet.png"));
        TextureRegion[][] tmp = TextureRegion.split(torchSheet,torchSheet.getWidth()/FRAME_COLS,torchSheet.getHeight()/FRAME_ROWS);
        torchFrames = new TextureRegion[FRAME_COLS * FRAME_ROWS];
        int index = 0;
        for(int i=0;i<FRAME_ROWS;i++){
            for(int j=0;j<FRAME_COLS;j++){
                torchFrames[index++] = tmp[i][j];
            }
        }
        torchAnim = new Animation(0.025f,torchFrames);
        spriteBatch = new SpriteBatch();
        stateTime = 0f;
    }

    @Override
    public void resize(int i, int i2) {

    }

    @Override
    public void render() {
        //Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
        stateTime += .99f;
        currentFrame = torchAnim.getKeyFrame(stateTime,true);
        spriteBatch.begin();
        spriteBatch.draw(currentFrame,125,525);
        spriteBatch.draw(currentFrame,1000,525);
        spriteBatch.end();

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }
}
