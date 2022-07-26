# The Nets Merch Store

This project will consist of five screens. You are required to create the following screens. You will be creating:

1. Login screen: Email and password fields and labels plus create and login buttons
2. Welcome onboarding screen
3. Instructions onboarding screen
4. Merch Listing screen
5. Merch Detail screen for adding a new Merch

## Getting Started

Open the starter project in the latest stable version of Android Studio.

Open the starter project in Android Studio

## Steps

1. Open the starter project in Android Studio

2. Add the navigation libraries to the app build.gradle file

3. Add the safe-arg plugin to the main and app build.gradle file

4. Set DataBindingUtil in build.gradle 

5. Use DataBindingUtil to inflate every layout

6. Create a new navigation xml file

7. Create a new Login destination.

   * Include email and password labels
   * Include email and password fields
   * Create buttons for creating a new login and logging in with an existing account
   * Clicking either button should navigate to the Welcome Screen.

8. Create a new Welcome screen destination that includes:

   * A new layout
   * At least 2 textviews
   * A navigation button with actions to navigate to the instructions screen

9. Create a new Instruction destination that includes:

   * A new layout
   * At least 2 textviews
   * A navigation button with actions to navigate to the Merch list screen

10. Create a class that extends ViewModel

    *  Use a LiveData field that returns the list of Merchs

11. Create a new Merch List destination that includes:

    * A new layout
    * A ScrollView
    * A LinearLayout for Merch Items
    * A FloatingActionButton with an action to navigate to the Merch detail screen

12. In MainActivity, setup the nav controller with the toolbar and an AppBarConfiguration.

13. In MainActivity, add a Logout menu to return to the login screen

14. Create a new Merch Detail destination that includes:

    * A new layout
    * A TextView label and EditView for the
      * Merch Name
      * Company
      * Merch Size
      * Description
    * A Cancel button with an action to navigate back to the Merch list screen
    * A Save button with an action to navigate back to the Merch list screen and add a new Merch to the Merch View Model
      * Hint: In the Shoe List destination, to add a child view programmatically to a ViewGroup, such as LinearLayout, 
      use the addView() method. Refer to a sample implementation in the StackOverflow discussion [here](https://stackoverflow.com/questions/2395769/how-to-programmatically-add-views-to-views).

15. Make sure you can’t go back to onboarding screens
    * Use an Activity level ViewModel to hold a list of Shoes (use by activityViewModels)
    * Observe the shoes variable from the ViewModel
    * Add a new layout item into the scrollview for each shoe.

## Suggestions to Make Your Project Stand Out!

1. The student uses styling on the TextViews and buttons 

2. Layouts look nicer than the basic layout 

3. Navigation uses Capitalized names for the labels 

4. Navigation uses enter/exit animations

