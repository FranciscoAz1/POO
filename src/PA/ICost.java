package pa;

import java.util.Scanner;

/**
 * The ICost interface provides a contract for cost objects in a simulation.
 * It defines methods for calculating, setting, and getting cost values.
 */

public interface ICost {

	public void Cost(int aN, int aM);

	public void Cost(Scanner aScanner, int aN, int aM);

	public void fillRandom();

	public void setValue(int aRow, int aCol, int aValue);

	public int getValue(int aRow, int aCol);

	public void printMatrix();
}