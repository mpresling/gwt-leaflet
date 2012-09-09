/********************************************************************
 * 
 * Layers.java is part of SAR-Man.
 * 
 * Copyright (c) 2012, DISCO Foundation. All rights reserved.
 * 
 * SAR-Man is free software: you can redistribute it and/or modify it under the
 * terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 * 
 * SAR-Man is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
 * A PARTICULAR PURPOSE.
 * 
 * See the GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * SAR-Man. If not, see http://www.gnu.org/licenses.
 * 
 *********************************************************************/
package org.gwt.leaflet.api.controls;

import org.gwt.leaflet.api.Options;
import org.gwt.leaflet.api.layers.ILayer;
import org.gwt.leaflet.api.map.Map;

/**
 * <b>Layer switcher control interface</b>
 * <p>
 * This interface gives users the ability to switch between different base layers 
 * and switch overlays on/off. It should be created and added explicitly to 
 * the map using {@link Map#addControl} or {@link Control#addTo(Map)}.
 * <p>
 * <b>Options</b>
 * <nl>
 * <li>{@link #POSITION}</li>
 * <li>{@link #COLLAPSED}</li>
 * <li>{@link #AUTO_ZINDEZ}</li>
 * </nl>
 * </p>
 * 
 * @author kennethg
 *
 * @see <a href="http://leaflet.cloudmade.com/reference.html#control-layers">L.Control.Layers (Leaflet API)</a>
 */
public interface Layers extends Control {
	
	/**
	 * The initial position of the control (one of the map corners).
	 * <p>
	 * Default: {@link Position#TOP_RIGHT}.
	 */
	public static final String POSITION = "position";
	
	/**
	 * If <code>true</code>, the control will be collapsed into an icon and expanded 
	 * on mouse hover or touch.
	 * <p>
	 * DEFAULT: <code>true</code>
	 */
	final static String COLLAPSED = "collapsed";

	/**
	 * If true, the control will assign zIndexes in increasing order to 
	 * all of its layers so that the order is preserved when switching them on/off.
	 * <p>
	 * DEFAULT: <code>true</code>
	 */
	final static String AUTO_ZINDEZ = "autoZIndex";
	
	/**
	 * Default {@link Options}.
	 */
	@SuppressWarnings("serial")
	public final static Options DEFAULT = new Options(true){
		@Override protected void fill() {
			put(POSITION, Position.TOP_RIGHT.getLiteral());
			put(COLLAPSED, true);
			put(AUTO_ZINDEZ, true);
		}
	};
	
	/**
	 * Set <em>collapsed</em> option.
	 * @param isCollapsed 
	 * @return {@link Layers}
	 */
	Layers setCollapsed(boolean isCollapsed);
	
	/**
	 * Modify options in one operation.
	 * @param options {@link Options} instance.
	 * @return {@link Layers}
	 */
	Layers setOptions(Options options);
	
	/**
	 * Adds a base layer (radio button entry) with the given name to the control.
	 * @param layer {@link ILayer} instance
	 * @param name {@link ILayer} name
	 * @return {@link Layers}
	 */
	Layers addBaseLayer(ILayer layer, String name);
	
	/**
	 * Adds an overlay (checkbox entry) with the given name to the control.
	 * @param layer {@link ILayer} instance
	 * @param name {@link ILayer} name
	 * @return {@link Layers}
	 */
	Layers addOverlay(ILayer layer, String name);
	
	/**
	 * Remove the given layer from the control.
	 * @param layer {@link ILayer} instance
	 * @return {@link Layers}
	 */
	Layers removeLayer(String layer);

}