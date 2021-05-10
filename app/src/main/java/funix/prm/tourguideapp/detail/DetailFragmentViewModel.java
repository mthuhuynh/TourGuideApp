package funix.prm.tourguideapp.detail;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import funix.prm.tourguideapp.model.Location;

class DetailFragmentViewModel extends AndroidViewModel {

    private final MutableLiveData<Location> selectedLocation = new MutableLiveData<>();

    DetailFragmentViewModel(@NonNull Application application, Location location) {
        super(application);
        selectedLocation.postValue(location);
    }

    MutableLiveData<Location> getSelectedLocation() {
        return selectedLocation;
    }
}

