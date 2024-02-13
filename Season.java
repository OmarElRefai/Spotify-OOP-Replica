import java.util.ArrayList;
/*
 * Simple class to model podcast or other content seasons
 */
// Name: Omar El Refai
// Student ID: 501149596
public class Season
{
	public ArrayList<String> episodeFiles;
	public ArrayList<String> episodeTitles;
	public ArrayList<Integer> episodeLengths;
	
	public Season()
	{
		episodeFiles = new ArrayList<String>();
		episodeTitles = new ArrayList<String>();
		episodeLengths = new ArrayList<Integer>();
	}
}
