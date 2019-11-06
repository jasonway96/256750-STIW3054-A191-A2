public class info
{
    private String followers;
    private int repo;
    private int userFollowers;
    private String url;
    private String subs;

    public info(String followers, int repo,int userFollowers,String subs, String url)
    {
        this.followers = followers;
        this.repo = repo;
        this.userFollowers = userFollowers;
        this.subs = subs;
        this.url = url;
    }


    public String getFollowers()
    {
        return followers;
    }

    public void setFollowers(String followers)
    {
        this.followers = followers;
    }

    public int getRepo()
    {

        return repo;
    }

    public void setRepo(int repo)
    {

        this.repo = repo;
    }

    public int getUserFollowers()
    {

        return userFollowers;
    }

    public void setUserFollowers(int userFollowers)
    {
        this.userFollowers = userFollowers;
    }

    public String getSubs()
    {
        return subs;
    }

    public void setSubs(String subs)
    {
        this.subs = subs;
    }

    public String getURL()
    {
        return url;
    }

    public void setURL(String url)
    {
        this.url = url;
    }
}
