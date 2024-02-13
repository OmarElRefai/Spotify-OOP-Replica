import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;

// Simulation of a Simple Text-based Music App (like Apple Music)
// Name: Omar El Refai
// Student ID: 501149596
public class MyAudioUI
{
	public static void main(String[] args)
	{
		// Simulation of audio content in an online store
		// The songs, podcasts, audiobooks in the store can be downloaded to your library
		AudioContentStore store = new AudioContentStore();

		// Create my music library
		Library library = new Library();

		Scanner scanner = new Scanner(System.in);
		for (int i = 1; i <= store.getTotalContents(); i++) {
			AudioContent content = store.getContent(i);
			if (content != null) {
				System.out.println("Loading " + content.getType());
			}
		}
		System.out.print(">");


		// Process keyboard actions
		while (scanner.hasNextLine())
		{
			String action = scanner.nextLine();

			if (action == null || action.equals(""))
			{
				System.out.print("\n>");
				continue;
			}
			try {
				if (action.equalsIgnoreCase("Q") || action.equalsIgnoreCase("QUIT"))
					return;

				else if (action.equalsIgnoreCase("STORE"))	// List all songs
				{
					store.listAll();
				}
				else if (action.equalsIgnoreCase("SONGS"))	// List all songs
				{
					library.listAllSongs();
				}
				else if (action.equalsIgnoreCase("BOOKS"))	// List all songs
				{
					library.listAllAudioBooks();
				}
				else if (action.equalsIgnoreCase("PODCASTS"))	// List all songs
				{
					library.listAllPodcasts();
				}
				else if (action.equalsIgnoreCase("ARTISTS"))	// List all songs
				{
					library.listAllArtists();
				}
				else if (action.equalsIgnoreCase("PLAYLISTS"))	// List all play lists
				{
					library.listAllPlaylists();
				}

				else if (action.equalsIgnoreCase("DOWNLOAD")) {
					int fromIndex = 0;
					int toIndex = 0;

					System.out.print("From Store Content #: ");

					if (scanner.hasNextInt()) {
						fromIndex = scanner.nextInt();
						scanner.nextLine();
					}

					System.out.print("To Store Content #: ");
					if (scanner.hasNextInt()) {
						toIndex = scanner.nextInt();
						scanner.nextLine();
					}

					for (int index = fromIndex; index <= toIndex; index++) {
						AudioContent content = store.getContent(index);
						try {
							library.download(content);
							System.out.println(content.getType() + " " + content.getTitle() + " Added to Library");
						} catch (Library.AudioContentAlreadyDownloadedException e) {
							System.out.println(e.getMessage());
						}

					}
				} else if (action.equalsIgnoreCase("DOWNLOADA")) {
					String artistName = "";

					System.out.print("Artist Name: ");
					if (scanner.hasNextLine()) {
						artistName = scanner.nextLine();
					}

					ArrayList<Integer> indices = store.searchAudioContentByArtist(artistName);
					for (int index : indices) {
						AudioContent content = store.getContent(index + 1);
						try {
							library.download(content);
							System.out.println(content.getType() + " " + content.getTitle() + " Added to Library");
						} catch (Library.AudioContentAlreadyDownloadedException e) {
							System.out.println(e.getMessage());
						}
					}
				} else if (action.equalsIgnoreCase("DOWNLOADG")) {
					String genre = "";

					System.out.print("Genre [POP, ROCK, JAZZ, HIPHOP, RAP, CLASSICAL]: ");
					if (scanner.hasNextLine()) {
						genre = scanner.nextLine();
					}
					try {
						ArrayList<Integer> indices = store.searchbyGenre(genre);
						for (int index : indices) {
							AudioContent content = store.getContent(index + 1);
								try {
									library.download(content);
									System.out.println(content.getType() + " " + content.getTitle() + " Added to Library");
								} catch (Library.AudioContentAlreadyDownloadedException e) {
									System.out.println(content.getType() + " " + content.getTitle() + " already downloaded");
								}
						}
					} catch (IllegalArgumentException e) {
						System.out.println("No audio content found for genre: " + genre);
					}
				} else if (action.equalsIgnoreCase("PLAYSONG")) {
					int index = 0;

					System.out.print("Song Number: ");
					if (scanner.hasNextInt()) {
						index = scanner.nextInt();
						// consume the nl character since nextInt() does not
						scanner.nextLine();
					}
					library.playSong(index);
				} else if (action.equalsIgnoreCase("BOOKTOC")) {
					int index = 0;

					System.out.print("Audio Book Number: ");
					if (scanner.hasNextInt()) {
						index = scanner.nextInt();
						scanner.nextLine();
					}
					library.printAudioBookTOC(index);
				} else if (action.equalsIgnoreCase("PLAYBOOK")) {
					int index = 0;

					System.out.print("Audio Book Number: ");
					if (scanner.hasNextInt()) {
						index = scanner.nextInt();
					}
					int chapter = 0;
					System.out.print("Chapter: ");
					if (scanner.hasNextInt()) {
						chapter = scanner.nextInt();
						scanner.nextLine();
					}
					library.playAudioBook(index, chapter);
				} else if (action.equalsIgnoreCase("PODTOC")) {
					int index = 0;
					int season = 0;

					System.out.print("Podcast Number: ");
					if (scanner.hasNextInt()) {
						index = scanner.nextInt();
					}
					System.out.print("Season: ");
					if (scanner.hasNextInt()) {
						season = scanner.nextInt();
						scanner.nextLine();
					}
					library.printPodcastEpisodes(index, season);
				} else if (action.equalsIgnoreCase("PLAYPOD")) {
					int index = 0;

					System.out.print("Podcast Number: ");
					if (scanner.hasNextInt()) {
						index = scanner.nextInt();
						scanner.nextLine();
					}
					int season = 0;
					System.out.print("Season: ");
					if (scanner.hasNextInt()) {
						season = scanner.nextInt();
						scanner.nextLine();
					}
					int episode = 0;
					System.out.print("Episode: ");
					if (scanner.hasNextInt()) {
						episode = scanner.nextInt();
						scanner.nextLine();
					}
					library.playPodcast(index, season, episode);
				} else if (action.equalsIgnoreCase("PLAYALLPL")) {
					String title = "";

					System.out.print("Playlist Title: ");
					if (scanner.hasNextLine()) {
						title = scanner.nextLine();
					}
					library.playPlaylist(title);
				} else if (action.equalsIgnoreCase("PLAYPL")) {
					String title = "";
					int index = 0;

					System.out.print("Playlist Title: ");
					if (scanner.hasNextLine()) {
						title = scanner.nextLine();
					}
					System.out.print("Content Number: ");
					if (scanner.hasNextInt()) {
						index = scanner.nextInt();
						scanner.nextLine();
					}
					library.playPlaylist(title, index);
				}
				// Delete a song from the library and any play lists it belongs to
				else if (action.equalsIgnoreCase("DELSONG")) {
					int songNum = 0;

					System.out.print("Library Song #: ");
					if (scanner.hasNextInt()) {
						songNum = scanner.nextInt();
						scanner.nextLine();
					}

					library.deleteSong(songNum);
				} else if (action.equalsIgnoreCase("MAKEPL")) {
					String title = "";

					System.out.print("Playlist Title: ");
					if (scanner.hasNextLine()) {
						title = scanner.nextLine();
					}
					library.makePlaylist(title);
				} else if (action.equalsIgnoreCase("PRINTPL"))    // print playlist content
				{
					String title = "";

					System.out.print("Playlist Title: ");
					if (scanner.hasNextLine())
						title = scanner.nextLine();

					library.printPlaylist(title);
				}
				// Add content from library (via index) to a playlist
				else if (action.equalsIgnoreCase("ADDTOPL")) {
					int contentIndex = 0;
					String contentType = "";
					String playlist = "";

					System.out.print("Playlist Title: ");
					if (scanner.hasNextLine())
						playlist = scanner.nextLine();

					System.out.print("Content Type [SONG, PODCAST, AUDIOBOOK]: ");
					if (scanner.hasNextLine())
						contentType = scanner.nextLine();

					System.out.print("Library Content #: ");
					if (scanner.hasNextInt()) {
						contentIndex = scanner.nextInt();
						scanner.nextLine(); // consume nl
					}

					library.addContentToPlaylist(contentType, contentIndex, playlist);
				}
				// Delete content from play list
				else if (action.equalsIgnoreCase("DELFROMPL")) {
					int contentIndex = 0;
					String playlist = "";

					System.out.print("Playlist Title: ");
					if (scanner.hasNextLine())
						playlist = scanner.nextLine();

					System.out.print("Playlist Content #: ");
					if (scanner.hasNextInt()) {
						contentIndex = scanner.nextInt();
						scanner.nextLine(); // consume nl
					}
					library.delContentFromPlaylist(contentIndex, playlist);
				} else if (action.equalsIgnoreCase("SORTBYYEAR")) // sort songs by year
				{
					library.sortSongsByYear();
				} else if (action.equalsIgnoreCase("SORTBYNAME")) // sort songs by name (alphabetic)
				{
					library.sortSongsByName();
				} else if (action.equalsIgnoreCase("SORTBYLENGTH")) // sort songs by length
				{
					library.sortSongsByLength();
				} else if (action.equalsIgnoreCase("SEARCH")) {
					System.out.print("Title: ");
					String title = scanner.nextLine();
					int index = store.findIndexByTitle(title);
					try {
						AudioContent content = store.getContent(index + 1);
						System.out.print(index+1 + ". ");
						content.printInfo();
					} catch (Library.AudioContentNotFoundException e) {
						System.out.println(e.getMessage());
					}
				} else if (action.equalsIgnoreCase("SEARCHA")) {
					System.out.print("Artist: ");
					String artistName = scanner.nextLine();
					ArrayList<Integer> indices = store.searchAudioContentByArtist(artistName);
					try {
						for (int index : indices) {
							System.out.print(index + 1 + ". ");
							store.getContent(index + 1).printInfo();
							System.out.println();
						}
					} catch (Library.AudioContentNotFoundException e) {
						System.out.println(e.getMessage());
					}
				} else if (action.equalsIgnoreCase("SEARCHG")) {
					System.out.print("Genre [POP, ROCK, JAZZ, HIPHOP, RAP, CLASSICAL]: ");
					String genre = scanner.nextLine();
					try {
						ArrayList<Integer> indices = store.searchbyGenre(genre);
						try {
							for (int index : indices) {
								System.out.print(index + 1 + ". ");
								store.getContent(index + 1).printInfo();
								System.out.println();
							}
						} catch (Library.AudioContentNotFoundException e) {
							System.out.println(e.getMessage());
						}
					} catch (IllegalArgumentException e) {
						System.out.println("Genre not found!");
					}
				} else if (action.equalsIgnoreCase("SEARCHP")) {
					System.out.print("Enter the target string: ");
					String target = scanner.nextLine();
					try {
						ArrayList<Integer> indices = store.searchByPartialMatch(target);
						for (int index : indices) {
							AudioContent content = store.getContent(index + 1);
							if (content != null) {
								System.out.print((index + 1) + ". ");
								content.printInfo();
								System.out.println();
							}
						}
					} catch (Library.AudioContentNotFoundException e) {
						System.out.println(e.getMessage());
					}
				}

			} catch (Library.AudioContentNotFoundException e) {
				System.out.println(e.getMessage());
			} catch (Library.PlaylistNotFoundException e) {
				System.out.println(e.getMessage());
			} catch (Library.PlaylistAlreadyExistsException e) {
				System.out.println(e.getMessage());
			}  catch (NullPointerException e) {
				System.out.println("Please provide a valid index");
			}
			System.out.print("\n>");
		}
	}
}