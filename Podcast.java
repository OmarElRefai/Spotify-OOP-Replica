import java.util.ArrayList;

/*
 * A Podcast is a type of AudioContent. 
 * A podcast is essentially a talk radio series on demand. 
 * This means that listeners don't need to turn up and tune in live, 
 * but can listen any time (and pretty much anywhere) they like. 
 * Podcasts tend to be focused on a theme or topic.
 * 
 *  Podcasts have a host as well as a list of Seasons. Each Season consists of a list of episodes (strings representing
 *  the "audiofiles") and episode titles (strings)
 */
// Name: Omar El Refai
// Student ID: 501149596
public class Podcast extends AudioContent
{
	public static final String TYPENAME =	"PODCAST";
	private String host; // can be a comma separated list of names
		
	private ArrayList<Season> seasons;
	private int currentSeason = 0;
	private int currentEpisode = 0;
	
	public Podcast(String title, int year, String id, String type, String host, ArrayList<Season> seasons)
	{
		super(title, year, id, type, "", 0);
		this.host = host;
		if (seasons == null)
		{
			seasons = new ArrayList<Season>();
			
		}
		else
			this.seasons = seasons;
	}
	
	public String getType()
	{
		return TYPENAME;
	}
	
	public void printInfo()
	{
		super.printInfo();
		System.out.println("Host: " + host);
		System.out.println("Seasons: " + seasons.size());
	}
	
	public void play()
	{
		setAudioFile(seasons.get(currentSeason).episodeTitles.get(currentEpisode) + ".\n" + seasons.get(currentSeason).episodeFiles.get(currentEpisode));
		super.play();
	}
	
	public void printSeasonEpisodes(int season)
	{
		for (int i = 0; i < seasons.get(season-1).episodeTitles.size(); i++)
		{
			String title = seasons.get(season-1).episodeTitles.get(i);
			int epi = i + 1;
			System.out.println("Episode " + epi + ". " + title + "\n");
		}
	}
	
	public String getHost()
	{
		return host;
	}
	public void setHost(String host)
	{
		this.host = host;
	}
	
	
	public void setSeason(int season)
	{
		if (season >= 1 && season <= seasons.size())
		{
			currentSeason = season - 1;
		}
	}

	public void setEpisode(int episode)
	{
		if (episode >= 1 && episode <= seasons.get(currentSeason).episodeTitles.size())
		{
			currentEpisode = episode - 1;
		}
	}

	public ArrayList<Season> getSeasons()
	{
		return seasons;
	}
	public void setSeasons(ArrayList<Season> seasons)
	{
		this.seasons = seasons;
	}
	
	// Two podcasts are equal if they have the same host and their AudioContent information is equal 
	public boolean equals(Object other)
	{
		Podcast otherPod = (Podcast) other;
		return super.equals(other) && host.equals(otherPod.host); 
	}
}
