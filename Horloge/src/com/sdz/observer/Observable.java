/**
 * 
 */
package com.sdz.observer;

/**
 * @author Admin
 *
 */
public interface Observable {

	public void addObservateur(Observateur obs);

	public void updateObservateur();

	public void delObservateur();

}
