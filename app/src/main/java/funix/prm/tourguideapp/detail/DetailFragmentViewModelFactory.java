package funix.prm.tourguideapp.detail;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import funix.prm.tourguideapp.model.Location;

public class DetailFragmentViewModelFactory implements ViewModelProvider.Factory {

    private Application mApplication;
    private Location mLocation;

    DetailFragmentViewModelFactory(Application application, Location location) {
        this.mApplication = application;
        this.mLocation = location;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(DetailFragmentViewModel.class)) {
            return (T) new DetailFragmentViewModel(mApplication, mLocation);
        }
        throw new IllegalArgumentException("Cannot create Instance for this class");
    }
}

