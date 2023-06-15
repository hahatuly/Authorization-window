import java.io.*;

public class login {

    public static void baztruelog(String x) throws IOException //проверка логина при регистрации
    {
        File file = new File("bazalogin.txt");
        Main.svobod = true; //если будет хоть одно совпадение, это тру анулируется и будет повторяться пока совпадений не будет
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            int j = 0;
            String line = reader.readLine();
            while (line != null)
            {
                if (line.equals(x))
                {
                    Main.svobod = false;
                    System.out.println("Имя занято");
                }
                line = reader.readLine();
                j++;
            }
    }

        public static void bazlog(String x) throws IOException //запись логина
        {
                File file = new File("bazalogin.txt");
                FileWriter pw = new FileWriter("bazalogin.txt", true);
                pw.write("\n");
                pw.write(x);
                pw.close();
        }


    public static int vhodl(String a) throws IOException //чтение логина
    {
        File file = new File("bazalogin.txt");
        FileReader fr = new FileReader(file);
        BufferedReader reader = new BufferedReader(fr);
        int j=0;
        String line = reader.readLine();
        while (line != null)
        {
            if (line.equals(a))
            {
                break;
            }
            line = reader.readLine();
            j++;
        }
        return j;
    }
}
