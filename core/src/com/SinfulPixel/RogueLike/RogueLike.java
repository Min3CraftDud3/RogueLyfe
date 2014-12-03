package com.SinfulPixel.RogueLike;

import com.SinfulPixel.RogueLike.Scenes.Screen;
import com.SinfulPixel.RogueLike.Scenes.ScreenManager;
import com.badlogic.gdx.Game;

public class RogueLike extends Game {
    public static int height,width = 0;
    public static boolean showFPS = true;
    public RogueLike (int h,int w,boolean fps){
        this.height = h;
        this.width = w;
        this.showFPS = fps;
    }
    @Override
    public void create() {
        ScreenManager.getInstance().initialize(this);
        ScreenManager.getInstance().show(Screen.GAME);
    }
    @Override
    public void dispose(){
        super.dispose();
        ScreenManager.getInstance().dispose();
    }
}
