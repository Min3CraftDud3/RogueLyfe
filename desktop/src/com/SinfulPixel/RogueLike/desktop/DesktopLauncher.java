package com.SinfulPixel.RogueLike.desktop;

import com.SinfulPixel.RogueLike.RogueLike;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class DesktopLauncher {
    public static int width = 1280;
    public static int height = 720;
    public static boolean showFPS = false;

	public static void main (String[] arg) {
        if(!Configuration.doesExist()) {
            Configuration.createConfig();
            if(Configuration.getValues() != null){
                int[] i = Configuration.getValues();
                height = i[0];
                width = i[1];
            }
        }else if(Configuration.doesExist()){
            if(Configuration.getValues() != null){
                int[] i = Configuration.getValues();
                height = i[0];
                width = i[1];
                if(i[2]==0){
                    showFPS=false;
                }else if(i[2]==1){
                    showFPS=true;
                }
            }
        }
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.title = "Rogue Lyfe";
        config.width = width;
        config.height = height;
		new LwjglApplication(new RogueLike(height,width,showFPS), config);
	}
}
