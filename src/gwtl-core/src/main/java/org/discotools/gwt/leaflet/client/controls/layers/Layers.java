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
package org.discotools.gwt.leaflet.client.controls.layers;

import org.discotools.gwt.leaflet.client.Options;
import org.discotools.gwt.leaflet.client.controls.Control;
import org.discotools.gwt.leaflet.client.layers.ILayer;
import org.discotools.gwt.leaflet.client.map.Map;

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
 * @author Lionel Leiva-Marcon
 *
 * @see <a href="http://leaflet.cloudmade.com/reference.html#control-layers">L.Control.Layers (Leaflet API)</a>
 */
public class Layers extends Control {
	
	public Layers(ILayer bases, ILayer overlays, Options options) {
		super(LayersImpl.create(bases.getJSObject(), overlays.getJSObject(), options.getJSObject()));
	}

	public Layers(Options bases, Options overlays, Options options) {
		super(LayersImpl.create(bases.getJSObject(), overlays.getJSObject(), options.getJSObject()));
	}

	/**
	 * Adds a base layer (radio button entry) with the given name to the control.
	 * @param layer {@link ILayer} instance
	 * @param name {@link ILayer} name
	 * @return {@link Layers}
	 */
	public Layers addBaseLayer(ILayer layer, String name) {
		LayersImpl.addBaseLayer(getJSObject(), layer.getJSObject(), name);
		return this;
	}
	
	/**
	 * Adds an overlay (checkbox entry) with the given name to the control.
	 * @param layer {@link ILayer} instance
	 * @param name {@link ILayer} name
	 * @return {@link Layers}
	 */
	public Layers addOverlay(ILayer layer, String name) {
		LayersImpl.addOverlay(getJSObject(), layer.getJSObject(), name);
		return this;
	}
	
	/**
	 * Remove the given layer from the control.
	 * @param layer {@link ILayer} instance
	 * @return {@link Layers}
	 */
	public Layers removeLayer(String name) {
		LayersImpl.removeLayer(getJSObject(), name);
		return this;
	}
	
	@Override
	public Layers setPosition(String position) {
		return (Layers)super.setPosition(position);
	}

	@Override
	public Layers addTo(Map map) {
		return (Layers)super.addTo(map);
	}

	@Override
	public Layers removeFrom(Map map) {
		return (Layers)super.removeFrom(map);
	}	

}
