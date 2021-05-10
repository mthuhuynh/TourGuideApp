package funix.prm.tourguideapp.detail.dummy;

import android.content.Context;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import funix.prm.tourguideapp.R;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 */
public class DummyContent {
    /**
     * An array of sample (dummy) items.
     */
    public static final List<DummyItem> ATM = new ArrayList<>();
    public static final List<DummyItem> HOTELS = new ArrayList<>();
    public static final List<DummyItem> HOSPITALS = new ArrayList<>();
    public static final List<DummyItem> BUSES = new ArrayList<>();

    public static final List<DummyItem> ATM_HCM = new ArrayList<>();
    public static final List<DummyItem> HOTELS_HCM = new ArrayList<>();
    public static final List<DummyItem> HOSPITALS_HCM = new ArrayList<>();
    public static final List<DummyItem> BUSES_HCM = new ArrayList<>();

    /**
     * A map of sample (dummy) items.
     */
    public static final Map<String, DummyItem> ITEM_MAP = new HashMap<String, DummyItem>();
    private Context mContext;

    public DummyContent(Context context) {
        mContext = context;
        addStaticItem();
    }
    public void addStaticItem(){

        // Add some sample items.
        ATM.add(new DummyItem(String.valueOf(1),mContext.getString(R.string.atm_1_name), mContext.getString(R.string.atm_1_detail)));
        ATM.add(new DummyItem(String.valueOf(1),mContext.getString(R.string.atm_2_name), mContext.getString(R.string.atm_2_detail)));
        ATM.add(new DummyItem(String.valueOf(1),mContext.getString(R.string.atm_3_name), mContext.getString(R.string.atm_3_detail)));
        ATM.add(new DummyItem(String.valueOf(1),mContext.getString(R.string.atm_4_name), mContext.getString(R.string.atm_4_detail)));
        ATM.add(new DummyItem(String.valueOf(1),mContext.getString(R.string.atm_5_name), mContext.getString(R.string.atm_5_detail)));
        ATM.add(new DummyItem(String.valueOf(1),mContext.getString(R.string.atm_6_name), mContext.getString(R.string.atm_6_detail)));
        ATM.add(new DummyItem(String.valueOf(1),mContext.getString(R.string.atm_7_name), mContext.getString(R.string.atm_7_detail)));
        ATM.add(new DummyItem(String.valueOf(1),mContext.getString(R.string.atm_8_name), mContext.getString(R.string.atm_8_detail)));
        ATM.add(new DummyItem(String.valueOf(1),mContext.getString(R.string.atm_9_name), mContext.getString(R.string.atm_9_detail)));

        HOSPITALS.add(new DummyItem(String.valueOf(1),mContext.getString(R.string.hospital_1_name), mContext.getString(R.string.hospital_1_detail)));
        HOSPITALS.add(new DummyItem(String.valueOf(1),mContext.getString(R.string.hospital_2_name), mContext.getString(R.string.hospital_2_detail)));
        HOSPITALS.add(new DummyItem(String.valueOf(1),mContext.getString(R.string.hospital_3_name), mContext.getString(R.string.hospital_3_detail)));
        HOSPITALS.add(new DummyItem(String.valueOf(1),mContext.getString(R.string.hospital_4_name), mContext.getString(R.string.hospital_4_detail)));
        HOSPITALS.add(new DummyItem(String.valueOf(1),mContext.getString(R.string.hospital_5_name), mContext.getString(R.string.hospital_5_detail)));
        HOSPITALS.add(new DummyItem(String.valueOf(1),mContext.getString(R.string.hospital_6_name), mContext.getString(R.string.hospital_6_detail)));
        HOSPITALS.add(new DummyItem(String.valueOf(1),mContext.getString(R.string.hospital_7_name), mContext.getString(R.string.hospital_7_detail)));
        HOSPITALS.add(new DummyItem(String.valueOf(1),mContext.getString(R.string.hospital_8_name), mContext.getString(R.string.hospital_8_detail)));
        HOSPITALS.add(new DummyItem(String.valueOf(1),mContext.getString(R.string.hospital_9_name), mContext.getString(R.string.hospital_9_detail)));
        HOSPITALS.add(new DummyItem(String.valueOf(1),mContext.getString(R.string.hospital_10_name), mContext.getString(R.string.hospital_10_detail)));

        HOTELS.add(new DummyItem(String.valueOf(1),mContext.getString(R.string.hotel_1_name), mContext.getString(R.string.hotel_1_detail)));
        HOTELS.add(new DummyItem(String.valueOf(1),mContext.getString(R.string.hotel_2_name), mContext.getString(R.string.hotel_2_detail)));
        HOTELS.add(new DummyItem(String.valueOf(1),mContext.getString(R.string.hotel_3_name), mContext.getString(R.string.hotel_3_detail)));
        HOTELS.add(new DummyItem(String.valueOf(1),mContext.getString(R.string.hotel_4_name), mContext.getString(R.string.hotel_4_detail)));
        HOTELS.add(new DummyItem(String.valueOf(1),mContext.getString(R.string.hotel_5_name), mContext.getString(R.string.hotel_5_detail)));
        HOTELS.add(new DummyItem(String.valueOf(1),mContext.getString(R.string.hotel_6_name), mContext.getString(R.string.hotel_6_detail)));
        HOTELS.add(new DummyItem(String.valueOf(1),mContext.getString(R.string.hotel_7_name), mContext.getString(R.string.hotel_7_detail)));
        HOTELS.add(new DummyItem(String.valueOf(1),mContext.getString(R.string.hotel_8_name), mContext.getString(R.string.hotel_8_detail)));

        BUSES.add(new DummyItem(String.valueOf(1),mContext.getString(R.string.bus_1_name), mContext.getString(R.string.bus_1_detail)));
        BUSES.add(new DummyItem(String.valueOf(1),mContext.getString(R.string.bus_2_name), mContext.getString(R.string.bus_2_detail)));
        BUSES.add(new DummyItem(String.valueOf(1),mContext.getString(R.string.bus_3_name), mContext.getString(R.string.bus_3_detail)));
        BUSES.add(new DummyItem(String.valueOf(1),mContext.getString(R.string.bus_4_name), mContext.getString(R.string.bus_4_detail)));
        BUSES.add(new DummyItem(String.valueOf(1),mContext.getString(R.string.bus_5_name), mContext.getString(R.string.bus_5_detail)));
        BUSES.add(new DummyItem(String.valueOf(1),mContext.getString(R.string.bus_6_name), mContext.getString(R.string.bus_6_detail)));
        BUSES.add(new DummyItem(String.valueOf(1),mContext.getString(R.string.bus_7_name), mContext.getString(R.string.bus_7_detail)));
        BUSES.add(new DummyItem(String.valueOf(1),mContext.getString(R.string.bus_8_name), mContext.getString(R.string.bus_8_detail)));
        BUSES.add(new DummyItem(String.valueOf(1),mContext.getString(R.string.bus_9_name), mContext.getString(R.string.bus_9_detail)));

        ATM_HCM.add(new DummyItem(String.valueOf(1),mContext.getString(R.string.atm_hcm_1_name), mContext.getString(R.string.atm_hcm_1_detail)));
        ATM_HCM.add(new DummyItem(String.valueOf(1),mContext.getString(R.string.atm_hcm_2_name), mContext.getString(R.string.atm_hcm_2_detail)));
        ATM_HCM.add(new DummyItem(String.valueOf(1),mContext.getString(R.string.atm_hcm_3_name), mContext.getString(R.string.atm_hcm_3_detail)));

        HOSPITALS_HCM.add(new DummyItem(String.valueOf(1),mContext.getString(R.string.hospital_hcm_1_name), mContext.getString(R.string.hospital_hcm_1_detail)));
        HOSPITALS_HCM.add(new DummyItem(String.valueOf(1),mContext.getString(R.string.hospital_hcm_2_name), mContext.getString(R.string.hospital_hcm_2_detail)));
        HOSPITALS_HCM.add(new DummyItem(String.valueOf(1),mContext.getString(R.string.hospital_hcm_3_name), mContext.getString(R.string.hospital_hcm_3_detail)));

        HOTELS_HCM.add(new DummyItem(String.valueOf(1),mContext.getString(R.string.hotel_hcm_1_name), mContext.getString(R.string.hotel_hcm_1_detail)));
        HOTELS_HCM.add(new DummyItem(String.valueOf(1),mContext.getString(R.string.hotel_hcm_2_name), mContext.getString(R.string.hotel_hcm_2_detail)));
        HOTELS_HCM.add(new DummyItem(String.valueOf(1),mContext.getString(R.string.hotel_hcm_3_name), mContext.getString(R.string.hotel_hcm_3_detail)));

        BUSES_HCM.add(new DummyItem(String.valueOf(1),mContext.getString(R.string.bus_hcm_1_name), mContext.getString(R.string.bus_hcm_1_detail)));
        BUSES_HCM.add(new DummyItem(String.valueOf(1),mContext.getString(R.string.bus_hcm_2_name), mContext.getString(R.string.bus_hcm_2_detail)));
        BUSES_HCM.add(new DummyItem(String.valueOf(1),mContext.getString(R.string.bus_hcm_3_name), mContext.getString(R.string.bus_hcm_3_detail)));
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class DummyItem {
        public final String id;
        public final String content;
        public final String details;

        public DummyItem(String id, String content, String details) {
            this.id = id;
            this.content = content;
            this.details = details;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}