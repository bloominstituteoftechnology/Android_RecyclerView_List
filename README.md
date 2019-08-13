# Android_RecyclerView_List

## Introduction

In this project, we'll be changing some of the scrollviews from previous projects to Recycler Views. This will give you more practice building up the Recycler View and less time building the foundation of the app.

## Instructions

### Part 1 - Favorite Pictures Gallery

For this project, I'll walk you through the transition

#### Prep Project
1. Open project structure under File -> Project Structure
2. Click "Dependencies"
3. Click the plus under "All Dependencies" and select "Library Dependency"
4. Type "recyclerview" in the search box and select "androidx.recyclerview" on the left and the latest version on the right

#### List Item Layout
1. Decide what information from the `ImageData` method would be useful to display in the List Activity
2. Build a layout to display that content called `image_item_layout` (this is up to you to decide what you think looks good, have fun and play around with views and attributes)
3. Give each element in this layout an id to be able to access it in the list adapter

#### Build List Adapter
1. Create a class called `ImageListAdapter` that extends `RecyclerView.Adapter<ImageListAdapter.ViewHolder>`
2. Create an Inner Class called `ViewHolder` which extends `RecyclerView.ViewHolder`
> Use the colon ':' symbol to extend classes in Kotlin
3. Add a constructor to the `ViewHolder` that accepts a `View` object
4. Add data members to this `ViewHolder` class for each of the views in your item layout
5. Pass the `View` object parameter to the parent class by adding (view) to the extension statement
6. Attach all the views in the layout to the corresponding data members using `view.view_id`
8. Add a constructor to your `ImageListAdapter` that accepts a `MutableList` of `ImageData` objects
9. Override the `onCreateViewHolder` method
> The signature should look like this `override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageListAdapter.ViewHolder`  

10. `Inflate` your item layout to a `View` object using `LayoutInflater.from(context).inflate(R.layout.image_list_view, parent, false);`
11. Pass this `View` object to a `ViewHolder` constructor and return the new `ViewHolder` object
12. Override the `onBindViewHolder` method using the signature `override fun onBindViewHolder(holder: ImageListAdapter.ViewHolder, position: Int)`
13. Use the passed position parameter to get the `ImageData` object at that position of the `ArrayList`
14. Take that object and use it to populate your layout
> Remember, you have already bound the elements of your layout to your `ViewHolder` object and can now access them through the passed instance of that object, `holder.textImageName.text = data.getName()`  
> Be sure to move your `OnClickListener` from the `TextView` generator in your `MainActivity` to this method. Remember to use `context.startActivity` to start the details activity
 
#### Attach List To Activity
Now that we have built the components for our `RecyclerView`, it's time to bolt it all together
1. Change your layout xml file to remove the `ScrollView` and `LinearLayout` and replace them with a single `RecyclerView`
2. Add data members for a `RecyclerView`, `LayoutManager` (You can pick what you want, Linear, Grid, or Staggered), and your `ImageListAdapter`
3. In your `OnCreate` method, get a handle to your `RecyclerView`
4. Call `setHasFixedSize(true)` on your `RecyclerView` object
5. Create a new `LayoutManager` of the type you chose before. Check the corresponding documentation for information on the constructors for your chosen manager
6. Set the `layoutManager` property of your `RecyclerView` to your new `LayoutManager`
7. Create a new instance of your `ImageListAdapter`, passing it the list of `ImageData` objects that you created last time
8. Set the `adapter` on your `RecyclerView`, to the instance of `ImageListAdapter`

#### Handle List Updates
Since we are going to be manually adding elements to the list, we'll have to notify the `ListAdapter` when we do so.
1. In your `onActivityResult` method, after adding an image to the list, call `notifyItemInserted()` on the listadapter and pass it the index of the element you just added (size - 1)
2. Check to make sure that if there are any other times where you edit elements in the array you are calling either `notifyItemInserted()` with the affected element or `notifyItemInserted()` without passing anything

#### Test Your App
Make sure the images you add are added to the ui and that you can select them to go into the details view

#### Challenge
Chose another app which we have built or one you build on your own and implement a `RecyclerView` in it.
