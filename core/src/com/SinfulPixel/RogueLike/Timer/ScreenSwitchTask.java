package com.SinfulPixel.RogueLike.Timer;

import com.SinfulPixel.RogueLike.Scenes.Screen;
import com.SinfulPixel.RogueLike.Scenes.ScreenManager;
import com.badlogic.gdx.utils.Timer;

/**
 * Created by Min3 on 11/13/2014.
 */
public class ScreenSwitchTask extends Timer.Task {
    private Screen screen = null;
    public ScreenSwitchTask(Screen screen){
        this.screen = screen;
    }
    @Override
    public void run() {
        ScreenManager.getInstance().show(screen);
    }
}
