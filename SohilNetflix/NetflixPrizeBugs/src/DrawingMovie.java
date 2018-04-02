

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

import processing.core.PApplet;
import processing.core.PImage;

public class DrawingMovie {

	private Movie movie;
	private PImage coverArt;
	
	public DrawingMovie(Movie m) {
		this.movie = m;
		coverArt = null;
	}
	
	public void draw(PApplet drawer, float x, float y, float width, float height) {
		if (movie != null) {
			if (coverArt != null) {
				drawer.image(coverArt, x, y,width,height);
			}
			
			String title = movie.getTitle();
			drawer.text(title, x, y);
			
		}
		drawer.stroke(0);
		drawer.noFill();
		drawer.rect(x, y, width, height);
	}
	

	public void downloadArt(PApplet drawer) {
		
		Thread downloader = new Thread(new Runnable() {

			@Override
			public void run() {
				
				
				// Find the cover art using IMDB links
				// Initialize coverArt
				Scanner scan = null;
				
				try {

					String link = movie.getImdbID();

					String pageURLString = "http://www.imdb.com/title/tt" + link + "/";



					URL pageURL = new URL(pageURLString);
					InputStream is = pageURL.openStream();
					scan = new Scanner(is);

					String fileData = "";
					while (scan.hasNextLine()) {
						String line = scan.nextLine();

						fileData += line + FileIO.lineSeparator;
					}

					// Look for <div class="poster">
					// Look for src="
					// Look for "
					
					int start = fileData.indexOf("src=\"", fileData.indexOf("<div class=\"poster\"")) + 5;
					int end = fileData.indexOf("\"", start + 1);
					
					String imageURL = fileData.substring(start, end);
					coverArt = drawer.loadImage(imageURL);
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					if (scan != null)
						scan.close();
				}
			}
			
		});
		
		downloader.start();

	}

	
}
