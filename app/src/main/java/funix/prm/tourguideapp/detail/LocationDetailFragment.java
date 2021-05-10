package funix.prm.tourguideapp.detail;

import android.app.Application;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import funix.prm.tourguideapp.R;
import funix.prm.tourguideapp.detail.dummy.DummyContent;
import funix.prm.tourguideapp.main.LocationFragmentViewModel;
import funix.prm.tourguideapp.model.Location;

/**
 * A simple {@link Fragment} subclass.
 */
public class LocationDetailFragment extends Fragment {

    private static final String ARG_COLUMN_COUNT = "column-count";

    private String cityLocation = "HN";

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
            int mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }

        LocationFragmentViewModel viewModel = new ViewModelProvider(getActivity()).get(LocationFragmentViewModel.class);
        viewModel.getCity().observe(getActivity(), city -> {
            //Change address list according to city by passing city name as param
            cityLocation = city;
        });

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_location_detail, container, false);

        final ImageView locationImageView = view.findViewById(R.id.detail_location_image_view);
        final TextView locationNameTextView = view.findViewById(R.id.detail_location_name_text_view);
        DummyContent dc = new DummyContent(getActivity());
        // do the parsing in the DummyContent: dc.doParsing()

        Application application = requireActivity().getApplication();

        Location location = LocationDetailFragmentArgs.fromBundle(requireArguments()).getDetailFragmentArgs();
        DetailFragmentViewModelFactory factory = new  DetailFragmentViewModelFactory(application, location);
        DetailFragmentViewModel dViewModel = new ViewModelProvider(this, factory).get(DetailFragmentViewModel.class);

        dViewModel.getSelectedLocation().observe(getViewLifecycleOwner(), location1 -> {
            locationImageView.setImageResource(location1.getLocationImage());
            locationNameTextView.setText(location1.getLocationName());

            // Set the adapter
            RecyclerView recyclerView = view.findViewById(R.id.list);
            if(cityLocation.equals("HN")) {
                switch (location1.getLocationName()) {
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
                switch (location1.getLocationName()) {
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
        });

        return view;
    }
}
