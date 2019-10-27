public class info
{
    private String followers;
    private int repo;
    private int userFollowers;
    private int userFollowing;
    private int userStar;
    private String url;

    public info(String followers, int repo,int userFollowers,int userFollowing, String url)
    {
        this.followers = followers;
        this.repo = repo;
        this.userFollowers = userFollowers;
        this.userFollowing = userFollowing;
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

    public int getUserFollowing()
    {
        return userFollowing;
    }

    public void setUserFollowing(int userFollowing)
    {
        this.userFollowing = userFollowing;
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
