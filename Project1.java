import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileSystemView;

/*Filename: Project1.java
 *Author: Kwame Duodu 
 *Date: 5/31/2020
 *Purpose: A program that computes the minimum, the  maximum and the 
 * average weight of a collection of weights represented in pounds and ounces
that are read from an input file. 
 */
public class Project1 {
	
	public static void main(String[] args) throws Exception {
		Weight[] weightListArray = new Weight[24];
		JFileChooser fc = new JFileChooser(FileSystemView.getFileSystemView().getDefaultDirectory());
		int result = fc.showOpenDialog(fc);
		if (result == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fc.getSelectedFile();

		
			int totalLinesInFile = 0;
			try {
				Scanner file = new Scanner(selectedFile);
				while (file.hasNextLine()) {
					if (totalLinesInFile > 25) {
				}
					String[] strArr = file.nextLine().split(" ");
					weightListArray[totalLinesInFile++] = new Weight(Integer.parseInt(strArr[0]), Double.parseDouble(strArr[1]));
				}	
				
				
					//print out mini, max and average weight
				System.out.println("Minimum weight : "+findMinimum(weightListArray, totalLinesInFile));
				System.out.println("Maximum weight : "+findMaxmium(weightListArray, totalLinesInFile));
				System.out.println("Average weight : "+findAverage(weightListArray, totalLinesInFile));
					
				file.close(); //close scanner
						
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("file exceeds 25 lines");
			}
		}
	}	
	
private static Weight findMinimum(Weight[] weightArray, Integer weights) {
		Weight minimumWeight = weightArray[0];
		
		for (int i = 0; i < weights; i++) {
			if (minimumWeight.lessThan(weightArray[i]) == false) {
				minimumWeight = weightArray[i];
			}
		}
		return minimumWeight;
	}

	private static Weight findMaxmium(Weight[] weightArray, Integer weights) {
		Weight maximimWeight = weightArray[0];

		for (int i = 0; i < weights; i++) {
			if (maximimWeight.lessThan(weightArray[i])) {
				maximimWeight = weightArray[i];
			}
		}

		return maximimWeight;
	}


	private static Weight findAverage(Weight[] weightArray, Integer weights) {
		Weight totalWeight = weightArray[0];

		for (int i = 0; i < weights; i++) {
			totalWeight.addTo(weightArray[i]);
		}
		totalWeight.divide(weights);
		return totalWeight;
	}
}

