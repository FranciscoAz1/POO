package pa;

/**
 * The ICost interface provides a contract for cost objects in a simulation.
 * It defines methods for calculating, setting, and getting cost values.
 */

public interface ICost {

  public void setValue(int aRow, int aCol, int aValue);

  public int getValue(int aRow, int aCol);

  public int[][] getMatrix();

  public void printMatrix();

  public void setMatrix(int[][] matrix2);
}
