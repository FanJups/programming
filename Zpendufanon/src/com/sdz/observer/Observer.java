/**
 * 
 */
package com.sdz.observer;

import com.sdz.model.Score;

/**
 * @author Admin
 *
 */
public interface Observer {
	public void update (String mot,int pts,String imgPath, int nbreMot);
	public void restart(String word);
	public void showScore(Score[]list);
	public void accueil();

}
