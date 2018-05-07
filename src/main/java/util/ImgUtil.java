package util;

import kisaki.web.entity.Img;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import sun.misc.BASE64Decoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Blob;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ImgUtil {

    public static List<Img> getImgSize(List<Img> list) throws IOException {
        for (Img img : list) {
            File picture = new File(img.getImgUrl());
            BufferedImage sourceImg = ImageIO.read(new FileInputStream(picture));
            img.setImg_height(sourceImg.getHeight());
            img.setImg_width(sourceImg.getWidth());
            img.setImg_size(sourceImg.getWidth() / sourceImg.getHeight());
        }

        return list;
    }

    public static Img getImgSize(Img img) throws IOException {
        File picture = new File(img.getImgUrl());
        BufferedImage sourceImg = ImageIO.read(new FileInputStream(picture));
        img.setImg_height(sourceImg.getHeight());
        img.setImg_width(sourceImg.getWidth());
        DecimalFormat df=new DecimalFormat("0.00");
        img.setImg_size(Double.parseDouble(df.format((float)sourceImg.getWidth() / sourceImg.getHeight())));


        return img;
    }

    public static Img readAndWriteImg(Img img) {
        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream;
        try {
            fileInputStream = new FileInputStream(img.getImgUrl());
            byte[] bytes = new byte[1024];
            String s = ImgUtil.class.getClass().getResource("/").getPath() + "/templates/image/upload"
                    + new Date().toString() ;
            fileOutputStream = new FileOutputStream(new File(s));
            int len = 0;
            while ((len = fileInputStream.read(bytes)) != -1) {
                fileOutputStream.write(bytes, 0, len);

            }
            fileOutputStream.flush();
            fileInputStream.close();
            fileOutputStream.close();
            img.setImgUrl(s.replace(ImgUtil.class.getClass().getResource("/").getPath(), ".."));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{

        }
        return img;
    }

    public static String GenerateImage(String imgStr)
    {   //对字节数组字符串进行Base64解码并生成图片
        if (imgStr == null) //图像数据为空
            return null;
        BASE64Decoder decoder = new BASE64Decoder();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMDDHHmmss");
        String last = imgStr.substring(imgStr.indexOf("/")+1,imgStr.indexOf(";"));
        imgStr = imgStr.substring(imgStr.indexOf(",")+1,imgStr.length());
        String newURL = System.getProperty("user.dir")+"\\src\\main\\resources/templates/image/upload/"
                + simpleDateFormat.format(new Date()) +"." + last;
        try
        {
            //Base64解码
            byte[] b = decoder.decodeBuffer(imgStr);
            for(int i=0;i<b.length;++i)
            {
                if(b[i]<0)
                {//调整异常数据
                    b[i]+=256;
                }
            }
            //生成jpeg图片
            OutputStream out = new FileOutputStream(newURL);
            out.write(b);
            out.flush();
            out.close();
            return newURL;
        }
        catch (Exception e)
        {
            return null;
        }
    }
    public static void  main (String args[]){
        String newURL = System.getProperty("user.dir")+"\\src\\main\\resources/templates/image/upload/";

        System.out.println(newURL);
    }

}
