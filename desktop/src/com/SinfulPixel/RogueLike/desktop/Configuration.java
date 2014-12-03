package com.SinfulPixel.RogueLike.desktop;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Created by Min3 on 10/26/2014.
 */
public class Configuration {
    static XStream xs = new XStream(new DomDriver());
    public static void createConfig(){
        if(System.getProperty("os.name").startsWith("Windows")) {
            String dataFolder = System.getenv("APPDATA")+"\\Rogue Lyfe\\";
            String configFile = dataFolder + "config.xml";
            File folder = new File(dataFolder);
            File cfg = new File(configFile);
            if (!folder.exists()) {
                folder.mkdir();
            }
            if (!cfg.exists()) {
                try {
                    cfg.createNewFile();
                    writeFile(cfg);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
    private static void writeFile(File file){
        FileOutputStream fos = null;
        xs.alias("Configuration", cfg.class);
        cfg c = new cfg();
        c.setFpsCap(30);
        c.setHeight(720);
        c.setWidth(1280);
        c.setShowFPS(true);
        try{
            String xml = xs.toXML(c);
            fos = new FileOutputStream(file);
            fos.write("<?xml version=\"1.0\"?>\n".getBytes("UTF-8"));
            byte[] bytes = xml.getBytes("UTF-8");
            fos.write(bytes);
        }catch(Exception e){e.printStackTrace();
        }finally {
            if(fos != null){
                try{fos.close();}catch(Exception i){i.printStackTrace();}
            }
        }
    }
    public static boolean doesExist(){
        if(System.getProperty("os.name").startsWith("Windows")) {
            String dataFolder = System.getenv("APPDATA") + "\\Rogue Lyfe\\";
            String configFile = dataFolder + "config.xml";
            File folder = new File(dataFolder);
            File cfg = new File(configFile);
            if(cfg.exists()){return true;}else{return false;}
        }
        return false;
    }
    public static int[] getValues(){
        xs.alias("Configuration", cfg.class);
        if(System.getProperty("os.name").startsWith("Windows")) {
            String dataFolder = System.getenv("APPDATA") + "\\Rogue Lyfe\\";
            String configFile = dataFolder + "config.xml";
            FileInputStream fis = null;
            try {
                int boolValue = 0;
                fis = new FileInputStream(configFile);
                cfg c = (cfg) xs.fromXML(fis);
                if(c.getShowFPS()==true){boolValue=1;}else if(c.getShowFPS()==false){boolValue=0;}
                int[] in = {c.getHeight(), c.getWidth(),boolValue};
                return in;
            }catch(Exception e){}
        }
        return null;
    }
}
