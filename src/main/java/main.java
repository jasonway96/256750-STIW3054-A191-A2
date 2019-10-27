import java.io.IOException;

public class main extends GetHostFollowers
{
    public static void main (String[] args) throws IOException
    {
        GetHostFollowers.findAll();
        WriteExcel.main();
    }
}
