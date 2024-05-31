
package main;

/**
 * The Args interface represents the command line arguments passed to the
 * program.
 * 
 * @author Henrique João 
 * @author Tiago Nascimento
 * @author Ricardo Nobre
 * @author Francisco Azeredo
 * @see Args
 */
public interface IArgs {

  void readFromArgs(String[] args);

  void readFromFile(String[] args);

  boolean fileMode();

  boolean readMode();
}
