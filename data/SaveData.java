/**
 * 
 */
package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import representation.Game;

/**
 *
 */
public class SaveData {

	private static final String savePath = "./jumanji/session";
	private static final String saveFile = "saved.data";

	/**
	 * 
	 * @param game
	 */
	
	public static void saveGame(Game game) {
		File file = new File(savePath);

		file.mkdirs();

		File fileSave = new File(savePath + "/" + saveFile);

		List<Game> recordList = new ArrayList<>();
		ObjectInputStream objectinputstream = null;
		ObjectOutputStream objectOutputStream = null;
		try {
			if (fileSave.exists()) {
				FileInputStream streamIn = new FileInputStream(fileSave);
				objectinputstream = new ObjectInputStream(streamIn);
				recordList = (List<Game>) objectinputstream.readObject();
				objectinputstream.close();
			}

			recordList.add(0,game);

			FileOutputStream fout = new FileOutputStream(fileSave);

			objectOutputStream = new ObjectOutputStream(fout);
			objectOutputStream.writeObject(recordList);

			System.out.println("\n\tSession sauvegardée avec succès!");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (objectinputstream != null) {
					objectinputstream.close();
				}
				if (objectOutputStream != null) {
					objectOutputStream.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}


	/**
	 * 
	 * @param game
	 */
	public static List<Game> loadGame() {
		File fileSave = new File(savePath + "/" + saveFile);

		List<Game> recordList = new ArrayList<>();
		ObjectInputStream objectinputstream = null;
		try {
			if (fileSave.exists()) {
				FileInputStream streamIn = new FileInputStream(fileSave);
				objectinputstream = new ObjectInputStream(streamIn);
				recordList = (List<Game>) objectinputstream.readObject();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (objectinputstream != null) {
					objectinputstream.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return recordList;

	}

}
