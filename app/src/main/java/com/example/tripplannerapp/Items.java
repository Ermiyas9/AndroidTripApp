/** ================================================================================================*/
/** FILE               : Items.java                                                                 */
/** PROJECT            : Trip Planner App (Assignment 2)                                            */
/** PROGRAMMER         : Ermiyas (Endalkachew) Gulti                                                */
/** FIRST VERSION      : 2024-March-14                                                              */
/** DESCRIPTION        : Items.java is a class representing a food item in the Trip Planner app.    */
/**                     It contains attributes such as food name, meal categories, food price,      */
/**                     food description, food image, and preparation time. It provides getter and  */
/**                     setter methods to access and modify these attributes.                       */
/**=================================================================================================*/

package com.example.tripplannerapp;

public class Items {

    String foodName;
    String mealCategories;
    double foodPrice;
    String foodDescription;
    int foodImage;
    double preparationTimeMinutes;

    /**
     * Constructor to initialize a food item with provided attributes.
     *
     * @param foodName             Name of the food item.
     * @param mealCategories      Categories of the meal.
     * @param foodPrice           Price of the food item.
     * @param foodDescription     Description of the food item.
     * @param foodImage           Image resource ID of the food item.
     * @param preparationTimeMinutes Preparation time of the food item in minutes.
     */
    public Items(String foodName, String mealCategories, double foodPrice, String foodDescription, int foodImage, double preparationTimeMinutes) {
        this.foodName = foodName;
        this.mealCategories = mealCategories;
        this.foodPrice = foodPrice;
        this.foodDescription = foodDescription;
        this.foodImage = foodImage;
        this.preparationTimeMinutes = preparationTimeMinutes;
    }

    /**
     * Getter and Setter for the food name.
     *
     * @return The name of the food item.
     */
    public String getFoodName() {
        return foodName;
    }

    /**
     * Setter for the food name.
     *
     * @param foodName The name of the food item.
     */
    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    /**
     * Getter for the meal categories.
     *
     * @return The categories of the meal.
     */
    public String getMealCategories() {
        return mealCategories;
    }

    /**
     * Setter for the meal categories.
     *
     * @param mealCategories The categories of the meal.
     */
    public void setMealCategories(String mealCategories) {
        this.mealCategories = mealCategories;
    }

    /**
     * Getter for the food price.
     *
     * @return The price of the food item.
     */
    public double getFoodPrice() {
        return foodPrice;
    }

    /**
     * Setter for the food price.
     *
     * @param foodPrice The price of the food item.
     */
    public void setFoodPrice(double foodPrice) {
        this.foodPrice = foodPrice;
    }

    /**
     * Getter for the food description.
     *
     * @return The description of the food item.
     */
    public String getFoodDescription() {
        return foodDescription;
    }

    /**
     * Setter for the food description.
     *
     * @param foodDescription The description of the food item.
     */
    public void setFoodDescription(String foodDescription) {
        this.foodDescription = foodDescription;
    }

    /**
     * Getter for the food image.
     *
     * @return The image resource ID of the food item.
     */
    public int getFoodImage() {
        return foodImage;
    }

    /**
     * Setter for the food image.
     *
     * @param foodImage The image resource ID of the food item.
     */
    public void setFoodImage(int foodImage) {
        this.foodImage = foodImage;
    }

    /**
     * Getter for the preparation time in minutes.
     *
     * @return The preparation time of the food item in minutes.
     */
    public double getPreparationTimeMinutes() {
        return preparationTimeMinutes;
    }

    /**
     * Setter for the preparation time in minutes.
     *
     * @param preparationTimeMinutes The preparation time of the food item in minutes.
     */
    public void setPreparationTimeMinutes(double preparationTimeMinutes) {
        this.preparationTimeMinutes = preparationTimeMinutes;
    }
}
