package pl.ajonx.wolfsk2.utils;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.TimeoutException;

import pl.ajonx.wolfsk2.WolfSk2Log;

public class IOUtils {

    public static String getContent(String s) {
        String body = null;
        try {
            URL url = new URL(s);
            URLConnection con = url.openConnection();
            InputStream in = con.getInputStream();
            String encoding = con.getContentEncoding();
            encoding = encoding == null ? "UTF-8" : encoding;
            body = IOUtils.toString(in, encoding);
        } catch (TimeoutException e) {
            //WolfSk2Log.sendLog("&7[ &fIO&6&lUtils &7] &c" + e.getMessage());
        } catch (Exception e) {
        	//WolfSk2Log.sendLog("&7[ &fIO&6&lUtils &7] &c" + e.getMessage());
        }
        return body;
    }

    private static String toString(InputStream in, String encoding) throws Exception {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buf = new byte[8192];
        int len = 0;
        while ((len = in.read(buf)) != -1) {
            baos.write(buf, 0, len);
        }
        return new String(baos.toByteArray(), encoding);
    }

}
