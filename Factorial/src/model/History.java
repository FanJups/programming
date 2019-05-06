/**
 * 
 */
package model;

import java.util.Date;

/**
 * @author Admin
 *
 */
public class History {

	private Date date = new Date();
	private Integer value_of_n;
	private int resultfactorial;

	public History(Date date, Integer value_of_n, int resultfactorial) {

		this.date = date;
		this.value_of_n = value_of_n;
		this.resultfactorial = resultfactorial;

	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date
	 *            the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return the value_of_n
	 */
	public Integer getValue_of_n() {
		return value_of_n;
	}

	/**
	 * @param value_of_n
	 *            the value_of_n to set
	 */
	public void setValue_of_n(Integer value_of_n) {
		this.value_of_n = value_of_n;
	}

	/**
	 * @return the resultfactorial
	 */
	public int getResultfactorial() {
		return resultfactorial;
	}

	/**
	 * @param resultfactorial
	 *            the resultfactorial to set
	 */
	public void setResultfactorial(int resultfactorial) {
		this.resultfactorial = resultfactorial;
	}

}
