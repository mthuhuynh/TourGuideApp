package funix.prm.tourguideapp.detail;

import android.app.Application;
import android.os.Bundle;
import android.content.Context;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import funix.prm.tourguideapp.R;
import funix.prm.tourguideapp.detail.dummy.DummyContent;
import funix.prm.tourguideapp.main.LocationFragmentViewModel;
import funix.prm.tourguideapp.model.Location;

import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 */
public class LocationDetailFragment extends Fragment {
    //list
    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private String cityLocation = "HCM";

    public LocationDetailFragment() {
        // Required empty public constructor
    }

    public static LocationDetailFragment newInstance(int columnCount) {
        LocationDetailFragment fragment = new LocationDetailFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_location_detail, container, false);

        final ImageView locationImageView = view.findViewById(R.id.detail_location_image_view);
        final TextView locationNameTextView = view.findViewById(R.id.detail_location_name_text_view);
        DummyContent dc = new DummyContent(getActivity());
        // do the parsing in the DummyContent: dc.doParsing()

        Application application = requireActivity().getApplication();

        LocationFragmentViewModel viewModel = ViewModelProviders.of(this).get(LocationFragmentViewModel.class);
        viewModel.getCity().observe(requireActivity(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String city) {
                Toast.makeText(this,"city adapter input" + city, Toast.LENGTH_LONG).show();
                cityLocation = city;
            }
        });

        Location location = LocationDetailFragmentArgs.fromBundle(requireArguments()).getDetailFragmentArgs();
        DetailFragmentViewModelFactory factory = new  DetailFragmentViewModelFactory(application, location);
        DetailFragmentViewModel dViewModel = ViewModelProviders.of(this, factory).get(DetailFragmentViewModel.class);

        dViewModel.getSelectedLocation().observe(getViewLifecycleOwner(), new Observer<Location>() {
            @Override
            public void onChanged(Location location) {
                locationImageView.setImageResource(location.getLocationImage());
                locationNameTextView.setText(location.getLocationName());


                //list
                // Set the adapter
                RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.list);
                if(cityLocation.equals("HN")) {
                    switch (location.getLocationName()) {
                        case "ATM":
                            recyclerView.setAdapter(new AddressRecyclerViewAdapter(DummyContent.ATM));
                            break;
                        case "Bus":
                            recyclerView.setAdapter(new AddressRecyclerViewAdapter(DummyContent.BUSES));
                            break;
                        case "Hotel":
                            recyclerView.setAdapter(new AddressRecyclerViewAdapter(DummyContent.HOTELS));
                            break;
                        case "Hospital":
                            recyclerView.setAdapter(new AddressRecyclerViewAdapter(DummyContent.HOSPITALS));
                            break;
                    }
                } else if(cityLocation.equals("HCM")){
                    switch (location.getLocationName()) {
                        case "ATM":
                            recyclerView.setAdapter(new AddressRecyclerViewAdapter(DummyContent.ATM_HCM));
                            break;
                        case "Bus":
                            recyclerView.setAdapter(new AddressRecyclerViewAdapter(DummyContent.BUSES_HCM));
                            break;
                        case "Hotel":
                            recyclerView.setAdapter(new AddressRecyclerViewAdapter(DummyContent.HOTELS_HCM));
                            break;
                        case "Hospital":
                            recyclerView.setAdapter(new AddressRecyclerViewAdapter(DummyContent.HOSPITALS_HCM));
                            break;
                    }
                }
            }
        });


        return view;
    }

}
