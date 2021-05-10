package funix.prm.tourguideapp.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Location implements Parcelable {

    // Integer variable for Location images in list
    private final int mLocationImage;
    // String variable to show name of each Location in list
    private final String mLocationName;

    // public constructor
    public Location(int locationImage, String locationName) {
        this.mLocationImage = locationImage;
        this.mLocationName = locationName;
    }

    /**
     * returns an Location image of type Integer
     */
    public int getLocationImage() {
        return mLocationImage;
    }

    /**
     * returns an Location name of type String
     */
    public String getLocationName() {
        return mLocationName;
    }

    // Methods which makes our class parcelable
    public static final Creator<Location> CREATOR = new Creator<Location>() {
        @Override
        public Location createFromParcel(Parcel in) {
            return new Location(in);
        }

        @Override
        public Location[] newArray(int size) {
            return new Location[size];
        }
    };

    private Location(Parcel in) {
        mLocationImage = in.readInt();
        mLocationName = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(mLocationImage);
        parcel.writeString(mLocationName);
    }
}
