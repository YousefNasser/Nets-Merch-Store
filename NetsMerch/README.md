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

##Steps

1. Open the starter project in Android Studio

2. Add the navigation libraries to the app build.gradle file

3. Add the safe-arg plugin to the main and app build.gradle file

4. Create a new navigation xml file

5. Create a new Login destination.

   * Include email and password labels 

   - Include email and password fields
   - Create buttons for creating a new login and logging in with an existing account
   - Clicking either button should navigate to the Welcome Screen.

6. Create a new Welcome screen destination that includes:

   * A new layout
   * At least 2 textviews
   * A navigation button with actions to navigate to the instructions screen

7. Create a new Instruction destination that includes:

   * A new layout
   * At least 2 textviews
   * A navigation button with actions to navigate to the Merch list screen

8. Create a class that extends ViewModel

   *  Use a LiveData field that returns the list of Merchs

9. Create a new Merch List destination that includes:

   * A new layout
   * A ScrollView
   * A LinearLayout for Merch Items
   * A FloatingActionButton with an action to navigate to the Merch detail screen

10. In MainActivity, setup the nav controller with the toolbar and an AppBarConfiguration.

11. Create a new Merch Detail destination that includes:

    * A new layout
    * A TextView label and EditView for the
      * Merch Name
      * Company
      * Merch Size
      * Description
    * A Cancel button with an action to navigate back to the Merch list screen
    * A Save button with an action to navigate back to the Merch list screen and add a new Merch to the Merch View Model

12. Make sure you can’t go back to onboarding screens

13. In the Merch List screen:

    * Use an Activity level ViewModel to hold a list of Merchs (use by activityViewModels)
    * Observe the Merchs variable from the ViewModel
    * Use DataBindingUtil to inflate the Merch_list layout
    * Add a new layout item into the scrollview for each Merch.