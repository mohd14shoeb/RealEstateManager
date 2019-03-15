package com.openclassrooms.realestatemanager.db;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.openclassrooms.realestatemanager.model.RealEstate;

import java.util.List;

@Dao
public interface RealEstateDao {

    //return can be void but the long[] is the rows data were inserted
    @Insert
    long[] insertRealEstate(RealEstate... realEstates);

    //return can be void but the int is how many rows were updated
    @Update
    int updateRealEstate(RealEstate... realEstates);

    //return can be void but the int is how many rows were deleted
    @Delete
    int deleteRealEstate(RealEstate... realEstates);

    @Query("SELECT * FROM realEstateListings")
    LiveData<List<RealEstate>> getAllListings();

    @Query("SELECT * FROM realEstateListings WHERE status = :status")
    LiveData<List<RealEstate>> getListingByStatus(String status);

}