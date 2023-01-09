package image;

import java.awt.*;

import java.awt.image.BufferedImage;

import java.io.File;
import java.io.FileNotFoundException;

import java.io.FileOutputStream;

import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.util.Date;
import java.util.Random;

import static java.lang.Math.pow;

//���ݹ�ʽ�������ص���ɫ����ͼ��1024*1024��

public class image {
        public static void main(String[] args) throws IOException {

            makePicture("E:\\test\\test.png",1024,1024);
            setAlpha("E:\\test\\test.png");
            System.out.println("�������");
        }



        public static void makePicture(String address,int width, int height) throws FileNotFoundException, IOException {
            //1���õ�ͼƬ������

            BufferedImage bi=new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
            Graphics2D g2=(Graphics2D)bi.getGraphics();

            //���ñ���ɫ,���������ֵ
            Random random = new Random();
            int a1 = random.nextInt(255);
            int b1 = random.nextInt(255);
            int c1 = random.nextInt(255);
            int a2 = random.nextInt(255);
            int b2 = random.nextInt(255);
            int c2 = random.nextInt(255);
            g2.setColor(new Color(255,255,255));//������ɫ
            Color color1 = new Color(a1, b1, c1);
            Color color2 = new Color(a2, b2, c2);
            //GradientPaint paint = new GradientPaint(random.nextInt(1024),random.nextInt(720),color1,random.nextInt(1024),random.nextInt(720),color2);


            //����ɫ���
            //g2.setPaint(paint);
            g2.fillRect(0, 0, width, height);

            //��ͼƬ�ӱ߿����⣩
            /*
            g2.setColor(Color.RED);

            g2.drawRect(0, 0, 1080-1, 720-1);
            */

//b����ͼƬ

            ImageIO.write(bi,"JPEG",new FileOutputStream(address));
        }


        public static void setAlpha(String os){
            try {
                //��ȡͼƬ
                ImageIcon imageIcon = new ImageIcon(os);
                BufferedImage bufferedImage = new BufferedImage(1024,1024, BufferedImage.TYPE_4BYTE_ABGR);
                Graphics2D g2D = (Graphics2D) bufferedImage.getGraphics();

                g2D.drawImage(imageIcon.getImage(), 0, 0, imageIcon.getImageObserver());
                //ѭ��ÿһ�����ص㣬�ı����ص�RGB
                for (int y = bufferedImage.getMinY(); y < bufferedImage.getHeight(); y++) {
                    for (int x = bufferedImage.getMinX(); x < bufferedImage.getWidth(); x++) {
                       // int pixel = bufferedImage.getRGB(j2, j1);
                        int[] rgb = new int[3];

                        //�����µ�rgb
                        rgb[0] = caculateR(x,y);;
                        rgb[1] = caculateG(x,y);
                        rgb[2] = caculateB(x,y);

                        //�����¼�������ظ���
                        int color = ((0xFF << 24)|( rgb[0] << 16)|( rgb[1] << 8)| rgb[2]);
                        bufferedImage.setRGB(x, y,color);


                    }
                }
                g2D.drawImage(bufferedImage, 0, 0, imageIcon.getImageObserver());

                //long pngnum=new Date().getTime();
                //����ͼƬΪPNG
                ImageIO.write(bufferedImage, "png",  new File("E:\\test\\test2.png"));

                // System.out.println(uploadFolder+pngnum+".png");

            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }


        /*
        public static int caculateR(int x,int y){
            //return  (int) Math.atan2(x/2,y/2)*255;
            return (int) (Math.pow(y,Math.log(x)))%255;
        }

        public static int caculateG(int x,int y){
            return (int) (Math.exp(Math.log(y))+Math.pow(x,3))%255;
        }

        public static int caculateB(int x,int y){
            return (int) (Math.exp(Math.log(y))+Math.pow(x,Math.log(y)))%255;
        }*/
        public static int caculateR(int x,int y){
            double a=0,b=0,c,d,n=0;
            while((c=a*a)+(d=b*b)<4&&n++<880)
            {
                b=2*a*b+y*8e-9-.645411;
                a=c-d+x*8e-9+.356888;
            }
            return (int) (255*pow((n-80)/800,3.));

        }

    public static int caculateG(int x,int y){
        double a=0,b=0,c,d,n=0;
        while((c=a*a)+(d=b*b)<4&&n++<80)
        {b=2*a*b+y*8e-9-.645411;a=c-d+x*8e-9+.356888;}
        return (int) (255*pow((n-80)/800,.7));
    }

    public static int caculateB(int x,int y){
        double a=0,b=0,c,d,n=0;
        while((c=a*a)+(d=b*b)<4&&n++<880)
        {b=2*a*b+y*8e-9-.645411;a=c-d+x*8e-9+.356888;}
        return (int) (255*pow((n-80)/800,.5));

    }
}