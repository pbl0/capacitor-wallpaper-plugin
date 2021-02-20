package tech.pablobls.plugins.wallpaper;

import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Base64;
import android.util.Log;

import com.getcapacitor.JSObject;
import com.getcapacitor.NativePlugin;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.io.File;
import java.io.IOException;




@NativePlugin
public class Wallpaper extends Plugin {

    @PluginMethod
    public void echo(PluginCall call) {
        String imgBase64 = call.getString("value");
        String type = call.getString("type");
        JSObject ret = new JSObject();
        if (imgBase64 != null ){
            this.setWallpaper(imgBase64, type);
            ret.put("value", "ok");
            call.success(ret);
        } else{
            ret.put("value", "value is null");
            call.error("Error: imgBase64 is null");
        }



    }

    void setWallpaper(String imgBase64, String type) {

        final WallpaperManager wallpaperManager = WallpaperManager.getInstance(getContext());

        byte[] decodedString = Base64.decode(imgBase64, Base64.DEFAULT);
        Bitmap bitmap = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);

        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {

                if (type.equals("wall")){

                    wallpaperManager.setBitmap(bitmap, null, true, WallpaperManager.FLAG_SYSTEM);
                } else if (type.equals("lock")){

                    wallpaperManager.setBitmap(bitmap, null, true, WallpaperManager.FLAG_LOCK);
                }

            } else {

                wallpaperManager.setBitmap(bitmap);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
