package com.SinfulPixel.RogueLike.Scenes;

import com.SinfulPixel.RogueLike.RogueLike;
import com.SinfulPixel.RogueLike.Timer.ScreenSwitchTask;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.utils.Timer;

/**
 * Created by Min3 on 11/14/2014.
 */
public class OptionsScreen implements com.badlogic.gdx.Screen {
    private static final String Resolution = "Resolution: ";
    private static final String FPSCap = "FPS Cap: ";
    private static final String Volume = "Volume: ";
    private static final String Title = "OPTIONS";
    private static final String Apply = "Apply Changes";
    private static final String[] resOptions = {Gdx.graphics.getWidth()+"x"+Gdx.graphics.getHeight(),"640x480","800x600","960x640","1024x768","1280x720","1366x768","1600x900","1920x1080"};
    private static final String[] fpsOptions = {"30 FPS", "60 FPS", "90 FPS", "120 FPS"};
    private static int scrHeight = RogueLike.height;
    private static int scrWidth = RogueLike.width;
    SpriteBatch batch;
    BitmapFont font;
    BitmapFont shadow;
    BitmapFont title;
    BitmapFont title1;
    Texture img;
    public OptionsScreen(){
        batch = new SpriteBatch();
        FileHandle fontFile = Gdx.files.internal("alagard.ttf");
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(fontFile);
        font = generator.generateFont(50);
        shadow = generator.generateFont(50);
        title =  generator.generateFont(90);
        title1 =  generator.generateFont(90);
        img = new Texture("bgtile_128.png");
        img.setWrap(Texture.TextureWrap.Repeat, Texture.TextureWrap.Repeat);
    }
    @Override
    public void render(float v) {
        Gdx.gl.glClearColor(1f, 1f, 1f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(img, 0, 0,0,0,scrWidth,scrHeight);

        //Draw Title
        title.setColor(Color.YELLOW);
        title.draw(batch, Title,((scrWidth - title.getBounds(Title).width) / 2),((scrHeight - title.getBounds(Title).height) / 2)+250);
        title1.setColor(179,189,0,150);
        title1.draw(batch,Title,((scrWidth - title.getBounds(Title).width) / 2)-7,((scrHeight - title.getBounds(Title).height) / 2)+242);
        //Options
        font.setColor(Color.YELLOW);
        font.draw(batch, Resolution+resOptions[0], ((scrWidth - (font.getBounds(Resolution).width+font.getBounds(resOptions[0]).width)) / 2),((scrHeight - (font.getBounds(Resolution).height+font.getBounds(resOptions[0]).height)) / 2));
        font.draw(batch, FPSCap+fpsOptions[0], ((scrWidth - (font.getBounds(FPSCap).width+font.getBounds(fpsOptions[0]).width)) / 2),((scrHeight - (font.getBounds(FPSCap).height+font.getBounds(fpsOptions[0]).width)) / 2)+20);
        font.draw(batch, Volume,((scrWidth - font.getBounds(Volume).width) / 2),((scrHeight - font.getBounds(Volume).height) / 2)-94);
        font.draw(batch, Apply,((scrWidth - font.getBounds(Apply).width) / 2),((scrHeight - font.getBounds(Apply).height) / 2)-135);
        //TextShadow
        shadow.setColor(179,189,0,150);
        shadow.draw(batch, Resolution+resOptions[0], ((scrWidth - (font.getBounds(Resolution).width+font.getBounds(resOptions[0]).width)) / 2)-3,((scrHeight - (font.getBounds(Resolution).height+font.getBounds(resOptions[0]).height)) / 2)-3);
        shadow.draw(batch, FPSCap+fpsOptions[0], ((scrWidth - (font.getBounds(FPSCap).width+font.getBounds(fpsOptions[0]).width)) / 2)-3,((scrHeight - (font.getBounds(FPSCap).height+font.getBounds(fpsOptions[0]).width)) / 2)+17);
        shadow.draw(batch, Volume,((scrWidth - font.getBounds(Volume).width) / 2)-3,((scrHeight - font.getBounds(Volume).height) / 2)-97);
        shadow.draw(batch, Apply,((scrWidth - font.getBounds(Apply).width) / 2)-3,((scrHeight - font.getBounds(Apply).height) / 2)-138);

        batch.end();
    }

    @Override
    public void resize(int i, int i2) {

    }

    @Override
    public void show() {
        Timer.schedule(new ScreenSwitchTask(Screen.GAME), 2f);
    }

    @Override
    public void hide() {
        ScreenManager.getInstance().dispose(Screen.OPTIONS);
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
