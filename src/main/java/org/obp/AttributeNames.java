/*
 * Copyright 2013-2014 MARSEC-XL International Limited
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.obp;

/**
 * Created by Robert Jaremczak
 * Date: 2013-10-24
 */
public final class AttributeNames {

    private AttributeNames() {
    }

    public static final String
    TIME = "time",
    GPS_FIX_MODE = "gpsFixMode",
    GPS_FIX_TYPE = "gpsFixType",
    GPS_FIX_QUALITY = "gpsFixQuality",
    GPS_EFFECTIVE_SATELLITES = "gpsEffectiveSatellites",
    GPS_VISIBLE_SATELLITES = "gpsVisibleSatellites",
    GPS_SATELLITES = "gpsSatellites",
    GPS_SATELLITE_ID = "id",
    GPS_SATELLITE_ELEVATION = "elevation",
    GPS_SATELLITE_AZIMUTH = "azimuth",
    GPS_SATELLITE_SNR = "snr",
    GPS_MAGNETIC_VARIATION = "gpsMagneticVariation",
    LATITUDE = "latitude",
    LONGITUDE = "longitude",
    TRUE_NORTH_COURSE = "trueNorthCourse",
    SPEED_OVER_GROUND = "speedOverGround",
    ALTITUDE = "altitude",
    AIR_TEMPERATURE = "airTemperature",
    AIR_PRESSURE = "airPressure",
    WIND_ANGLE = "windAngle",
    WIND_SPEED = "windSpeed",
    WIND_TEMPERATURE = "windTemperature",
    RELATIVE_HUMIDITY = "relativeHumidity",
    UPDATE_TIME = "lastUpdate",
    HDOP = "hdop",
    VDOP = "vdop",
    PDOP = "pdop",
    DATA_STALE = "dataStale";
}
