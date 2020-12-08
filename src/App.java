import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
public class App {
    public static void main(String[] args) throws Exception {
        BufferedImage img = null; 
        File f = null; 
        // đọc file 
        try
        { 
            f = new File("E://test.jpg"); 
            img = ImageIO.read(f); 
        } 
        catch(IOException e) 
        { 
            System.out.println(e); 
        } 
        // lấy chiều rộng và chiều cao 
        int width = img.getWidth(); 
        int height = img.getHeight(); 
        //duyệt mảng ảnh 2 chiều 
        for (int y = 0; y < height; y++) 
        { 
            for (int x = 0; x < width; x++) 
            { 
                int p = img.getRGB(x,y); 
                int a = (p>>24)&0xff; 
                int R = (p>>16)&0xff; 
                int G = (p>>8)&0xff; 
                int B = p&0xff; 
                if (R>100 && R>G*2 && R>B*2){//nếu là màu đỏ 
                    R= 0;
                    G=255;//-> tạo màu xanh 
                    B= 0;
                }
                //thiết lập giá trị RGB
                p = (a<<24) | (R<<16) | (G<<8) | B; 
                img.setRGB(x, y, p); 
            } 
        } 
        //ghi vào file 
        try
        { 
            f = new File("E://out.jpg"); 
            ImageIO.write(img, "jpg", f); 
        } 
        catch(IOException e) 
        { 
            System.out.println(e); 
        } 
    }
  
}
