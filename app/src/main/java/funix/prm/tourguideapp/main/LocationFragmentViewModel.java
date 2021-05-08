package funix.prm.tourguideapp.main;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import funix.prm.tourguideapp.model.Location;
import funix.prm.tourguideapp.R;

public class LocationFragmentViewModel extends AndroidViewModel {

    private MutableLiveData<List<Location>> mLocationData;

    public LocationFragmentViewModel(@NonNull Application application) {
        super(application);
    }

    // Get Location list of data return type MutableLiveData
    MutableLiveData<List<Location>> getLocationData() {
        mLocationData = new MutableLiveData<List<Location>>();
        loadAllLocations();
        return mLocationData;
    }

    /*
     * Hardcoded Location data which shows in our list.
     *
     * We can use AsyncTask to load this data in background but since this is not heavy process
     * loading from database or internet.
     */
    private void loadAllLocations() {
        List<Location> locationList = new ArrayList<>();
        locationList.add(new Location(R.drawable.ic_baseline_directions_bus_24, getApplication().getString(R.string.bus)));
        locationList.add(new Location(R.drawable.ic_baseline_hotel_24, getApplication().getString(R.string.hotel)));
        locationList.add(new Location(R.drawable.ic_baseline_local_atm_24, getApplication().getString(R.string.atm)));
        locationList.add(new Location(R.drawable.ic_baseline_local_hospital_24, getApplication().getString(R.string.hospital)));
        mLocationData.postValue(locationList);
    }
}

