package funix.prm.tourguideapp.main;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import funix.prm.tourguideapp.R;
import funix.prm.tourguideapp.model.Location;

/**
 * A simple {@link Fragment} subclass.
 */
public class LocationFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private LocationAdapter mLocationAdapter;

    public LocationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        /*
         * Using Navigation object we find navigation controller with view then we will call
         * navigate with it's action name and pass argument to open correct item. You can change
         * this action name "actionLocationFragmentToLocationDetailFragment" of your choice in
         * navigation.xml file and make both match properly.
         */
        View view = inflater.inflate(R.layout.fragment_location, container, false);
        mRecyclerView = view.findViewById(R.id.location_recycler_view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        LocationFragmentViewModel viewModel = ViewModelProviders.of(this).get(LocationFragmentViewModel.class);
        viewModel.getLocationData().observe(this, locationList -> {
            mLocationAdapter = new LocationAdapter(getContext(), locationList, new LocationListener());
            mRecyclerView.setAdapter(mLocationAdapter);
        });
    }

    private class LocationListener implements LocationAdapter.LocationAdapterListener {

        @Override
        public void onLocationSelected(Location location, View view) {
            /*
             * Using Navigation object we find navigation controller with view then we will call
             * navigate with it's action name and pass argument to open correct item. You can change
             * this action name
             */
            Navigation.findNavController(view).navigate(LocationFragmentDirections.actionLocationFragmentToLocationDetailFragment(location));
        }
    }
}

