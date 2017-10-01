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

import com.androidmapsextensions.GoogleMap.OnGroundOverlayClickListener;
import com.androidmapsextensions.GroundOverlay;
import com.androidmapsextensions.GroundOverlayOptions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class GroundOverlayManager {

    private final IGoogleMap factory;

    private final Map<com.google.android.gms.maps.model.GroundOverlay, GroundOverlay> groundOverlays;

    public GroundOverlayManager(IGoogleMap factory) {
        this.factory = factory;
        this.groundOverlays = new HashMap<>();
    }

    public GroundOverlay addGroundOverlay(GroundOverlayOptions groundOverlayOptions) {
        GroundOverlay groundOverlay = createGroundOverlay(groundOverlayOptions.real);
        groundOverlay.setData(groundOverlayOptions.getData());
        return groundOverlay;
    }

    private GroundOverlay createGroundOverlay(com.google.android.gms.maps.model.GroundOverlayOptions groundOverlayOptions) {
        com.google.android.gms.maps.model.GroundOverlay real = factory.addGroundOverlay(groundOverlayOptions);
        GroundOverlay groundOverlay = new DelegatingGroundOverlay(real, this);
        groundOverlays.put(real, groundOverlay);
        return groundOverlay;
    }

    public void clear() {
        groundOverlays.clear();
    }

    public List<GroundOverlay> getGroundOverlays() {
        return new ArrayList<GroundOverlay>(groundOverlays.values());
    }

    public void onRemove(com.google.android.gms.maps.model.GroundOverlay real) {
        groundOverlays.remove(real);
    }

    public void setOnGroundOverlayClickListener(OnGroundOverlayClickListener onGroundOverlayClickListener) {
        com.google.android.gms.maps.GoogleMap.OnGroundOverlayClickListener realOnGroundOverlayClickListener = null;
        if (onGroundOverlayClickListener != null) {
            realOnGroundOverlayClickListener = new DelegatingOnGroundOverlayClickListener(onGroundOverlayClickListener);
        }
        factory.setOnGroundOverlayClickListener(realOnGroundOverlayClickListener);
    }

    private class DelegatingOnGroundOverlayClickListener implements com.google.android.gms.maps.GoogleMap.OnGroundOverlayClickListener {

        private final OnGroundOverlayClickListener onGroundOverlayClickListener;

        public DelegatingOnGroundOverlayClickListener(OnGroundOverlayClickListener onGroundOverlayClickListener) {
            this.onGroundOverlayClickListener = onGroundOverlayClickListener;
        }

        @Override
        public void onGroundOverlayClick(com.google.android.gms.maps.model.GroundOverlay groundOverlay) {
            onGroundOverlayClickListener.onGroundOverlayClick(groundOverlays.get(groundOverlay));
        }
    }
}
