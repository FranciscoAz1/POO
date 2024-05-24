package pa;

import java.util.Scanner;

public interface ICost {

	public void Cost(int aN, int aM);

	public void Cost(Scanner aScanner, int aN, int aM);

	public void fillRandom();

	public void setValue(int aRow, int aCol, int aValue);

	public int getValue(int aRow, int aCol);

	public void printMatrix();
}