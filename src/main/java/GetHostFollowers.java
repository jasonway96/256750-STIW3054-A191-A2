import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.LinkedList;

public class GetHostFollowers
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

    public static JSONArray readJsonFromUrl(String url) throws IOException, JSONException
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

    public static LinkedList<info> findAll() throws IOException, JSONException {
        LinkedList<info> info = new LinkedList<info>();

        int total = 0;
        int repoTotal = 0;
        int followingTotal = 0;
        int starTotal = 0;

        JSONArray json = readJsonFromUrl("https://api.github.com/users/jasonway96/followers");
        /*System.out.println(json.toString());
        System.out.println(json.getJSONArray(1));*/



            for (int i = 0; i < json.length(); i++) {
                JSONObject jsonObject = json.getJSONObject(i);
                String hostFollowers = jsonObject.optString("login");
                String hostLink = jsonObject.optString("followers_url");
                String hostRepo = jsonObject.optString("repos_url");
                String hostFollowing = jsonObject.optString("received_events_url");
                String hostURL = jsonObject.optString("html_url");
//                System.out.println(i + 1 + ": " + hostFollowers);
                JSONArray json1 = readJsonFromUrl(hostLink);
                JSONArray json2 = readJsonFromUrl(hostRepo);
                JSONArray json3 = readJsonFromUrl(hostFollowing);
//                JSONArray json4 = readJsonFromUrl(hostStar);


                for (int j = 0; j < json1.length(); j++) {
                    JSONObject jsonObject1 = json1.getJSONObject(j);
                    String followers = jsonObject1.optString("login");
                    total = 1 + j++;
                }

                for (int k = 0; k < json2.length(); k++) {
                    JSONObject jsonObject2 = json2.getJSONObject(k);
                    String repo = jsonObject2.optString("id");
                    repoTotal = 1 + k++;
                }

                for (int l = 0; l < json3.length(); l++) {
                    JSONObject jsonObject3 = json3.getJSONObject(l);
                    String following = jsonObject3.optString("id");
                    followingTotal = 1 + l++;
                }

//                for (int m = 0; m < json4.length(); m++) {
//                    JSONObject jsonObject4 = json4.getJSONObject(m);
//                    String star = jsonObject4.optString("id");
//                    starTotal = 1 + m++;
//                }


                info.add(new info(hostFollowers, repoTotal, total,followingTotal,hostURL));

            }

            return info;

        }


}