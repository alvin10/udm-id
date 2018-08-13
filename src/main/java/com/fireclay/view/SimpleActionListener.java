/**
 * 
 */
package com.fireclay.view;

/**
 * @author Franklin Chua
 *
 */
public interface SimpleActionListener<T> {

	void onEdit(T entity);
	
	void onDelete(T entity);
}
