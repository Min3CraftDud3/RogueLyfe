package com.SinfulPixel.RogueLike;

import com.SinfulPixel.RogueLike.Scenes.Screen;
import com.SinfulPixel.RogueLike.Scenes.ScreenManager;
import com.badlogic.gdx.Game;

public class RogueLike extends Game {
    public static int height,width = 0;
    public RogueLike (int h,int w){
        this.height = h;
        this.width = w;
    }
    @Override
    public void create() {
        ScreenManager.getInstance().initialize(this);
        ScreenManager.getInstance().show(Screen.INTRO);
    }
    @Override
    public void dispose(){
        super.dispose();
        ScreenManager.getInstance().dispose();
    }
}
