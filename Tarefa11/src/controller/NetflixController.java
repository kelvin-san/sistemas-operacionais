package controller;

import model.Series;
import br.edu.fateczl.ObjectList;
import br.edu.fateczl2.ObjectQueue;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class NetflixController implements INetflixController {
	
	ObjectList RatingTable[] = new ObjectList[5];
	
	public NetflixController() {
		for (int i = 0; i < 5; i++) {
			RatingTable[i] = new ObjectList();
		}
	}
	
	private BufferedReader readFile() throws IOException, Exception {
		File file = new File("C:\\temp\\netflix_originals_series_2.csv");
		if (file.exists() && file.isFile()) {
			FileReader reader = new FileReader(file);
			BufferedReader buffer = new BufferedReader(reader);
			return buffer;
		} else {
			throw new Exception("File not found");
		}
	}
	
	private ObjectQueue createQueue() throws IOException, Exception {
		ObjectQueue q = new ObjectQueue();
		
		BufferedReader buffer = readFile();
		
		buffer.readLine(); // Removendo linha de cabecalho
		String line = buffer.readLine();
		String lineAux = line;
		String[] dotAux = new String[4];
		String[] objConstructor = new String[24]; // 12
		Series s = new Series();
		while (line != null) {
			s = new Series();
			lineAux = line;
			objConstructor = line.split(";");
			
			if (objConstructor[1].contains("\"")) {
				dotAux = lineAux.split("\"");
				s.title = dotAux[1].replace(";", ",");
				s.majorGenre = dotAux[0].replace(";", "");
				s.subGenre = dotAux[2].split(";")[1];
				s.premiereYear = Integer.parseInt(dotAux[2].split(";")[3]);
				s.episodes = Integer.parseInt(dotAux[4].split(";")[5]);
				s.status = dotAux[4].split(";")[1];
				s.imdbRating = Integer.parseInt(dotAux[4].split(";")[6]);
			} else {
				s.majorGenre = objConstructor[0];
				s.title = objConstructor[1];
				s.subGenre = objConstructor[2];
				s.premiereYear = Integer.parseInt(objConstructor[4]);
				s.episodes = Integer.parseInt(objConstructor[10]);
				s.status = objConstructor[6];
				s.imdbRating = Integer.parseInt(objConstructor[11]);
			}
			
			q.insert(s);
			line = buffer.readLine();
		}
		
		return q;
	}
	
	@Override
	public void filterByMajorGenre(String genre) throws Exception {
		ObjectQueue q = createQueue();
		
		int qSize = q.size();
		Series s = new Series();
		StringBuffer contentBuffer = new StringBuffer();
		contentBuffer.append("major_genre;title;subgenre;premiere_year;episodes;status;imdb_rating\n");
		String line = "";
		for (int i = 0; i < qSize; i++) {
			s = new Series();
			s = (Series) q.remove();
			if (s.majorGenre.intern() == genre.intern()) {
				line = s.majorGenre + ";" + s.title + ";" + s.subGenre + ";" + s.premiereYear + ";" + s.episodes + ";" + s.status + ";" + s.imdbRating + "\n";
				contentBuffer.append(line);
			}
		}
		
		String fileName = genre + ".csv";
		recFile(fileName, contentBuffer);
	}

	private void recFile(String fileName, StringBuffer content) throws IOException {
		File file = new File("C:\\temp\\" + fileName);
		
		Boolean fileExists = false;
		if (file.exists() && file.isFile()) {
			fileExists = true;
		}
		FileWriter openFile = new FileWriter(file, fileExists);
		PrintWriter writeFile = new PrintWriter(openFile);
		writeFile.write(content.toString());
		writeFile.flush();
		writeFile.close();
		openFile.close();
	}

	@Override
	public void filterByPremiereYear(int year) throws Exception {
		
	}

	@Override
	public void createHashTableByRating() {
		
	}

	@Override
	public void showRatingHashTable() throws Exception {
		
	}

}
