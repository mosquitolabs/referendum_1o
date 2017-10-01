/*
 * Copyright (C) 2013 Maciej Górski
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.androidmapsextensions.impl;

import android.graphics.Bitmap;
import android.location.Location;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.CancelableCallback;
import com.google.android.gms.maps.GoogleMap.InfoWindowAdapter;
import com.google.android.gms.maps.GoogleMap.OnCameraChangeListener;
import com.google.android.gms.maps.GoogleMap.OnCameraIdleListener;
import com.google.android.gms.maps.GoogleMap.OnCameraMoveCanceledListener;
import com.google.android.gms.maps.GoogleMap.OnCameraMoveListener;
import com.google.android.gms.maps.GoogleMap.OnCameraMoveStartedListener;
import com.google.android.gms.maps.GoogleMap.OnCircleClickListener;
import com.google.android.gms.maps.GoogleMap.OnGroundOverlayClickListener;
import com.google.android.gms.maps.GoogleMap.OnInfoWindowClickListener;
import com.google.android.gms.maps.GoogleMap.OnInfoWindowCloseListener;
import com.google.android.gms.maps.GoogleMap.OnInfoWindowLongClickListener;
import com.google.android.gms.maps.GoogleMap.OnMapClickListener;
import com.google.android.gms.maps.GoogleMap.OnMapLoadedCallback;
import com.google.android.gms.maps.GoogleMap.OnMapLongClickListener;
import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener;
import com.google.android.gms.maps.GoogleMap.OnMarkerDragListener;
import com.google.android.gms.maps.GoogleMap.OnMyLocationButtonClickListener;
import com.google.android.gms.maps.GoogleMap.OnMyLocationChangeListener;
import com.google.android.gms.maps.GoogleMap.OnPoiClickListener;
import com.google.android.gms.maps.GoogleMap.OnPolygonClickListener;
import com.google.android.gms.maps.GoogleMap.OnPolylineClickListener;
import com.google.android.gms.maps.GoogleMap.SnapshotReadyCallback;
import com.google.android.gms.maps.LocationSource;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.GroundOverlay;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.maps.model.TileOverlay;
import com.google.android.gms.maps.model.TileOverlayOptions;

// TODO: to be deleted when com.google.android.gms.maps.GoogleMap becomes an interface
class GoogleMapWrapper implements IGoogleMap {

    private GoogleMap map;

    public GoogleMapWrapper(GoogleMap map) {
        this.map = map;
    }

    @Override
    public final Circle addCircle(CircleOptions options) {
        return map.addCircle(options);
    }

    @Override
    public final GroundOverlay addGroundOverlay(GroundOverlayOptions options) {
        return map.addGroundOverlay(options);
    }

    @Override
    public final Marker addMarker(MarkerOptions options) {
        return map.addMarker(options);
    }

    @Override
    public final Polygon addPolygon(PolygonOptions options) {
        return map.addPolygon(options);
    }

    @Override
    public final Polyline addPolyline(PolylineOptions options) {
        return map.addPolyline(options);
    }

    @Override
    public final TileOverlay addTileOverlay(TileOverlayOptions options) {
        return map.addTileOverlay(options);
    }

    @Override
    public final void animateCamera(CameraUpdate update, CancelableCallback callback) {
        map.animateCamera(update, callback);
    }

    @Override
    public final void animateCamera(CameraUpdate update, int durationMs, CancelableCallback callback) {
        map.animateCamera(update, durationMs, callback);
    }

    @Override
    public final void animateCamera(CameraUpdate update) {
        map.animateCamera(update);
    }

    @Override
    public final void clear() {
        map.clear();
    }

    @Override
    public final CameraPosition getCameraPosition() {
        return map.getCameraPosition();
    }

    @Override
    public final int getMapType() {
        return map.getMapType();
    }

    @Override
    public final float getMaxZoomLevel() {
        return map.getMaxZoomLevel();
    }

    @Override
    public final float getMinZoomLevel() {
        return map.getMinZoomLevel();
    }

    @Override
    public final Location getMyLocation() {
        return map.getMyLocation();
    }

    @Override
    public final ProjectionWrapper getProjection() {
        return new ProjectionWrapper(map.getProjection());
    }

    @Override
    public final UiSettings getUiSettings() {
        return map.getUiSettings();
    }

    @Override
    public final boolean isBuildingsEnabled() {
        return map.isBuildingsEnabled();
    }

    @Override
    public final boolean isIndoorEnabled() {
        return map.isIndoorEnabled();
    }

    @Override
    public final boolean isMyLocationEnabled() {
        return map.isMyLocationEnabled();
    }

    @Override
    public final boolean isTrafficEnabled() {
        return map.isTrafficEnabled();
    }

    @Override
    public void resetMinMaxZoomPreference() {
        map.resetMinMaxZoomPreference();
    }

    @Override
    public final void moveCamera(CameraUpdate update) {
        map.moveCamera(update);
    }

    @Override
    public final void setBuildingsEnabled(boolean enabled) {
        map.setBuildingsEnabled(enabled);
    }

    @Override
    public final boolean setIndoorEnabled(boolean enabled) {
        return map.setIndoorEnabled(enabled);
    }

    @Override
    public final void setInfoWindowAdapter(InfoWindowAdapter adapter) {
        map.setInfoWindowAdapter(adapter);
    }

    @Override
    public void setLatLngBoundsForCameraTarget(LatLngBounds bounds) {
        map.setLatLngBoundsForCameraTarget(bounds);
    }

    @Override
    public final void setLocationSource(LocationSource source) {
        map.setLocationSource(source);
    }

    @Override
    public boolean setMapStyle(MapStyleOptions mapStyleOptions) {
        return map.setMapStyle(mapStyleOptions);
    }

    @Override
    public final void setMapType(int type) {
        map.setMapType(type);
    }

    @Override
    public void setMaxZoomPreference(float zoom) {
        map.setMaxZoomPreference(zoom);
    }

    @Override
    public void setMinZoomPreference(float zoom) {
        map.setMinZoomPreference(zoom);
    }

    @Override
    public final void setMyLocationEnabled(boolean enabled) {
        map.setMyLocationEnabled(enabled);
    }

    @Override
    public final void setOnCameraChangeListener(OnCameraChangeListener listener) {
        map.setOnCameraChangeListener(listener);
    }

    @Override
    public void setOnCameraIdleListener(OnCameraIdleListener listener) {
        map.setOnCameraIdleListener(listener);
    }

    @Override
    public void setOnCameraMoveCanceledListener(OnCameraMoveCanceledListener listener) {
        map.setOnCameraMoveCanceledListener(listener);
    }

    @Override
    public void setOnCameraMoveListener(OnCameraMoveListener listener) {
        map.setOnCameraMoveListener(listener);
    }

    @Override
    public void setOnCameraMoveStartedListener(OnCameraMoveStartedListener listener) {
        map.setOnCameraMoveStartedListener(listener);
    }

    @Override
    public void setOnCircleClickListener(OnCircleClickListener listener) {
        map.setOnCircleClickListener(listener);
    }

    @Override
    public void setOnGroundOverlayClickListener(OnGroundOverlayClickListener listener) {
        map.setOnGroundOverlayClickListener(listener);
    }

    @Override
    public final void setOnInfoWindowClickListener(OnInfoWindowClickListener listener) {
        map.setOnInfoWindowClickListener(listener);
    }

    @Override
    public void setOnInfoWindowCloseListener(OnInfoWindowCloseListener listener) {
        map.setOnInfoWindowCloseListener(listener);
    }

    @Override
    public void setOnInfoWindowLongClickListener(OnInfoWindowLongClickListener listener) {
        map.setOnInfoWindowLongClickListener(listener);
    }

    @Override
    public final void setOnMapClickListener(OnMapClickListener listener) {
        map.setOnMapClickListener(listener);
    }

    @Override
    public void setOnMapLoadedCallback(OnMapLoadedCallback callback) {
        map.setOnMapLoadedCallback(callback);
    }

    @Override
    public final void setOnMapLongClickListener(OnMapLongClickListener listener) {
        map.setOnMapLongClickListener(listener);
    }

    @Override
    public final void setOnMarkerClickListener(OnMarkerClickListener listener) {
        map.setOnMarkerClickListener(listener);
    }

    @Override
    public final void setOnMarkerDragListener(OnMarkerDragListener listener) {
        map.setOnMarkerDragListener(listener);
    }

    @Override
    public void setOnMyLocationButtonClickListener(OnMyLocationButtonClickListener listener) {
        map.setOnMyLocationButtonClickListener(listener);
    }

    @Override
    public final void setOnMyLocationChangeListener(OnMyLocationChangeListener listener) {
        map.setOnMyLocationChangeListener(listener);
    }

    @Override
    public void setOnPoiClickListener(OnPoiClickListener listener) {
        map.setOnPoiClickListener(listener);
    }

    @Override
    public void setOnPolygonClickListener(OnPolygonClickListener listener) {
        map.setOnPolygonClickListener(listener);
    }

    @Override
    public void setOnPolylineClickListener(OnPolylineClickListener listener) {
        map.setOnPolylineClickListener(listener);
    }

    @Override
    public void setPadding(int left, int top, int right, int bottom) {
        map.setPadding(left, top, right, bottom);
    }

    @Override
    public final void setTrafficEnabled(boolean enabled) {
        map.setTrafficEnabled(enabled);
    }

    @Override
    public void snapshot(SnapshotReadyCallback callback) {
        map.snapshot(callback);
    }

    @Override
    public void snapshot(SnapshotReadyCallback callback, Bitmap bitmap) {
        map.snapshot(callback, bitmap);
    }

    @Override
    public final void stopAnimation() {
        map.stopAnimation();
    }

    @Override
    public GoogleMap getMap() {
        return map;
    }
}
