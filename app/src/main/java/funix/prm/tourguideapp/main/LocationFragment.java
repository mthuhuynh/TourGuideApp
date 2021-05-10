package funix.prm.tourguideapp.main;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

import funix.prm.tourguideapp.R;
import funix.prm.tourguideapp.model.Location;

/**
 * A simple {@link Fragment} subclass.
 */
public class LocationFragment extends Fragment implements AdapterView.OnItemSelectedListener {

    private RecyclerView mRecyclerView;
    private LocationAdapter mLocationAdapter;
    private LocationFragmentViewModel viewModel;
    String[] city = {"HN", "HCM"};


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

        //Getting the instance of Spinner and applying OnItemSelectedListener on it
        Spinner spin = (Spinner) view.findViewById(R.id.location_fragment_spinner);
        spin.setOnItemSelectedListener(this);

        //Creating the ArrayAdapter instance having the country list
        ArrayAdapter aa = new ArrayAdapter(getContext(), android.R.layout.simple_spinner_item, city);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spin.setAdapter(aa);

        viewModel = new ViewModelProvider(getActivity()).get(LocationFragmentViewModel.class);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        viewModel = ViewModelProviders.of(this).get(LocationFragmentViewModel.class);

        viewModel.getLocationData().observe(getViewLifecycleOwner(), locationList -> {
            mLocationAdapter = new LocationAdapter(getContext(), locationList, new LocationListener());
            mRecyclerView.setAdapter(mLocationAdapter);
        });
    }

    //Performing action onItemSelected and onNothing selected
    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
//        Toast.makeText(getContext(), city[position], Toast.LENGTH_LONG).show();
//        viewModel = ViewModelProviders.of(this).get(LocationFragmentViewModel.class);
        viewModel.setCity(city[position]);

    }
    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        viewModel.setCity("HN");
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

