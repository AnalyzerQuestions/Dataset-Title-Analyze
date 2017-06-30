/**
 * 
  <p>
 * <b> Analyser Title </b>
 * </p>
 *
 * <p>
 * todos os direitos reservados
 * </p>
 * 
 * @author <a href="https://github.com/JoseRafael97">Rafael Feitosa</a>
 */
package br.edu.ifpb.analyserTitle.util.data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

/**
 * 
 * <p>
 * <b> {@link FileOperationUtil} </b>
 * </p>
 *
 * <p>
 * 
 * </p>
 * 
 * @author <a href="https://github.com/JoseRafael97">Rafael Feitosa</a>
 */
public class FileOperationUtil {

	/**
	 * 
	 * @param fileName
	 * @return
	 */
	public String reader(String fileName) {

		BufferedReader br;
		StringBuilder sb = null;
		try {
			File file = new File(fileName);
			FileReader fileReader = new FileReader(file);
			br = new BufferedReader(fileReader);
			sb = new StringBuilder();
			String line = br.readLine();

			while (line != null) {
				sb.append(line);
				sb.append(System.lineSeparator());
				line = br.readLine();
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
	
	/**
	 * 
	 * @param content
	 * @param fileName
	 */
	public void  writer(String content, String fileName){
		try {
			File file = new File(fileName);
			
			FileOutputStream outputStream = new FileOutputStream(file);
			outputStream.write(content.getBytes());
			outputStream.flush();
			outputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}