
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Simulation of audio content in an online store
// The songs, podcasts, audiobooks listed here can be "downloaded" to your library
// Name: Omar El Refai
// Student ID: 501149596
public class AudioContentStore
{
		private ArrayList<AudioContent> contents;
		private Map<String, Integer> titleToIndexMap;
		private Map<String, ArrayList<Integer>> artistToIndicesMap;
		private Map<String, ArrayList<Integer>> genreMap;

		private Map<String, ArrayList<Integer>> partialMatch;
		public AudioContentStore()
		{
			titleToIndexMap = new HashMap<>();
			artistToIndicesMap = new HashMap<>();
			genreMap = new HashMap<>();
			partialMatch = new HashMap<>();

			try {
				contents = readAudioContentFromFile("store.txt");
			} catch (IOException e) {
				System.err.println(e.getMessage());
				System.exit(1);
			}

//		  // Create some songs audiobooks and podcasts and to store
//			String file = "Yesterday, all my troubles";
//			contents.add(new Song("Yesterday", 1965, "123", Song.TYPENAME, file, 2, "The Beatles", "Paul McCartney", Song.Genre.POP, file));
//
//			file = "I'm sorry if I seem uninterested\n"
//					+ "Or I'm not listenin' or I'm indifferent\n"
//					+ "Truly, I ain't got no business here\n"
//					+ "But since my friends are here, I just came to kick it\n"
//					+ "But really I would rather be at home all by myself not in this room\n"
//					+ "With people who don't even care about my well being";
//			contents.add(new Song("Here", 2015, "391", Song.TYPENAME, file, 3, "Alessia Cara", "Alessia Cara", Song.Genre.POP, file));
//
//			file = "Yo, Big Shaq, the one and only\n"
//					+ "Man's not hot, never hot\n"
//					+ "Skrrat (GottiOnEm), skidi-kat-kat\n"
//					+ "Boom\n"
//					+ "Two plus two is four\n"
//					+ "Minus one that's three, quick maths\n"
//					+ "Everyday man's on the block\n"
//					+ "Smoke trees (Ah)";
//			contents.add(new Song("Man's Not Hot", 2017, "374", Song.TYPENAME, file, 2, "Michael Dapaah", "Michael Dapaah", Song.Genre.RAP, file));
//
//			file = "The world was on fire and no one could save me but you\n"
//					+ "It's strange what desire will make foolish people do\n"
//					+ "I never dreamed that I'd meet somebody like you\n"
//					+ "And I never dreamed that I'd lose somebody like you";
//			contents.add(new Song("Wicked Game", 1989, "185", Song.TYPENAME, file, 4, "Chris Isaak", "Chris Isaak", Song.Genre.ROCK, file));
//
//			file = "The lights go out and I can't be saved\n"
//					+ "Tides that I tried to swim against\n"
//					+ "Have brought me down upon my knees\n"
//					+ "Oh, I beg, I beg and plead\n"
//					+ "Singin' come out of things un said";
//			contents.add(new Song("Clocks", 2002, "875", Song.TYPENAME, file, 5, "Coldplay", "Guy Berryman, Chris Martin", Song.Genre.ROCK, file));
//
//			file = "I'm waking up to ash and dust\n"
//					+ "I wipe my brow and I sweat my rust\n"
//					+ "I'm breathing in the chemicals";
//			contents.add(new Song("Radioactive", 2012, "823", Song.TYPENAME, file, 3, "Imagine Dragons", "Josh Mosser, A. Grant, Dan Reynolds, Wayne Sermon, Ben McKee", Song.Genre.ROCK, file));
//
//			file = "Birds flying high\n"
//					+ "You know how I feel\n"
//					+ "Sun in the sky\n"
//					+ "You know how I feel\n"
//					+ "Breeze driftin' on by\n"
//					+ "You know how I feel\n"
//					+ "It's a new dawn\n"
//					+ "It's a new day\n"
//					+ "It's a new life\n"
//					+ "For me";
//			contents.add(new Song("Feelin' Good", 1965, "875", Song.TYPENAME, file, 3, "Nina Simone",
//					"Anthony Newley, Leslie Bricusse",Song.Genre.JAZZ, file));
//
//			file = "Find table spaces, say your social graces\n"
//					+ "Bow your head, they're pious here\n"
//					+ "But you and I, we're pioneers, we make our own rules\n"
//					+ "Our own room, no bias here";
//			contents.add(new Song("Wild Things", 2015, "443", Song.TYPENAME, file, 4, "Alessia Cara", "Alessia Cara", Song.Genre.POP, file));
//
//			AudioBook book = new AudioBook("Harry Potter and the Goblet of Fire", 2015, "894", AudioBook.TYPENAME,  "", 1236,
//					"J.K. Rowling", "Jim Dale", makeHPChapterTitles(), makeHPChapters());
//			contents.add(book);
//
//			book = new AudioBook("Moby Dick", 2018, "376", AudioBook.TYPENAME,  "", 1422,
//					"Herman Melville", "Pete Cross", makeMDChapterTitles(), makeMDChapters());
//			contents.add(book);
//
//			book = new AudioBook("Shogun", 2018, "284", AudioBook.TYPENAME,  "", 3213,
//					"James Clavel", "Ralph Lister", makeSHChapterTitles(), makeSHChapters());
//			contents.add(book);
//
//			Podcast podcast = new Podcast("The Secret Life of Canada", 2021, "865", Podcast.TYPENAME,
//					"Leah-Simone Bowen, Falen Johnson", makeSeasons());
//			contents.add(podcast);
		}
		
		
		public AudioContent getContent(int index)
		{
			if (index < 1 || index > contents.size())
			{
				return null;
			}
			return contents.get(index-1);
		}
		
		public void listAll()
		{
			for (int i = 0; i < contents.size(); i++)
			{
				int index = i + 1;
				System.out.print(index + ". ");
				contents.get(i).printInfo();
				System.out.println();
			}
		}
		public int getTotalContents() {
			return contents.size();
		}
		
//		private ArrayList<String> makeHPChapterTitles()
//		{
//			ArrayList<String> titles = new ArrayList<String>();
//			titles.add("The Riddle House");
//			titles.add("The Scar");
//			titles.add("The Invitation");
//			titles.add("Back to The Burrow");
//			return titles;
//		}

//		private ArrayList<String> makeHPChapters()
//		{
//			ArrayList<String> chapters = new ArrayList<String>();
//			chapters.add("In which we learn of the mysterious murders\n"
//					+ "in the Riddle House fifty years ago, \n"
//					+ "how Frank Bryce was accused but released for lack of evidence, \n"
//					+ "and how the Riddle House fell into disrepair. ");
//			chapters.add("In which Harry awakens from a bad dream, \n"
//					+ "his scar burning, we recap Harry�s previous adventures, \n"
//					+ "and he writes a letter to his godfather.");
//			chapters.add("In which Dudley and the rest of the Dursleys are on a diet,\n"
//					+ "and the Dursleys get letter from Mrs. Weasley inviting Harry to stay\n"
//					+ "with her family and attend the World Quidditch Cup finals.");
//			chapters.add("In which Harry awaits the arrival of the Weasleys, \n"
//					+ "who come by Floo Powder and get trapped in the blocked-off fireplace,\n"
//					+ "blast it open, send Fred and George after Harry�s trunk,\n"
//					+ "then Floo back to the Burrow. Just as Harry is about to leave, \n"
//					+ "Dudley eats a magical toffee dropped by Fred and grows a huge purple tongue. ");
//			return chapters;
//		}

//		private ArrayList<String> makeMDChapterTitles()
//		{
//			ArrayList<String> titles = new ArrayList<String>();
//			titles.add("Loomings.");
//			titles.add("The Carpet-Bag.");
//			titles.add("The Spouter-Inn.");
//			return titles;
//		}
//		private ArrayList<String> makeMDChapters()
//		{
//			ArrayList<String> chapters = new ArrayList<String>();
//			chapters.add("Call me Ishmael. Some years ago�never mind how long precisely�having little\n"
//					+ "or no money in my purse, and nothing particular to interest me on shore,\n"
//					+ "I thought I would sail about a little and see the watery part of the world.");
//			chapters.add("stuffed a shirt or two into my old carpet-bag, tucked it under my arm, \n"
//					+ "and started for Cape Horn and the Pacific. Quitting the good city of old Manhatto, \n"
//					+ "I duly arrived in New Bedford. It was a Saturday night in December.");
//			chapters.add("Entering that gable-ended Spouter-Inn, you found yourself in a wide, \n"
//					+ "low, straggling entry with old-fashioned wainscots, \n"
//					+ "reminding one of the bulwarks of some condemned old craft.");
//			return chapters;
//		}

//		private ArrayList<String> makeSHChapterTitles()
//		{
//			ArrayList<String> titles = new ArrayList<String>();
//			titles.add("");
//			titles.add("");
//			titles.add("");
//			titles.add("");
//			return titles;
//		}
//
//		private ArrayList<String> makeSHChapters()
//		{
//			ArrayList<String> chapters = new ArrayList<String>();
//			chapters.add("The gale tore at him and he felt its bite deep within\n"
//					+ "and he knew that if they did not make landfall in three days they would all be dead");
//			chapters.add("Blackthorne was suddenly awake. For a moment he thought he was dreaming\n"
//					+ "because he was ashore and the room unbelieveable");
//			chapters.add("The daimyo, Kasigi Yabu, Lord of Izu, wants to know who you are,\n"
//					+ "where you come from, how ou got here, and what acts of piracy you have committed.");
//			chapters.add("Yabu lay in the hot bath, more content, more confident than he had ever been in his life.");
//			return chapters;
//		}

		// Podcast Seasons
//		private ArrayList<Season> makeSeasons()
//		{
//			ArrayList<Season> seasons = new ArrayList<Season>();
//		  Season s1 = new Season();
//		  s1.episodeTitles.add("Bay Blanket");
//		  s1.episodeTitles.add("You Don't Want to Sleep Here");
//		  s1.episodeTitles.add("The Gold Rush");
//		  s1.episodeFiles.add("The Bay Blanket. These warm blankets are as iconic as Mariah Carey's \n"
//		  		+ "lip-syncing, but some people believe they were used to spread\n"
//		  		+ "smallpox and decimate entire Indigenous communities. \n"
//		  		+ "We dive into the history of The Hudson's Bay Company and unpack the\n"
//		  		+ "very complicated story of the iconic striped blanket.");
//		  s1.episodeFiles.add("There is no doubt that the Klondike Gold Rush was an iconic event. \n"
//		  		+ "But what did the mining industry cost the original people of the territory? \n"
//		  		+ "And what was left when all the gold was gone? And what is a sour toe cocktail?");
//		  s1.episodeFiles.add("here is no doubt that the Klondike Gold Rush was an iconic event. \n"
//		  		+ "But what did the mining industry cost the original people of the territory? \n"
//		  		+ "And what was left when all the gold was gone? And what is a sour toe cocktail?");
//		  s1.episodeLengths.add(31);
//		  s1.episodeLengths.add(32);
//		  s1.episodeLengths.add(45);
//		  seasons.add(s1);
//		  Season s2 = new Season();
//		  s2.episodeTitles.add("Toronto vs Everyone");
//		  s2.episodeTitles.add("Water");
//		  s2.episodeFiles.add("There is no doubt that the Klondike Gold Rush was an iconic event. \n"
//		  		+ "But what did the mining industry cost the original people of the territory? \n"
//		  		+ "And what was left when all the gold was gone? And what is a sour toe cocktail?");
//		  s2.episodeFiles.add("Can the foundation of Canada be traced back to Indigenous trade routes?\n"
//		  		+ "In this episode Falen and Leah take a trip across the Great Lakes, they talk corn\n"
//		  		+ "and vampires, and discuss some big concerns currently facing Canada's water.");
//		  s2.episodeLengths.add(45);
//		  s2.episodeLengths.add(50);
//
//		  seasons.add(s2);
//		  return seasons;
//		}


		public int findIndexByTitle(String title) {
			if (titleToIndexMap.containsKey(title)) {
				return titleToIndexMap.get(title);
			} else {
				for (int i = 0; i < contents.size(); i++) {
					if (contents.get(i).getTitle().equals(title)) {
						titleToIndexMap.put(title, i);
						return i;
					}
				}
			throw new Library.AudioContentNotFoundException("No matches for " + title);
			}
		}
		public ArrayList<Integer> searchAudioContentByArtist(String artist) {
			if (artistToIndicesMap.containsKey(artist)) {
				return artistToIndicesMap.get(artist);
			} else {
				ArrayList<Integer> indices = new ArrayList<>();
				for (int i = 0; i < contents.size(); i++) {
					AudioContent content = contents.get(i);
					if (content instanceof Song && ((Song) content).getArtist().equalsIgnoreCase(artist)) {
						indices.add(i);
					} else if (content instanceof AudioBook && ((AudioBook) content).getAuthor().equalsIgnoreCase(artist)) {
						indices.add(i);
					}
				}
				if (!indices.isEmpty()) {
					artistToIndicesMap.put(artist, indices);
				}
				else {
					throw new Library.AudioContentNotFoundException("No matches for " + artist);
				}
				return indices;

			}
		}
		public ArrayList<Integer> searchbyGenre(String genre) {
			if (genreMap.containsKey(genre)) {
				return genreMap.get(genre);
			} else {
				ArrayList<Integer> indices = new ArrayList<>();
				for (int i = 0; i < contents.size(); i++) {
					AudioContent content = contents.get(i);
					if (content instanceof Song && ((Song) content).getGenre().equals(Song.Genre.valueOf(genre))) {
						indices.add(i);
					}
				}
				if (!indices.isEmpty()) {
					genreMap.put(genre, indices);
				}
				else {
					throw new Library.AudioContentNotFoundException("Genre is empty!");
				}
				return indices;
			}
		}


		public ArrayList<Integer> searchByPartialMatch(String target) {
			if (partialMatch.containsKey(target)) {
				return partialMatch.get(target);
			} else {
				ArrayList<Integer> indices = new ArrayList<>();
				for (int i = 0; i < contents.size(); i++) {
					AudioContent content = contents.get(i);
					boolean match = false;

					if (content.getTitle().toLowerCase().contains(target.toLowerCase())) {
						match = true;
					} else if (content instanceof Song) {
						Song song = (Song) content;
						if (song.getArtist().toLowerCase().contains(target.toLowerCase()) ||
								song.getComposer().toLowerCase().contains(target.toLowerCase()) ||
								song.getLyrics().toLowerCase().contains(target.toLowerCase())) {
							match = true;
						}
					} else if (content instanceof AudioBook) {
						AudioBook audioBook = (AudioBook) content;
						if (audioBook.getAuthor().toLowerCase().contains(target.toLowerCase()) ||
								audioBook.getNarrator().toLowerCase().contains(target.toLowerCase())) {
							match = true;
						}
					}

					if (match) {
						indices.add(i);
					}
				}

				if (!indices.isEmpty()) {
					partialMatch.put(target, indices);
				} else {
					throw new Library.AudioContentNotFoundException("No matches for " + target);
				}
				return indices;
			}
		}
		private ArrayList<AudioContent> readAudioContentFromFile(String filename) throws IOException {
			ArrayList<AudioContent> audioContents = new ArrayList<>();
			Scanner scanner = new Scanner(new File(filename));

			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				if (line.equalsIgnoreCase("SONG")) {
					String id = scanner.nextLine();
					String title = scanner.nextLine();
					int year = Integer.parseInt(scanner.nextLine());
					int length = Integer.parseInt(scanner.nextLine());
					String artist = scanner.nextLine();
					String composer = scanner.nextLine();
					String genre = scanner.nextLine();
					Song.Genre songGenre = Song.Genre.valueOf(genre.toUpperCase());
					int lyricsLines = Integer.parseInt(scanner.nextLine());
					String lyrics = "";
					for (int i = 0; i < lyricsLines; i++) {
						if (i == 0) {
							lyrics = scanner.nextLine();
						} else {
							lyrics += "\n" + scanner.nextLine();
						}
					}
					audioContents.add(new Song(title, year, id, Song.TYPENAME, "", length, artist, composer, songGenre, lyrics));
				} else if (line.equalsIgnoreCase("AUDIOBOOK")) {
					String id = scanner.nextLine();
					String title = scanner.nextLine();
					int year = Integer.parseInt(scanner.nextLine());
					int length = Integer.parseInt(scanner.nextLine());
					String author = scanner.nextLine();
					String narrator = scanner.nextLine();
					int numChapters = Integer.parseInt(scanner.nextLine());

					ArrayList<String> chapterTitles = new ArrayList<>();
					for (int i = 0; i < numChapters; i++) {
						chapterTitles.add(scanner.nextLine());
					}

					ArrayList<String> chapters = new ArrayList<>();
					for (int i = 0; i < numChapters; i++) {
						int chapterLines = Integer.parseInt(scanner.nextLine());
						String chapter = "";
						for (int j = 0; j < chapterLines; j++) {
							if (j == 0) {
								chapter = scanner.nextLine();
							} else {
								chapter += "\n" + scanner.nextLine();
							}
						}
						chapters.add(chapter);
					}

					audioContents.add(new AudioBook(title, year, id, AudioBook.TYPENAME, "", length, author, narrator, chapterTitles, chapters));
				}
			}

			scanner.close();
			return audioContents;
		}
}
