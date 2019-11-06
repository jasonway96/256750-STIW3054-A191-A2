import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.LinkedList;

class  GetHostFollowers extends Thread
{
    private static String readAll(Reader rd) throws IOException
    {
        StringBuilder sb = new StringBuilder();
        int cp;

        while ((cp = rd.read()) != -1)
        {
            sb.append((char) cp);
        }

        return sb.toString();
    }

    public synchronized static JSONArray readJsonFromUrl(String url) throws IOException, JSONException
    {
        InputStream is = new URL(url).openStream();
        try
        {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONArray json = new JSONArray(jsonText);
            return json;
        }

        finally
        {
            is.close();
        }
    }

    public synchronized static LinkedList<info> findAll() throws IOException, JSONException
    {
        LinkedList<info> info = new LinkedList<info>();

        int total = 0;
        int repoTotal = 0;
        String test = null;

        JSONArray json = readJsonFromUrl("https://api.github.com/users/zhamri/followers?access_token=ff57f6f34980fc5f1dd7f17c442645f2829b749f");


        for (int i = 0; i < json.length(); i++)
        {
            JSONObject jsonObject = json.getJSONObject(i);
            String hostFollowers = jsonObject.optString("login");
            String hostLink = jsonObject.optString("followers_url");
            String hostRepo = jsonObject.optString("repos_url");
            String hostFollowing = jsonObject.optString("subscriptions_url");
            String hostURL = jsonObject.optString("html_url");
            JSONArray json1 = readJsonFromUrl(hostLink+"?access_token=ff57f6f34980fc5f1dd7f17c442645f2829b749f");
            JSONArray json2 = readJsonFromUrl(hostRepo+"?access_token=ff57f6f34980fc5f1dd7f17c442645f2829b749f");
            JSONArray json3 = readJsonFromUrl(hostFollowing+"?access_token=ff57f6f34980fc5f1dd7f17c442645f2829b749f");

            for (int j = 0; j < json1.length(); j++)
            {
                JSONObject jsonObject1 = json1.getJSONObject(j);
                jsonObject1.optString("login");
                total = 1 + j++;

            }

            for (int k = 0; k < json2.length(); k++)
            {
                JSONObject jsonObject2 = json2.getJSONObject(k);
                jsonObject2.optString("id");
                repoTotal = 1 + k++;
            }

            for (int l = 0; l < json3.length(); l++)
            {
                JSONObject jsonObject3 = json3.getJSONObject(l);
                test=jsonObject3.optString("name");

            }


            info.add(new info(hostFollowers, repoTotal, total,test,hostURL));

        }

        return info;

    }

}


