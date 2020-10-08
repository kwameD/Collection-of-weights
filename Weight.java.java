/** File name: Weight.java
*   Author:    Rabelais Batchaji Kouatchoua
*   Date:      March 29, 2020
*   Purpose:   The first programming project involves writing a program 
*              that computes the minimum, the maximum and the average weight
*              of a collection of weights represented in pounds and ounces that are read from an input file.
*/

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;
import java.io.FileNotFoundException;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

public class Weight {

// variables' declaration	
	int pounds;
	double ounces;
	
// constructor
	public Weight(int pounds,double ounces) {
		this.pounds = pounds;
		this.ounces = ounces;
		this.normalise();
		}
	
// public instance method named lessThan
	
	public boolean lessThan(Weight other) {
		other.normalise();
		if (this.pounds > other.pounds) {
			return false;
			}
		if ((this.pounds == other.pounds) && (this.ounces > other.ounces)){
			return false;
			}
		return true;
		}
	
// public instance method named addTo
	public void addTo(Weight other) {
		this.pounds += other.pounds;
		this.ounces += other.ounces;
		this.normalise();
		}
	
// public instance method named divide
	public void divide(int divisor) {
		this.pounds = this.pounds/divisor;
		this.ounces = this.ounces/divisor;
		this.normalise();
		}
	
//public instance toString method
	public String toString() {
		return String.format("%d lbs %0.4f oz", pounds,ounces);
		}
	
	public double toOunces() {
		return pounds*16 + ounces;
		}
	
// private instance method normalize
	private void normalise() {
			while (ounces >=16) {
			pounds += 1;
			ounces = ounces -16;
			}	
	}
}