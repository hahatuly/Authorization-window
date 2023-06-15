import java.io.*;
import java.util.Random;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class password {

    public static void bazpass(String y) throws IOException, NoSuchAlgorithmException //запись пароля
    {
        String pat = "(^[a-z])([@#№*])(.*)";

            if (y.matches(pat) && y.length()>=8) {
                FileWriter pw = new FileWriter("bazapassword.txt", true);
                String hy = hash(y);
                pw.write("\n");
                pw.write(hy);
                pw.close();
                System.out.println("Пароль сохранён");
                Main.svobod = true;
            } else
            {
                System.out.println("Пароль составлен некорректно");
                Main.svobod = false;
            }
    }

    public static String bazpassrandom() throws IOException, NoSuchAlgorithmException //генерация и запись пароля
    {

        String klava0 = "abcdefghijklmnopqrstuvwxyz";
        String klava1 = "@#№*";
        String klava = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

        Random r = new Random();
        char c = klava0.charAt(r.nextInt(klava0.length()));
        String porol="";
        porol+=c;
        c = klava1.charAt(r.nextInt(klava1.length()));
        porol+=c;
        for (int i=2; i<8; i++)
        {
            c = klava.charAt(r.nextInt(klava.length()));
            porol+=c;
        }

        return porol;
    }

    public static boolean vhodp(String b) throws IOException, NoSuchAlgorithmException //чтение паролей
    {
        File file = new File("bazapassword.txt");
        FileReader fr = new FileReader(file);
        BufferedReader reader = new BufferedReader(fr);
        String[] line = new String[10];
        int j=0;
        line[j] = reader.readLine();
        while (line[j]!=null)
        {
            j++;
            line[j] = reader.readLine();
        }
        String hb = hash(b);
        if (line[Main.i]!=null && line[Main.i].equals(hb)) //без этого условия кидалась ошибка что строка не может сравниваться с пустотой, и оно должна быть первым
        {
            return true;
        }
        else
        {
            return false;
        }
    }


    public static String hash(String h) throws NoSuchAlgorithmException
    {
        String salt1 = h.replace('s', 'c'); //посолим
        String salt2 = salt1+"salt"; //поперчим

        MessageDigest md = MessageDigest.getInstance("SHA1"); //начинается хэширование
        md.update(salt2.getBytes());
        byte[] digest = md.digest();
        StringBuffer sb = new StringBuffer();
        for (byte b : digest)
        {
            sb.append(String.format("%02x", b & 0xff)); // корвентация байтов в шестнадцатеричное значение
        }
        return sb.toString();
    }
}
