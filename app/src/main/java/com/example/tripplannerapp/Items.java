package com.example.tripplannerapp;

public class Items {

    String foodName;
    String mealCategories;
    double foodPrice;
    String foodDescription;
    int foodImage;
    double preparationTimeMinutes;

    public Items(String foodName, String mealCategories, double foodPrice, String foodDescription, int foodImage, double preparationTimeMinutes) {
        this.foodName = foodName;
        this.mealCategories = mealCategories;
        this.foodPrice = foodPrice;
        this.foodDescription = foodDescription;
        this.foodImage = foodImage;
        this.preparationTimeMinutes = preparationTimeMinutes;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getMealCategories() {
        return mealCategories;
    }

    public void setMealCategories(String mealCategories) {
        this.mealCategories = mealCategories;
    }

    public double getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(double foodPrice) {
        this.foodPrice = foodPrice;
    }

    public String getFoodDescription() {
        return foodDescription;
    }

    public void setFoodDescription(String foodDescription) {
        this.foodDescription = foodDescription;
    }

    public int getFoodImage() {
        return foodImage;
    }

    public void setFoodImage(int foodImage) {
        this.foodImage = foodImage;
    }

    public double getPreparationTimeMinutes() {
        return preparationTimeMinutes;
    }

    public void setPreparationTimeMinutes(double preparationTimeMinutes) {
        this.preparationTimeMinutes = preparationTimeMinutes;
    }
}
