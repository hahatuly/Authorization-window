import java.util.Calendar;
import java.util.GregorianCalendar;

public class loger
{
    public static int iter = 1; // потому что первый раз увеличение итера не будет ибо условие не выполнится но это попытку надо защитать
    public static int lastminute = -1; //чтобы первой записи было с чем сравнивать и это должна быть несуществующая минута
    public static int nowminute;
    public static void savetime ()
    {
        Calendar calendar = new GregorianCalendar();
        nowminute = calendar.get(Calendar.MINUTE); // запись текущей минуты
        if (nowminute==lastminute)
        {
            iter+=1;
        }
        lastminute = nowminute;
        if (iter==5)
        {
            Main.svobod=false;
            iter=0;
            System.out.println("Вы привысили допустимое количество попыток входа");
        }
    }
}
