/** ===============================================================================================*/
/** FILE               : RecyclerViewInterface.java                                                */
/** PROJECT            : Trip Planner App (Assignment 2)                                           */
/** PROGRAMMER         : Ermiyas (Endalkachew) Gulti                                               */
/** FIRST VERSION      : 2024-March-14                                                             */
/** DESCRIPTION        : This file contains the declaration of the RecyclerViewInterface used      */
/**                    : in the Trip Planner app.This interface defines a method to handle         */
/**                    :item clicks in a RecyclerView.                                             */
/**================================================================================================*/

package com.example.tripplannerapp;

/**
 * Interface for handling item clicks in a RecyclerView.
 */
public interface RecyclerViewInterface {

    /**
     * Called when an item in the RecyclerView is clicked.
     *
     * @param position The position of the clicked item in the RecyclerView.
     */
    void onItemClick( int position);
}
