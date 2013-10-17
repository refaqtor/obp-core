package org.marssa.utils;

/**
 * Created by Robert Jaremczak
 * Date: 2013-10-6
 *
 * Native system format is signed degree angle with fraction
 * W = negative angle
 * E = positive angle
 */

public final class LongitudeUtil {
    private LongitudeUtil() {
    }

    public static final double fromDDMM(double ddmm, String direction) {
        switch(direction) {
            case AzimuthUtil.WEST_DIRECTION: return AngleUtils.fromDDMM(-ddmm);
            case AzimuthUtil.EAST_DIRECTION: return AngleUtils.fromDDMM(ddmm);
            default: throw new IllegalArgumentException("invalid direction code " + direction);
        }
    }
}
